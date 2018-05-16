package sac.millennium.service.impl;

import java.util.List;

import sac.millennium.dao.IPerfilDAO;
import sac.millennium.model.Perfil;
import sac.millennium.service.IPerfilService;

public class PerfilServiceImpl implements IPerfilService {

	IPerfilDAO dao;

	public PerfilServiceImpl(IPerfilDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int create(Perfil obj) {
		// TODO Auto-generated method stub
		return dao.create(obj);
	}

	@Override
	public int update(Perfil obj) {
		// TODO Auto-generated method stub
		return dao.update(obj);
	}

	@Override
	public int delete(String key) {
		// Auto-generated method stub
		return dao.delete(key);
	}

	@Override
	public Perfil findById(String key) {
		return dao.findById(key);
	}

}
