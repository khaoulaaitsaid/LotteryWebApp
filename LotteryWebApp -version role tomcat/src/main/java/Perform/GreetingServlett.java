package Perform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class GreetingServlett extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vérifier si l'utilisateur a le rôle requis
        if (request.isUserInRole("tomcat")) {
            // Utilisateur autorisé, afficher le contenu de la servlet
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Welcome to the protected area!</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f0f0f0;");
            out.println("    text-align: center;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("}");
            out.println("h1 {");
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
            out.println("<h1>Welcome to the protected area!</h1>");
            out.println("<p>You have access because you have the 'tomcat' role.</p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            // Utilisateur non autorisé, renvoyer une erreur 403 (Forbidden)
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String fullName = firstName + " " + lastName;
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
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
