package dao;

import domain.Group;
import exception.DAOException;

import java.util.List;

public interface IGroupDAO {

        List<Group> getAll()throws DAOException;

        Group get(Long id)throws DAOException;
}

