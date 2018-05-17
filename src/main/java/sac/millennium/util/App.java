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

		// IAreaFuncionalService areFunc = new AreaFuncionalServiceImpl(new
		// AreaFuncionalSqlserverDAOImpl());
		// System.out.println("Probando registro Area Funcional");
		// GerenciaCentral gc = new GerenciaCentral();
		// Gerencia ge = new Gerencia();
		// AreaFuncional obj = new AreaFuncional();
		// gc.setId("0001");
		// ge.setGerenciaCentral(gc);
		// ge.setId("0001");
		// obj.setGerencia(ge);
		// obj.setId("0004");
		// obj.setCodigoPropio("2244");
		// obj.setDescripcion("Area Funcional 4");
		// obj.setDescripcionCorta("AF4");
		// obj.setEstado("1");
		// areFunc.create(obj);

		// IAreaFuncionalService areFunc = new AreaFuncionalServiceImpl(new
		// AreaFuncionalSqlserverDAOImpl());
		// System.out.println("Probando actualiza Area Funcional");
		// GerenciaCentral gc = new GerenciaCentral();
		// Gerencia ge = new Gerencia();
		// AreaFuncional obj = new AreaFuncional();
		// gc.setId("0001");
		// ge.setGerenciaCentral(gc);
		// ge.setId("0001");
		// obj.setGerencia(ge);
		// obj.setId("0004");
		// obj.setCodigoPropio("2244");
		// obj.setDescripcion("Area Funcional 4");
		// obj.setDescripcionCorta("AF4");
		// obj.setEstado("1");
		// areFunc.update(obj);

		IAreaFuncionalService areFunc = new AreaFuncionalServiceImpl(new AreaFuncionalSqlserverDAOImpl());
		System.out.println("Probando elimina Area Funcional");
		areFunc.delete("0004");

	}

}
