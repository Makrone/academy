package service;

import dao.GroupDAO;
import dao.IGroupDAO;
import domain.Group;
import exception.DAOException;

import java.util.List;

public class GroupService {

    private static final GroupService instance = new GroupService();

    private IGroupDAO groupDAO;

    GroupService() {
        super();
        groupDAO = new GroupDAO();

    }

    public List<Group> getAll() throws DAOException {
        return groupDAO.getAll();
    }

    public static GroupService getInstance() {
        return instance;
    }
}
