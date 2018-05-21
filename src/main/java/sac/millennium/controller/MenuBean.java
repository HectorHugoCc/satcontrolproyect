package sac.millennium.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sac.millennium.dao.IMenuDAO;
import sac.millennium.dao.IPerfilDAO;
import sac.millennium.dao.impl.MenuSqlserverDAOImpl;
import sac.millennium.dao.impl.PerfilSqlserverDAOImpl;
import sac.millennium.model.Menu;
import sac.millennium.model.Perfil;
import sac.millennium.service.IMenuService;
import sac.millennium.service.IPerfilService;
import sac.millennium.service.impl.MenuServiceImpl;
import sac.millennium.service.impl.PerfilServiceImpl;

@ManagedBean
@ApplicationScoped
public class MenuBean implements Serializable {

	private static final long serialVersionUID = -4656629421354393217L;

	// DAO
	private IMenuDAO daoMenu = new MenuSqlserverDAOImpl();
	private IPerfilDAO daoPerfil = new PerfilSqlserverDAOImpl();

	// service
	private IMenuService servMenu = new MenuServiceImpl(daoMenu);
	private IPerfilService servPerfil = new PerfilServiceImpl(daoPerfil);

	// globales
	private List<Menu> listamenu;
	private List<Menu> listaContenedores;
	private List<Perfil> listaPefil;
	private Menu menu;
	private String tipoMenu;
	private String perfil;

	@PostConstruct
	public void init() {
		listamenu = new ArrayList<>();
		listaContenedores = new ArrayList<>();
		listaPefil = new ArrayList<>();
		listarTodo();
		listarContendores();
		listarPerfiles();
		menu = new Menu();
	}

	public void guardar() {
		System.out.println("Guardando-......" + this.menu.getContenedor() + this.menu.getFormularioAsociado()
				+ this.menu.getOrdenAparicion());
		servMenu.create(menu);
	}

	private void listarTodo() {
		listamenu = servMenu.findAll();
	}

	private void listarContendores() {
		listaContenedores = servMenu.listaContenedores();
	}

	private void listarPerfiles() {
		listaPefil = servPerfil.findAll();
	}

	/*
	 * getters & setters
	 */
	public List<Menu> getListamenu() {
		return listamenu;
	}

	public void setListamenu(List<Menu> listamenu) {
		this.listamenu = listamenu;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getTipoMenu() {
		return tipoMenu;
	}

	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public List<Menu> getListaContenedores() {
		return listaContenedores;
	}

	public void setListaContenedores(List<Menu> listaContenedores) {
		this.listaContenedores = listaContenedores;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getListaPefil() {
		return listaPefil;
	}

	public void setListaPefil(List<Perfil> listaPefil) {
		this.listaPefil = listaPefil;
	}

}
