package sac.millennium.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import sac.millennium.dao.IPerfilDAO;
import sac.millennium.model.Perfil;
import sac.millennium.util.Conexion;

public class PerfilSqlserverDAOImpl implements IPerfilDAO {

	private Connection cx;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;

	public PerfilSqlserverDAOImpl() {
		cx = Conexion.conectar();
	}

	@Override
	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil create(Perfil obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil update(Perfil obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Perfil findById(String key) {
		Perfil obj = null;
		try {
			String sql = "select * from perfil where id_perfil=?";
			pstm = cx.prepareStatement(sql);
			pstm.setString(1, key);
			rs = pstm.executeQuery();

			if (rs.next()) {
				obj = new Perfil();
				obj.setId(rs.getString("id_perfil"));
				obj.setDescripcion("descripcion_perfil");
				obj.setDescripcionCorta("descripcion_corta_perfil");
				obj.setEstado("estado_perfil");
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
