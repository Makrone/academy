package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Group;
import exception.DAOException;

public class GroupDAO extends AbstractDAO<Long, Group> implements IGroupDAO{

	private static final String SELECT_ALL_GROUP = "SELECT * FROM demoper.person.group";
	private static final String SELECT_GROUP_BY_ID = "SELECT * FROM demoper.person.group WHERE ID = ?";
	private static final String CREATED_GROUP= "INSERT INTO demoper.person.group (id, name) values(?,?)";
	private static final String DELETE_GROUP_BY_ID = "DELETE FROM demoper.person.group WHERE ID = ?";
	private static final String UPDATED_GROUP_BY_ID = "UPDATE demoper.person.group SET id = ?, name = ?";

	@Override
	public List<Group> getAll() throws DAOException {
		Connection c = getConnection();
		List<Group> group = new ArrayList<>();

		try (Statement statement = c.createStatement()) {
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_GROUP);
			while (resultSet.next()) {
				group.add(populateGroup(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException("Get all error by Group", e);
		} finally {
			releaseConnection(c);
		}

		return group;
	}

	@Override
	public Group get(Long id) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_GROUP_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return populateGroup(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException("Get by id error by Group in DAO", e);
		} finally {
			releaseConnection(c);
		}

		return null;
	}

	@Override
	public Boolean delete(Long id) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_GROUP_BY_ID)) {
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new DAOException("Delete error of Group DAO", e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Long create(Group entity) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_GROUP,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setLong(1, entity.getId());
			preparedStatement.setString(2, entity.getName());
			if (preparedStatement.executeUpdate() == 0) {
				throw new DAOException("Creating group failed in dao, no rows affected.");
			}
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					entity.setId(generatedKeys.getLong(1));
				}

			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Create error by Group", e);
		} finally {
			releaseConnection(c);
		}
	}

	@Override
	public Long update(Group entity) throws DAOException {
		Connection c = getConnection();
		try (PreparedStatement preparedStatement = c.prepareStatement(UPDATED_GROUP_BY_ID)) {
			if (entity.getId() == null) {
				throw new DAOException("Entity id can't be null. ");
			}
			preparedStatement.setLong(1, entity.getId());
			preparedStatement.setString(2, entity.getName());
			if (preparedStatement.executeUpdate() > 1) {
				throw new DAOException("Updated more then one entity. Entity ID: " + entity.getId());
			}
			return entity.getId();
		} catch (SQLException e) {
			throw new DAOException("Update error by Group dao", e);
		} finally {
			releaseConnection(c);
		}
	}

	private Group populateGroup(ResultSet resultSet) throws SQLException {
		Group group = new Group();
		group.setId(resultSet.getLong(Fields.GROUP_ID));
		group.setName(resultSet.getString(Fields.GROUP_NAME));

		return group;
	}

	class Fields {
		private static final String GROUP_ID = "id";
		private static final String GROUP_NAME = "name";

	}

}
