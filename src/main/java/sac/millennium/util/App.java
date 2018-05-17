package sac.millennium.util;

import sac.millennium.dao.impl.AreaFuncionalSqlserverDAOImpl;
import sac.millennium.service.IAreaFuncionalService;
import sac.millennium.service.impl.AreaFuncionalServiceImpl;

public class App {

	public static void main(String[] args) {

		IAreaFuncionalService areFunc = new AreaFuncionalServiceImpl(new AreaFuncionalSqlserverDAOImpl());
		System.out.println("Probando elimina Area Funcional");
		areFunc.delete("0004");

	}

}
