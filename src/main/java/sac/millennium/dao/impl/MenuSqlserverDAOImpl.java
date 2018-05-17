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
				obj.setContenedor(rs.getString("contenedor_menu"));
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
	public List<Menu> listaContenedores() {
		List<Menu> lista = new ArrayList<>();
		Menu obj = null;
		try {
			String sql = "select * from menu where formulario_asociado_menu='#'";
			pstm = cx.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				obj = new Menu();
				obj.setId(rs.getString("id_menu"));
				obj.setContenedor(rs.getString("contenedor_menu"));
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
		List<Menu> lista = new ArrayList<>();
		Menu obj = null;
		try {
			String sql = "select * from menu";
			pstm = cx.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				obj = new Menu();
				obj.setId(rs.getString("id_menu"));
				obj.setContenedor(rs.getString("contenedor_menu"));
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
	public int create(Menu obj) {
		int estado = -1;
		try {
			String sql = "INSERT INTO menu(id_menu, contenedor_menu, orden_aparicion_menu, nombre_opcion_menu, formulario_asociado_menu, estado_registro_menu)\r\n"
					+ "VALUES (?,?,?,?,?,?)";
			pstm = cx.prepareStatement(sql);
			pstm.setString(1, obj.getId());
			pstm.setString(2, obj.getContenedor());
			pstm.setInt(3, obj.getOrdenAparicion());
			pstm.setString(4, obj.getNombreOpcion());
			pstm.setString(5, obj.getFormularioAsociado());
			pstm.setString(6, obj.getEstado());
			estado = pstm.executeUpdate();
			cerrarRecursos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int update(Menu obj) {
		int estado = -1;
		try {
			String sql = "update menu set contenedor_menu=?,orden_aparicion_menu=?,nombre_opcion_menu=?,formulario_asociado_menu=?,estado_registro_menu=? where id_menu=?;";
			pstm = cx.prepareStatement(sql);
			pstm.setString(1, obj.getContenedor());
			pstm.setInt(2, obj.getOrdenAparicion());
			pstm.setString(3, obj.getNombreOpcion());
			pstm.setString(4, obj.getFormularioAsociado());
			pstm.setString(5, obj.getEstado());
			pstm.setString(6, obj.getId());
			estado = pstm.executeUpdate();
			cerrarRecursos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int delete(String key) {
		int estado = -1;
		try {
			String sql = "delete from menu where id_menu='88'";
			pstm = cx.prepareStatement(sql);
			pstm.setString(1, key);
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public Menu findById(String key) {
		Menu obj = null;
		try {
			String sql = "select * from menu where id_menu=?";
			pstm = cx.prepareStatement(sql);
			pstm.setString(1, key);
			rs = pstm.executeQuery();

			if (rs.next()) {
				obj = new Menu();
				obj.setId(rs.getString("id_menu"));
				obj.setContenedor(rs.getString("contenedor_menu"));
				obj.setOrdenAparicion(rs.getInt("orden_aparicion_menu"));
				obj.setNombreOpcion(rs.getString("nombre_opcion_menu"));
				obj.setFormularioAsociado(rs.getString("formulario_asociado_menu"));
				obj.setEstado(rs.getString("estado_registro_menu"));
			}
			cerrarRecursos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
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
