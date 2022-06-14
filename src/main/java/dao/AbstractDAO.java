package dao;

import java.sql.Connection;

import db.ConnectionPool;
import exception.DAOException;

public abstract class AbstractDAO<K, E >{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ConnectionPool cp = ConnectionPool.getInstance();

	protected Connection getConnection() {
		return cp.getConnection();
	}

	protected void releaseConnection(Connection connection) {
		cp.closeConnection(connection);
	}

	public abstract Boolean delete(K id) throws DAOException;

	public abstract Long create(E entity) throws DAOException;

	public abstract Long update(E entity) throws DAOException;

}
