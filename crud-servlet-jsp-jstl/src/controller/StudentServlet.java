package controller;

import dao.StudentDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = "/studentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                registerNewStudent(request, response);
                break;
            case "update":
                updateInfoStudent(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {

            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "detail":
                getInfoStudent(request, response);
                break;
            case "update":
                goUpdate(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                goStudentList(request, response);
                break;
        }
    }

    private void goStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", StudentDao.getListStudent());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void registerNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student student = new Student(id, name, dateOfBirth);
        StudentDao.save(student);

        request.setAttribute("message", "Register new student successfully!!");
        goStudentList(request, response);
    }

    private void getInfoStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Student student = StudentDao.findById(id);

        request.setAttribute("student", student);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }


    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Student student = StudentDao.findById(id);

        request.setAttribute("student", student);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    private void updateInfoStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student student = new Student(id, name, dateOfBirth);
        StudentDao.save(student);

        request.setAttribute("message", "Update information successfully!!");
        goStudentList(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        StudentDao.deleteById(id);

        request.setAttribute("message", "Delete successfully!!");
        goStudentList(request, response);
    }
}
