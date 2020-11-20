package servelets;
import entidade.CorpoClinico;
import modeloDAO.CorpoClinicoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Cadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cadastrar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cadastrar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {        
      response.setContentType("text/html");
      PrintWriter out= response.getWriter();
      
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Servlet Cadastrar</title>");            
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>Cadastro - Cadastro Corpo Clinico</h1>");
       out.println("<br/>"); 
            
      String nome = request.getParameter("nome");  
      String documento = request.getParameter("documento");
      String especialidade = request.getParameter("especialidade");
      
      CorpoClinico corpoClinico = new CorpoClinico();
      corpoClinico.setNome(nome);
      corpoClinico.setDocCorpoClinico(documento);
      corpoClinico.setEspecialidade(especialidade);
      CorpoClinicoDAO corpoClinicoDAO = new CorpoClinicoDAO();
      
       try {
    	   corpoClinicoDAO.insertCorpoClinico(corpoClinico);
            out.println("<h1> Registro inserido</h1><br/>");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        out.println("</body>");
        out.println("</html>");
     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
