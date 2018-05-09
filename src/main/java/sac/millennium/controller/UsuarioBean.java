package sac.millennium.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import sac.millennium.dao.impl.UsuarioDAOImpl;
import sac.millennium.model.Usuario;
import sac.millennium.service.IUsuarioService;
import sac.millennium.service.impl.UsuarioServiceImpl;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private List<Usuario> listaUsuario;
	private String username;
	private String password;

	private IUsuarioService service = new UsuarioServiceImpl(new UsuarioDAOImpl());

	@PostConstruct
	public void init() {
		listaUsuario = service.findAll();
	}

	public String login() {
		FacesMessage message = null;
		boolean loggedIn = false;
		String redireccion = null;
		Usuario obj = new Usuario();
		obj.setCodigo(username);
		obj.setClave(password);
		Usuario user = service.iniciarSesion(obj);

		if (user != null) {
			loggedIn = true;
			redireccion = "/common/principal?faces-redirect=true";
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", user.getNombre());
		} else {
			loggedIn = false;
			redireccion = "";
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Acceso", "Credenciales inválidas");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		return redireccion;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
