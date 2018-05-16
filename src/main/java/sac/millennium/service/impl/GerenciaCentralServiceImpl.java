package sac.millennium.service.impl;

import java.util.List;

import sac.millennium.dao.IGerenciaCentralDAO;
import sac.millennium.model.GerenciaCentral;
import sac.millennium.service.IGerenciaCentralService;

public class GerenciaCentralServiceImpl implements IGerenciaCentralService{

	IGerenciaCentralDAO dao;

	public GerenciaCentralServiceImpl(IGerenciaCentralDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<GerenciaCentral> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int create(GerenciaCentral obj) {
		// TODO Auto-generated method stub
		return dao.create(obj);
	}

	@Override
	public int update(GerenciaCentral obj) {
		// TODO Auto-generated method stub
		return dao.update(obj);
	}

	@Override
	public int delete(String key) {
		// TODO Auto-generated method stub
		return dao.delete(key);
	}

	@Override
	public GerenciaCentral findById(String key) {
		// TODO Auto-generated method stub
		return dao.findById(key);
	}

}