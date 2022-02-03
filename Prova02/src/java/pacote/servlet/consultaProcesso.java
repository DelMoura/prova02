/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pacote.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Unidade;

/**
 *
 * @author User
 */
@WebServlet(name = "consultaProcesso", urlPatterns = {"/consultaProcesso"})
public class consultaProcesso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet consultaProcesso</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet consultaProcesso at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova02", "root", "Alexandre3");
            p = con.prepareStatement("select * from unidades");

            ResultSet rs = p.executeQuery();

            List<Unidade> unidades = new ArrayList();
            while (rs.next()) {
                Unidade u = new Unidade();
                
                u.setCnpj(rs.getString("cnpj"));
                u.setNome(rs.getString("nome"));
                u.setLogradouro(rs.getString("logradouro"));
                u.setNumero(rs.getString("numero"));
                u.setComplemento(rs.getString("complemento"));
                u.setBairro(rs.getString("bairro"));
                u.setCep(rs.getString("cep"));
                u.setTelefone(rs.getString("telefone"));
                u.setMicroregiao(rs.getString("microregiao"));
                u.setEmail(rs.getString("email"));

                unidades.add(u);

            }

            request.setAttribute("resultado", unidades);
            rs.close();
            p.close();
            con.close();

        } catch (Exception e) {

        }

        RequestDispatcher despachar = request.getRequestDispatcher("crud01.jsp");
        despachar.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
