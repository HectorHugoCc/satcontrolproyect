package sac.millennium.service.impl;

import java.util.List;

import sac.millennium.dao.IGerenciaDAO;
import sac.millennium.model.Gerencia;
import sac.millennium.service.IGerenciaService;

public class GerenciaServiceImpl implements IGerenciaService {

	IGerenciaDAO dao;
	
	public GerenciaServiceImpl(IGerenciaDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Gerencia> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int create(Gerencia obj) {
		// TODO Auto-generated method stub
		return dao.create(obj);
	}

	@Override
	public int update(Gerencia obj) {
		// TODO Auto-generated method stub
		return dao.update(obj);
	}

	@Override
	public int delete(String key) {
		// TODO Auto-generated method stub
		return dao.delete(key);
	}

	@Override
	public Gerencia findById(String key) {
		// TODO Auto-generated method stub
		return dao.findById(key);
	}

}
