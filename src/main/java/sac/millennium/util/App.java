package sac.millennium.util;

import java.util.List;

import sac.millennium.dao.IGerenciaCentralDAO;
import sac.millennium.dao.IUsuarioDAO;
import sac.millennium.dao.impl.AreaFuncionalSqlserverDAOImpl;
import sac.millennium.dao.impl.GerenciaCentralSqlserverDAOImpl;
import sac.millennium.dao.impl.GerenciaSqlserverDAOImpl;
import sac.millennium.dao.impl.MenuSqlserverDAOImpl;
import sac.millennium.dao.impl.PerfilSqlserverDAOImpl;
import sac.millennium.dao.impl.PuestoSqlserverDAOImpl;
import sac.millennium.dao.impl.UsuarioSqlserverDAOImpl;
import sac.millennium.model.AreaFuncional;
import sac.millennium.model.Gerencia;
import sac.millennium.model.GerenciaCentral;
import sac.millennium.model.Menu;
import sac.millennium.model.Perfil;
import sac.millennium.model.Puesto;
import sac.millennium.model.Usuario;
import sac.millennium.service.IAreaFuncionalService;
import sac.millennium.service.IGerenciaCentralService;
import sac.millennium.service.IGerenciaService;
import sac.millennium.service.IMenuService;
import sac.millennium.service.IPerfilService;
import sac.millennium.service.IPuestoService;
import sac.millennium.service.IUsuarioService;
import sac.millennium.service.impl.AreaFuncionalServiceImpl;
import sac.millennium.service.impl.GerenciaCentralServiceImpl;
import sac.millennium.service.impl.GerenciaServiceImpl;
import sac.millennium.service.impl.MenuServiceImpl;
import sac.millennium.service.impl.PerfilServiceImpl;
import sac.millennium.service.impl.PuestoServiceImpl;
import sac.millennium.service.impl.UsuarioServiceImpl;

public class App {

	public static void main(String[] args) {
/*
		IMenuService serv = new MenuServiceImpl(new MenuSqlserverDAOImpl());
		System.out.println("Probando Menu");

		List<Menu> lista = serv.findAll();
		lista.forEach(x -> System.out.println(x.getId() + "-" + x.getContenedor() + "-" + x.getOrdenAparicion() + "-"
				+ x.getFormularioAsociado() + "-" + x.getEstado()));
		*/
		
		IPerfilService perfil = new PerfilServiceImpl(new PerfilSqlserverDAOImpl());
		System.out.println("Probando perfil");
		List<Perfil> lista = perfil.findAll();
		lista.forEach(x -> System.out.println(x.getId() + "-" + x.getDescripcion() + "-" + x.getDescripcionCorta() + "-"
				+ x.getEstado() + "-"));
		/*
		Perfil per = new Perfil();
		per.setId("0005");
		per.setDescripcion("Usuario5");
		perfil.update(per);
		*/
		
		IPuestoService puest = new PuestoServiceImpl(new PuestoSqlserverDAOImpl());
		System.out.println("Probando Puestos");
		List<Puesto> listas = puest.findAll();
		listas.forEach(x -> System.out.println(x.getId() + "-" + x.getDescripcion() + "-" + x.getDescripcionCorta() + "-"
				+ x.getEstado() + "-"));
		
		
		IGerenciaCentralService gcen = new GerenciaCentralServiceImpl(new GerenciaCentralSqlserverDAOImpl());
		System.out.println("Probando Puestos");
		List<GerenciaCentral> list = gcen.findAll();
		list.forEach(x -> System.out.println(x.getId() + "-" + x.getDescripcion() + "-" + x.getDescripcionCorta() + "-"
				+ x.getEstado() + "-"));
		
		
		IGerenciaService g = new GerenciaServiceImpl(new GerenciaSqlserverDAOImpl());
		System.out.println("Probando Puestos");
		List<Gerencia> lis = g.findAll();
		lis.forEach(x -> System.out.println(x.getId() +"-"+ x.getGerenciaCentral().getId() + "-" + x.getDescripcion() + "-" + x.getDescripcionCorta() + "-"
				+ x.getEstado() + "-"));
		
		
		IAreaFuncionalService af = new AreaFuncionalServiceImpl(new AreaFuncionalSqlserverDAOImpl());
		System.out.println("Probando Puestos");
		List<AreaFuncional> li = af.findAll();
		li.forEach(x -> System.out.println(x.getId() +"-"));
		
		/*
		Puesto p = new Puesto();
		p.setId("12");
		p.setDescripcion("aaaaaa");
		p.setDescripcionCorta("aa");
		p.setEstado("1");
		puest.create(p);*/
		/*
		IUsuarioService usu = new UsuarioServiceImpl(new UsuarioSqlserverDAOImpl());
		List<Usuario> list = usu.findAll();
		list.forEach(x -> System.out.println(x.getId() + "-" + x.getCodigo() + "-" + x.getClave() + "-"
				+ x.getEstado() + "-"));
		/*
		AreaFuncional af = new AreaFuncional();
		af.setId("0001");
		
		Perfil pe = new Perfil();
		pe.setId("0001");

		Puesto pu = new Puesto();
		pu.setId("0001");
		
		Usuario p = new Usuario();
		p.setId("00007");
		p.setCodigo("aaaaaaaa");
		p.setNombre("ana");
		p.setClave("bbbbbbbb");
		p.setCorreo("@ddddddddddd");
		p.setAreaFuncional(af);
		p.setPerfil(pe);
		p.setPuesto(pu);
		p.setEstado("1");
		usu.create(p);
		System.out.println("Probando Menu");*/
		/*
		IPerfilService perfil = new PerfilServiceImpl(new PerfilSqlserverDAOImpl());
		System.out.println("Probando Puestos");
		List<Perfil> listas = perfil.findAll();
		listas.forEach(x -> System.out.println(x.getId() + "-" + x.getDescripcion() + "-" + x.getDescripcionCorta() + "-"
				+ x.getEstado() + "-"));*/
	}

}
