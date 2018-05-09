package sac.millennium.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sac.millennium.dao.IUsuarioDAO;
import sac.millennium.model.AreaFuncional;
import sac.millennium.model.Gerencia;
import sac.millennium.model.GerenciaCentral;
import sac.millennium.model.Perfil;
import sac.millennium.model.Puesto;
import sac.millennium.model.Usuario;
import sac.millennium.util.Conexion;

public class UsuarioDAOImpl implements IUsuarioDAO {

	private Connection cx;
	ResultSet rs = null;
	PreparedStatement pstm = null;

	public UsuarioDAOImpl() {
		cx = Conexion.conectar();
	}

	@Override
	public Usuario iniciarSesion(Usuario obj) {
		Usuario usuario = null;
		try {
			String sql = "select * from usuario where codigo_usuario=? and palabra_clave_usuario=?";
			pstm = cx.prepareStatement(sql);
			pstm.setString(1, obj.getCodigo());
			pstm.setString(2, obj.getClave());
			rs = pstm.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getString("id_usuario"));
				usuario.setCodigo(rs.getString("codigo_usuario"));
				usuario.setNombre(rs.getString("nombre_usuario"));
				usuario.setClave(rs.getString("palabra_clave_usuario"));
				usuario.setCorreo(rs.getString("cuenta_correo_usuario"));
				AreaFuncional af = new AreaFuncional();
				Gerencia g = new Gerencia();
				GerenciaCentral gc = new GerenciaCentral();
				gc.setId(rs.getString("gerencia_c_pertenece_usuario"));
				g.setId(rs.getString("gerencia_pertenece_usuario"));
				g.setGerenciaCentral(gc);
				af.setId(rs.getString("area_func_pertenece_usuario"));
				af.setGerencia(g);
				usuario.setAreaFuncional(af);
				Perfil p = new Perfil();
				p.setId(rs.getString("id_perfil_usuario"));
				obj.setPerfil(p);
				Puesto pu = new Puesto();
				pu.setId(rs.getString("id_puesto_usuario"));
				usuario.setEstado(rs.getString("estado_usuario"));
			}

			cerrarRecursos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> lista = new ArrayList<>();
		try {
			Usuario obj;
			String sql = "select * from usuario";
			pstm = cx.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new Usuario();
				obj.setId(rs.getString("id_usuario"));
				obj.setCodigo(rs.getString("codigo_usuario"));
				obj.setNombre(rs.getString("nombre_usuario"));
				obj.setClave(rs.getString("palabra_clave_usuario"));
				obj.setCorreo(rs.getString("cuenta_correo_usuario"));
				AreaFuncional af = new AreaFuncional();
				Gerencia g = new Gerencia();
				GerenciaCentral gc = new GerenciaCentral();
				gc.setId(rs.getString("gerencia_c_pertenece_usuario"));
				g.setId(rs.getString("gerencia_pertenece_usuario"));
				g.setGerenciaCentral(gc);
				af.setId(rs.getString("area_func_pertenece_usuario"));
				af.setGerencia(g);
				obj.setAreaFuncional(af);
				Perfil p = new Perfil();
				p.setId(rs.getString("id_perfil_usuario"));
				obj.setPerfil(p);
				Puesto pu = new Puesto();
				pu.setId(rs.getString("id_puesto_usuario"));
				obj.setEstado(rs.getString("estado_usuario"));

				lista.add(obj);
			}
			cerrarRecursos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Usuario create(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findById(String key) {
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
