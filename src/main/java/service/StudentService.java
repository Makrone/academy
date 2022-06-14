package service;

import dao.GroupDAO;
import dao.IGroupDAO;
import dao.IStudentDAO;
import dao.StudentDAO;
import domain.Group;
import domain.Student;
import exception.DAOException;

import java.util.List;

public class StudentService {

    private static final StudentService instance = new StudentService();

    private IStudentDAO studentDAO;

    private StudentService() {
        super();
        studentDAO = new StudentDAO();

    }

    public List<Student> getAll() throws DAOException {
        return studentDAO.getAll();
    }

    public static StudentService getInstance() {
        return instance;
    }
}
