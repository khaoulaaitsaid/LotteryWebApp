package Perform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlett extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GreetingServlett() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome to the virtual lottery!</h1>");
        out.println("<p>Please enter your information in the form below:</p>");
        out.println("<form action=\"GreetingServlet\" method=\"post\">");
        out.println("First Name: <input type=\"text\" name=\"firstname\"><br>");
        out.println("Last Name: <input type=\"text\" name=\"lastname\"><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String fullName = firstName + " " + lastName;
        
        out.println("<html><body>");
        out.println("<h1>Hello, " + fullName + "!</h1>");
        out.println("<p>Congratulations! You've won " + Math.random() * 10 + " million dollars!</p>");
        out.println("<a href=\"index.html\">Go back to main page</a>");
        out.println("</body></html>");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("PUT method is not supported in this servlet.");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("DELETE method is not supported in this servlet.");
    }

    protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("HEAD method is not supported in this servlet.");
    }

    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("OPTIONS method is not supported in this servlet.");
    }

    protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("TRACE method is not supported in this servlet.");
    }
}
