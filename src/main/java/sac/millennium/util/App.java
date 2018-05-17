package sac.millennium.util;

import sac.millennium.dao.impl.AreaFuncionalSqlserverDAOImpl;
import sac.millennium.service.IAreaFuncionalService;
import sac.millennium.service.impl.AreaFuncionalServiceImpl;

public class App {

	public static void main(String[] args) {

		// IPuestoService puest = new PuestoServiceImpl(new PuestoSqlserverDAOImpl());
		// System.out.println("Probando Puestos");
		// List<Puesto> listas = puest.findAll();
		// listas.forEach(x -> System.out.println(x.getId() + "-" + x.getDescripcion() +
		// "-" + x.getDescripcionCorta() + "-"
		// + x.getEstado()));
		//

		IAreaFuncionalService areFunc = new AreaFuncionalServiceImpl(new AreaFuncionalSqlserverDAOImpl());
		System.out.println("Probando elimina Area Funcional");
		areFunc.delete("0004");

	}

}
