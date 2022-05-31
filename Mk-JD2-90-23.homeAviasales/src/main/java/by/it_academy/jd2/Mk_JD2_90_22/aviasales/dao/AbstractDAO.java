package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.sql.Connection;
import java.util.List;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.db.ConnectionPool;

public abstract class AbstractDAO<K, E> {

	protected ConnectionPool cp = ConnectionPool.getInstance();

	protected Connection getConnection() {
		return cp.getConnection();
	}

	protected void releaseConnection(Connection connection) {
		cp.closeConnection(connection);
	}

	public abstract List<E> getAll();

	public abstract E get(K id);

	public abstract Boolean delete(K id);

}
