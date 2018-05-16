package sac.millennium.util;

import java.util.List;

import sac.millennium.dao.impl.PuestoSqlserverDAOImpl;
import sac.millennium.model.Puesto;
import sac.millennium.service.IPuestoService;
import sac.millennium.service.impl.PuestoServiceImpl;

public class App {

	public static void main(String[] args) {

		
		IPuestoService puest = new PuestoServiceImpl(new PuestoSqlserverDAOImpl());
		System.out.println("Probando Puestos");
		List<Puesto> listas = puest.findAll();
		listas.forEach(x -> System.out.println(x.getId() + "-" + x.getDescripcion() + "-" + x.getDescripcionCorta() + "-"
				+ x.getEstado() + "-"));
		
	}

}
