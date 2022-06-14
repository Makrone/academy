package test;

import dao.GroupDAO;
import dao.IGroupDAO;
import domain.Group;
import exception.DAOException;

public class CreateGroupTest {

	public static void main(String[] args) throws DAOException {
		Group md = new Group();
		md.setName("Aspirin");
		IGroupDAO med = new GroupDAO();
		Group mre = med.get(1l);
		
		System.out.println(mre);
	}

}
