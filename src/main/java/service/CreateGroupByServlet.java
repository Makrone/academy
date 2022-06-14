package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Group;

public class CreateGroupByServlet {
	private static final String NAME = "name";

	private GroupService groupService;
	public CreateGroupByServlet() {
		super();
		groupService = new GroupService();
	}
	
	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			Group group = new Group();
			group.setName(request.getParameter(NAME));
			return "/pages/login.jsp";
		}
	}

