package sac.millennium.service.impl;

import java.util.List;
import sac.millennium.dao.IPuestoDAO;
import sac.millennium.model.Puesto;
import sac.millennium.service.IPuestoService;

public class PuestoServiceImpl implements IPuestoService{
	
	IPuestoDAO dao;
	
	public PuestoServiceImpl(IPuestoDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Puesto> findAll() {
		return dao.findAll();
	}

	@Override
	public int create(Puesto obj) {
		// TODO Auto-generated method stub
		return dao.create(obj);
	}

	@Override
	public int update(Puesto obj) {
		// TODO Auto-generated method stub
		return dao.update(obj);
	}

	@Override
	public int delete(String key) {
		// TODO Auto-generated method stub
		return dao.delete(key);
	}

	@Override
	public Puesto findById(String key) {
		// TODO Auto-generated method stub
		return dao.findById(key);
	}

}
