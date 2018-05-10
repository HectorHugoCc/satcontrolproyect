package sac.millennium.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;

import sac.millennium.dao.IMenuDAO;
import sac.millennium.dao.IPerfilDAO;
import sac.millennium.dao.IUsuarioDAO;
import sac.millennium.dao.impl.MenuSqlserverDAOImpl;
import sac.millennium.dao.impl.PerfilSqlserverDAOImpl;
import sac.millennium.dao.impl.UsuarioSqlserverDAOImpl;
import sac.millennium.model.Menu;
import sac.millennium.model.Perfil;
import sac.millennium.model.Usuario;
import sac.millennium.service.IMenuService;
import sac.millennium.service.IPerfilService;
import sac.millennium.service.IUsuarioService;
import sac.millennium.service.impl.MenuServiceImpl;
import sac.millennium.service.impl.PerfilServiceImpl;
import sac.millennium.service.impl.UsuarioServiceImpl;

@ManagedBean
@SessionScoped
public class LoginBean {

	// DAO
	private IUsuarioDAO daoUsuario = new UsuarioSqlserverDAOImpl();
	private IPerfilDAO daoPerfil = new PerfilSqlserverDAOImpl();
	private IMenuDAO daoMenu = new MenuSqlserverDAOImpl();

	// globales
	private Usuario usuario;
	private Perfil perfil;
	private List<Menu> listaMenu;

	// services
	private IUsuarioService service = new UsuarioServiceImpl(daoUsuario);
	private IPerfilService servPerfil = new PerfilServiceImpl(daoPerfil);
	private IMenuService servMenu = new MenuServiceImpl(daoMenu);

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		perfil = new Perfil();
		listaMenu = new ArrayList<>();
	}

	public void login(ActionEvent event) {
		FacesMessage message = null;
		boolean loggedIn = false;
		String ruta = "";
		this.usuario = service.iniciarSesion(this.usuario);

		if (this.usuario != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",
					this.usuario.getCodigo());
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido(a)", usuario.getNombre());
			ruta = "/satcontrolproyect/common/principal.xhtml";
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de acceso", "Credenciales incorrectas");
			this.usuario = new Usuario();
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
	}

	/*
	 * getters & setters
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		perfil = servPerfil.findById(this.usuario.getPerfil().getId());
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Menu> getListaMenu() {
		listaMenu = servMenu.findMenuByPerfil(perfil);
		return listaMenu;
	}

	public void setListaMenu(List<Menu> listaMenu) {
		this.listaMenu = listaMenu;
	}

}
