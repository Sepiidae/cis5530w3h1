/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fit.cis5530.w3h1.cis5530w3h1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rhianresnick
 */
public class DatabaseServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            Class.forName("org.mariadb.jdbc.Driver");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DatabaseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DatabaseServlet at " + request.getContextPath() + "</h1>");
            out.println("<table>");
            out.println("<tr><th>ID</th><th>IP</th><th>URL</th></tr>");
            // Really bad example of a database connection
            // NEVER put the URI, USERNAME and PASSWORD IN source
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://db:3306/page_monitor",
                    "root", "admin"
            );

            try (PreparedStatement statement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS `hits` (\n"
                    + "  `id` int(11) AUTO_INCREMENT,\n"
                    + "  `ip` varchar(100) DEFAULT NULL,\n"
                    + "  `hit_date` timestamp NULL DEFAULT current_timestamp(),\n"
                    + "  `url` varchar(500) DEFAULT NULL,\n"
                    + "  UNIQUE KEY `hits_id_IDX` (`id`) USING BTREE\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4"
            )) {
                statement.executeQuery();

            }

            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * from hits ")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id"); // by column name
                    String ip = resultSet.getString("ip"); // by column name
                    String url = resultSet.getString("url"); // by column name

                    
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(id);
                    out.println("</td>");
                    out.println("<td>");
                    out.println(ip);
                    out.println("</td>");
                    out.println("<td>");
                    out.println(url);
                    out.println("</td>");                    
                    out.println("</tr>");
                    

                }
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
