package sac.millennium.service.impl;

import java.util.List;

import sac.millennium.dao.IUsuarioDAO;
import sac.millennium.model.Usuario;
import sac.millennium.service.IUsuarioService;

public class UsuarioServiceImpl implements IUsuarioService {

	IUsuarioDAO dao;

	public UsuarioServiceImpl(IUsuarioDAO dao) {
		this.dao = dao;
	}

	@Override
	public Usuario iniciarSesion(Usuario obj) {
		return dao.iniciarSesion(obj);
	}

	@Override
	public List<Usuario> findAll() {
		return dao.findAll();
	}

	@Override
	public Usuario create(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findById(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
