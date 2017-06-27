package br.com.crescer.aula05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christopher.michel
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    private List<String> nomes = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.append("<table class=\"table table-hover\"><thead><tr><th>Nome</th></tr></thead><tbody>");
            nomes.forEach(nome -> out.append("<tr><td>").append(nome).append("</td></tr>"));
            out.append("</tbody></table>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        if (nome != null) {
            nomes.add(nome);
        }
        resp.sendRedirect("/aula05/pessoa");
    }

}
