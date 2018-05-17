package sac.millennium.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sac.millennium.dao.IMenuDAO;
import sac.millennium.dao.impl.MenuSqlserverDAOImpl;
import sac.millennium.model.Menu;
import sac.millennium.service.IMenuService;
import sac.millennium.service.impl.MenuServiceImpl;

@ManagedBean
@ApplicationScoped
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// DAO
	private IMenuDAO daoMenu = new MenuSqlserverDAOImpl();

	// service
	private IMenuService servMenu = new MenuServiceImpl(daoMenu);

	// globales
	List<Menu> listamenu;
	List<Menu> listaContenedores;
	Menu menu;
	String tipoMenu;
	String perfil;

	@PostConstruct
	public void init() {
		listamenu = new ArrayList<>();
		listaContenedores = new ArrayList<>();
		listarTodo();
		listarContendores();
		menu = new Menu();
	}

	private void listarTodo() {
		listamenu = servMenu.findAll();
	}

	private void listarContendores() {
		listaContenedores = servMenu.listaContenedores();
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

}
