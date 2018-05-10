package sac.millennium.service.impl;

import java.util.List;

import sac.millennium.dao.IMenuDAO;
import sac.millennium.model.Menu;
import sac.millennium.model.Perfil;
import sac.millennium.service.IMenuService;

public class MenuServiceImpl implements IMenuService {

	IMenuDAO dao;

	public MenuServiceImpl(IMenuDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Menu> findMenuByPerfil(Perfil perfil) {
		return dao.findMenuByPerfil(perfil);
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu create(Menu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu update(Menu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Menu findById(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
