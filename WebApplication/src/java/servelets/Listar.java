/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import modeloDAO.CorpoClinicoDAO;
import modeloDAO.PacienteDAO;
import entidade.Consulta;
import entidade.CorpoClinico;
import entidade.Pessoa;

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

public class Listar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Listar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Listar at " + request.getContextPath() + "</h1>");
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
      
      Consulta consultaPaciente;
       
      response.setContentType("text/html");
      PrintWriter out= response.getWriter();
      
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Servlet Listar</title>");            
       out.println("</head>");
       out.println("<body>");
       out.println("</body>");
       out.println("</html>");
        
      PacienteDAO p = new PacienteDAO();
     
        try {
           out.println("<h1> Lista pacientes:</h1><br/>");
           
           List<Consulta> lista = p.getDadosPaciente();
           
            Iterator<Consulta> it=lista.listIterator();
           
            
            while (it.hasNext())
            {
            	consultaPaciente=it.next();
                
                out.println("<br/>"+consultaPaciente.getPaciente()+"-"+consultaPaciente.getMedico()+"-"+consultaPaciente.getData());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
