package br.com.crescer.aula05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christopher.michel
 */
public class PessoaServlet extends HttpServlet{
    
    private Set<String> cliente = new HashSet<>();

    public PessoaServlet() {
        
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
                        throws IOException {
        try(final PrintWriter out = resp.getWriter();){
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<h1>Pessoa</h1>");
            out.append("</body>");
            
            out.append("<form action=\"/aula5/pessoa\" method=\"POST\">\n");
            out.append("</html>");
        }}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
    }
}
