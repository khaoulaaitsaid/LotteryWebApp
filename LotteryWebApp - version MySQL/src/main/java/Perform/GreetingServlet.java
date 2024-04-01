package Perform;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class GreetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LotteryDAO lotteryDAO;

    public void init() throws ServletException {
        try {
            lotteryDAO = new LotteryDAO();
        } catch (Exception ex) {
            throw new ServletException("Database initialization failed", ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<LotteryWinner> winners = lotteryDAO.getAllWinners();
            // Afficher les gagnants dans la réponse
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Lottery Winners</h1>");
            for (LotteryWinner winner : winners) {
                out.println("<p>" + winner.getFullName() + " - $" + winner.getAmount() + " million</p>");
            }
            out.println("</body></html>");
        } catch (SQLException ex) {
            throw new ServletException("Database operation failed", ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Traitement du formulaire d'inscription des gagnants
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        double amount = Math.random() * 10; // Génération aléatoire du montant du gain
        try {
            lotteryDAO.addWinner(new LotteryWinner(firstName, lastName, amount));
            response.sendRedirect(request.getContextPath() + "/hello");
        } catch (SQLException ex) {
            throw new ServletException("Database operation failed", ex);
        }
    }

    public void destroy() {
        try {
            if (lotteryDAO != null) {
                lotteryDAO.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
