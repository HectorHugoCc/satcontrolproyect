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
		return dao.findAll();
	}

	@Override
	public int create(Menu obj) {
		return dao.create(obj);
	}

	@Override
	public int update(Menu obj) {
		return dao.update(obj);
	}

	@Override
	public int delete(String key) {
		return dao.delete(key);
	}

	@Override
	public Menu findById(String key) {
		return dao.findById(key);
	}

}
