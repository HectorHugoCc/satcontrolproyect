package sac.millennium.util;

import java.util.List;

import sac.millennium.dao.impl.UsuarioDAOImpl;
import sac.millennium.model.Usuario;
import sac.millennium.service.IUsuarioService;
import sac.millennium.service.impl.UsuarioServiceImpl;

public class App {

	public static void main(String[] args) {

		IUsuarioService serv = new UsuarioServiceImpl(new UsuarioDAOImpl());
		System.out.println("Lista de usuarios");
		List<Usuario> lista = serv.findAll();

		for (Usuario u : lista) {
			System.out.println(u.getId() + " - " + u.getNombre());
		}
	}

}
