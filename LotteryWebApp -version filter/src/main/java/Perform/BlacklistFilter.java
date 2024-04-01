package Perform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/hello")
public class BlacklistFilter implements Filter {

    private List<String> blacklist = new ArrayList<>();

    public void init(FilterConfig fConfig) throws ServletException {
        // Initialiser la liste noire avec des noms interdits
        blacklist.add("John Doe");
        blacklist.add("Jane Smith");
        
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String fullName = httpRequest.getParameter("firstname") + " " + httpRequest.getParameter("lastname");

        // Vérifier si le nom figure dans la liste noire
        if (blacklist.contains(fullName)) {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        } else {
            chain.doFilter(request, response); // Passer au filtre suivant dans la chaîne
        }
    }

    public void destroy() {
        // Libérer les ressources du filtre si nécessaire
    }
}
