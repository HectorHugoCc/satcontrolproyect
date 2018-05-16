package sac.millennium.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import sac.millennium.dao.IAreaFuncionalDAO;
import sac.millennium.model.AreaFuncional;
import sac.millennium.util.Conexion;

public class AreaFuncionalSqlserverDAOImpl implements IAreaFuncionalDAO {

	private Connection cx;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;

	public AreaFuncionalSqlserverDAOImpl() {
		cx = Conexion.conectar();
	}
	
	
	@Override
	public List<AreaFuncional> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int create(AreaFuncional obj) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int update(AreaFuncional obj) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int delete(String key) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public AreaFuncional findById(String key) {
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
