package sac.millennium.dao;

import java.util.List;

import sac.millennium.model.Menu;
import sac.millennium.model.Perfil;
import sac.millennium.util.IGenericCRUD;

public interface IMenuDAO extends IGenericCRUD<Menu, String> {

	List<Menu> findMenuByPerfil(Perfil perfil);

	List<Menu> listaContenedores();

	List<Menu> listaContenedoresHermanos();

	List<Menu> listaContenedoresHermanos(Menu menu);

	List<Menu> listaItemsHermanos(Menu menu);
}
