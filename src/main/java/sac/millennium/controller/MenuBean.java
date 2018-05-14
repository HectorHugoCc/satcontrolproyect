package sac.millennium.controller;

import java.io.Serializable;
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

	@PostConstruct
	public void init() {
		listarTodo();
	}

	private void listarTodo() {
		listamenu = servMenu.findAll();
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

}
