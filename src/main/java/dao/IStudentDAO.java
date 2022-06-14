package dao;

import java.util.List;

import domain.Student;
import exception.DAOException;

public interface IStudentDAO {
    List<Student> getAll() throws DAOException;

    Student get(Long id) throws DAOException;
}
