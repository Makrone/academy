package servlet;

import exception.DAOException;
import service.GroupService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonServlet", urlPatterns = "/servlet/personIndex")
    public class PersonServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;
        private final GroupService groupService;
        private final StudentService studentService;

        public PersonServlet() {
            super();
            this.groupService = GroupService.getInstance();
            this.studentService = StudentService.getInstance();
        }

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=utf-8");
            try {
                req.setAttribute("***", groupService.getAll());
            } catch (DAOException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("/jsp/person.jsp").forward(req, resp);
        }
}
