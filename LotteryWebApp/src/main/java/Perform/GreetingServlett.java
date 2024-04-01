package Perform;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class GreetingServlett extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GreetingServlett() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String fullName = firstName + " " + lastName;
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Congratulations!</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f0f0f0;");
        out.println("    text-align: center;");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("}");
        out.println("h2 {");
        out.println("    color: red;");
        out.println("}");
        out.println("p {");
        out.println("    color: black;");
        out.println("    font-size: 18px;");
        out.println("}");
        out.println("a {");
        out.println("    color: #808080;");
        out.println("    text-decoration: underline;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Hello, " + fullName + "!</h2>");
        out.println("<p>Congratulations! You've won " + Math.random() * 10 + " million dollars!</p>");
        out.println("<br>");
        out.println("<a href=\"index.html\">Go to main page</a>");
        out.println("</body>");
        out.println("</html>");
    }

}
