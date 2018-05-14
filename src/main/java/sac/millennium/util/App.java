package sac.millennium.util;

import java.util.List;

import sac.millennium.dao.impl.MenuSqlserverDAOImpl;
import sac.millennium.model.Menu;
import sac.millennium.service.IMenuService;
import sac.millennium.service.impl.MenuServiceImpl;

public class App {

	public static void main(String[] args) {

		IMenuService serv = new MenuServiceImpl(new MenuSqlserverDAOImpl());
		System.out.println("Probando Menu");

		List<Menu> lista = serv.findAll();
		lista.forEach(x -> System.out.println(x.getId() + "-" + x.getContenedor() + "-" + x.getOrdenAparicion() + "-"
				+ x.getFormularioAsociado() + "-" + x.getEstado()));
	}

}
