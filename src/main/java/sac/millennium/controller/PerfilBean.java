package sac.millennium.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import sac.millennium.dao.IPerfilDAO;
import sac.millennium.dao.impl.PerfilSqlserverDAOImpl;
import sac.millennium.model.Perfil;
import sac.millennium.service.IPerfilService;
import sac.millennium.service.impl.PerfilServiceImpl;

@ManagedBean
@ApplicationScoped
public class PerfilBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private IPerfilDAO daoPerfil = new PerfilSqlserverDAOImpl();
	private IPerfilService servPerfil = new PerfilServiceImpl(daoPerfil);

	List<Perfil> listaPerfil;

	@PostConstruct
	public void init() {
		listarTodo();
	}

	private void listarTodo() {
		listaPerfil = servPerfil.findAll();
	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

}
