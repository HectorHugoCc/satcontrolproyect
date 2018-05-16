package sac.millennium.service.impl;

import java.util.List;

import sac.millennium.dao.IAreaFuncionalDAO;
import sac.millennium.model.AreaFuncional;
import sac.millennium.service.IAreaFuncionalService;

public class AreaFuncionalServiceImpl implements IAreaFuncionalService{

	IAreaFuncionalDAO dao;
	
	public AreaFuncionalServiceImpl(IAreaFuncionalDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<AreaFuncional> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int create(AreaFuncional obj) {
		// TODO Auto-generated method stub
		return dao.create(obj);
	}

	@Override
	public int update(AreaFuncional obj) {
		// TODO Auto-generated method stub
		return dao.update(obj);
	}

	@Override
	public int delete(String key) {
		// TODO Auto-generated method stub
		return dao.delete(key);
	}

	@Override
	public AreaFuncional findById(String key) {
		// TODO Auto-generated method stub
		return dao.findById(key);
	}

}