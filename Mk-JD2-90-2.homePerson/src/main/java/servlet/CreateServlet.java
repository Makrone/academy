package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GroupService;
import service.StudentService;

@WebServlet(name = "CreateServlet", urlPatterns = "/servlet/createServlet")
public class CreateServlet extends HttpServlet{

        private static final long serialVersionUID = 1L;
        private final GroupService groupService;
        private final StudentService studentService;

        public CreateServlet() {
            super();
            this.groupService = GroupService.getInstance();
            this.studentService = StudentService.getInstance();
        }

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=utf-8");
            req.getRequestDispatcher("/jsp/createStudent.jsp").forward(req, resp);
        }

}
