package sac.millennium.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

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
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5844963453614414477L;

	// DAO
	private IUsuarioDAO daoUsuario = new UsuarioSqlserverDAOImpl();
	private IPerfilDAO daoPerfil = new PerfilSqlserverDAOImpl();
	private IMenuDAO daoMenu = new MenuSqlserverDAOImpl();

	// services
	private IUsuarioService service = new UsuarioServiceImpl(daoUsuario);
	private IPerfilService servPerfil = new PerfilServiceImpl(daoPerfil);
	private IMenuService servMenu = new MenuServiceImpl(daoMenu);

	// globals
	private Usuario usuario;
	private Perfil perfil;
	private List<Menu> listaMenu;
	private MenuModel model;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		perfil = new Perfil();
		listaMenu = new ArrayList<>();
		model = new DefaultMenuModel();
	}

	public String login(ActionEvent event) {
		FacesMessage message = null;
		boolean loggedIn = false;
		String redireccion = null;
		this.usuario = service.iniciarSesion(this.usuario);

		if (this.usuario != null) {
			perfil = servPerfil.findById(this.usuario.getPerfil().getId());
			listaMenu = servMenu.findMenuByPerfil(perfil);
			listaMenu.forEach(x -> System.out.println(x.getFormularioAsociado()));
			construirMenu();
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido(a)", usuario.getNombre());
			redireccion = "/satcontrolproyect/common/principal.jsf";
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de acceso", "Credenciales incorrectas");
			this.usuario = new Usuario();
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		PrimeFaces.current().ajax().addCallbackParam("ruta", redireccion);

		return redireccion;
	}

	public void construirMenu() {
		DefaultSubMenu firstSubmenu;
		DefaultSubMenu secondSubmenu;
		DefaultMenuItem item;
		for (Menu m : listaMenu) {
			if (m.getFormularioAsociado().equals("#") && m.getId().equals(m.getContenedor())) {
				firstSubmenu = new DefaultSubMenu(m.getNombreOpcion());
				for (Menu sm : listaMenu) {
					if (sm.getFormularioAsociado().equals("#") && !sm.getId().equals(m.getId())) {
						secondSubmenu = new DefaultSubMenu(sm.getNombreOpcion());
					} else {
						// Menu submenu = (sm.getContenedor().equals(m.getId())) ? sm : null;
						// if (submenu != null) {
						if (!sm.getId().equals(m.getId())) {
							item = new DefaultMenuItem(sm.getNombreOpcion());
							item.setUrl(sm.getFormularioAsociado());
							firstSubmenu.addElement(item);
						}
						// }
					}
				}
				model.addElement(firstSubmenu);
			} else {
				if (!m.getFormularioAsociado().equals("#") && m.getId().equals(m.getContenedor())) {
					item = new DefaultMenuItem(m.getNombreOpcion());
					item.setUrl(m.getFormularioAsociado());
					model.addElement(item);
				}
			}
		}
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
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Menu> getListaMenu() {
		return listaMenu;
	}

	public void setListaMenu(List<Menu> listaMenu) {
		this.listaMenu = listaMenu;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

}
