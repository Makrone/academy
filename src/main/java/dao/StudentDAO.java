package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Student;
import exception.DAOException;

public class StudentDAO extends AbstractDAO<Long, Student> implements IStudentDAO{

    private static final String SELECT_ALL_STUDENT = "SELECT * FROM demoper.person.student";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM demoper.person.student WHERE ID = ?";
    private static final String CREATED_STUDENT= "INSERT INTO demoper.person.student (id, name,age,score,olympicGamer) values(?,?,?,?,?)";
    private static final String DELETE_STUDENT_BY_ID = "DELETE FROM demoper.person.student WHERE ID = ?";
    private static final String UPDATED_STUDENT_BY_ID = "UPDATE demoper.person.student SET id = ?, name = ?, age = ?,score = ?, olympicGamer = ?";

    @Override
    public List<Student> getAll() throws DAOException {
        Connection c = getConnection();
        List<Student> student = new ArrayList<>();

        try (Statement statement = c.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENT);
            while (resultSet.next()) {
                student.add(populateStudent(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("Get all error by sTUDENT", e);
        } finally {
            releaseConnection(c);
        }

        return student;
    }

    @Override
    public Student get(Long id) throws DAOException {
        Connection c = getConnection();
        try (PreparedStatement preparedStatement = c.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return populateStudent(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("Get by id error by Group", e);
        } finally {
            releaseConnection(c);
        }

        return null;
    }

    @Override
    public Boolean delete(Long id) throws DAOException {
        Connection c = getConnection();
        try (PreparedStatement preparedStatement = c.prepareStatement(DELETE_STUDENT_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DAOException("Delete error of Student DAO", e);
        } finally {
            releaseConnection(c);
        }
    }

    @Override
    public Long create(Student entity) throws DAOException {
        Connection c = getConnection();
        try (PreparedStatement preparedStatement = c.prepareStatement(CREATED_STUDENT,
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.setDouble(4,entity.getScore());
            preparedStatement.setBoolean(5,entity.getOlympicGamer());
            if (preparedStatement.executeUpdate() == 0) {
                throw new DAOException("Creating student failed in dao, no rows affected.");
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
    public Long update(Student entity) throws DAOException {
        return null;
    }

    private Student populateStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong(Fields.STUDENT_ID));
        student.setName(resultSet.getString(Fields.STUDENT_NAME));
        student.setAge(resultSet.getInt(Fields.STUDENT_AGE));
        student.setScore(resultSet.getDouble(Fields.STUDENT_SCORE));
        student.setOlympicGamer(resultSet.getBoolean(Fields.STUDENT_OLYMPICGAMER));

        return student;
    }

    class Fields {
        private static final String STUDENT_ID = "id";
        private static final String STUDENT_NAME = "name";
        private static final String STUDENT_AGE = "age";
        private static final String STUDENT_SCORE = "score";
        private static final String STUDENT_OLYMPICGAMER = "olympicGamer";

    }
}
