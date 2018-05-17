package sac.millennium.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import sac.millennium.dao.IAreaFuncionalDAO;
import sac.millennium.model.AreaFuncional;
import sac.millennium.util.Conexion;

public class AreaFuncionalSqlserverDAOImpl implements IAreaFuncionalDAO {

	@SuppressWarnings("unused")
	private Connection cx;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;

	public AreaFuncionalSqlserverDAOImpl() {
		cx = Conexion.conectar();
	}

	@Override
	public List<AreaFuncional> findAll() {
		return null;
	}

	@Override
	public int create(AreaFuncional obj) {
		return 0;
	}

	@Override
	public int update(AreaFuncional obj) {
		return 0;
	}

	@Override
	public int delete(String key) {
		return 0;
	}

	@Override
	public AreaFuncional findById(String key) {
		return null;
	}

	@SuppressWarnings("unused")
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
