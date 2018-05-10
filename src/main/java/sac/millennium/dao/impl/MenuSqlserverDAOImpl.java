package sac.millennium.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sac.millennium.dao.IMenuDAO;
import sac.millennium.model.Menu;
import sac.millennium.model.Perfil;
import sac.millennium.util.Conexion;

public class MenuSqlserverDAOImpl implements IMenuDAO {

	private Connection cx;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;

	public MenuSqlserverDAOImpl() {
		cx = Conexion.conectar();
	}

	@Override
	public List<Menu> findMenuByPerfil(Perfil perfil) {
		List<Menu> lista = new ArrayList<>();
		Menu obj = null;
		try {
			String sql = "select * from menu m join r_perfil_menu r on m.id_menu = r.id_menu where r.id_perfil=?";
			pstm = cx.prepareStatement(sql);
			pstm.setString(1, perfil.getId());
			rs = pstm.executeQuery();

			while (rs.next()) {
				obj = new Menu();
				obj.setId(rs.getString("id_menu"));
				obj.setContenedor(rs.getInt("contenedor_menu"));
				obj.setOrdenAparicion(rs.getInt("orden_aparicion_menu"));
				obj.setNombreOpcion(rs.getString("nombre_opcion_menu"));
				obj.setFormularioAsociado(rs.getString("formulario_asociado_menu"));
				obj.setEstado(rs.getString("estado_registro_menu"));
				lista.add(obj);
			}
			cerrarRecursos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu create(Menu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu update(Menu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Menu findById(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	private void cerrarRecursos() {
		try {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
