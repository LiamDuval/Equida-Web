/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoCheval;
import database.DaoRace;
import database.DaoVente;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cheval;
import model.Race;
import model.Vente;

/**
 *
 * @author sio2
 */
@WebServlet(name = "venteservlet", urlPatterns = {"/vente-servlet"})
public class VenteServlet extends HttpServlet {

Connection cnx;
    
    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");
        try {
            System.out.println("INIT SERVLET=" + cnx.getSchema());
        } catch (SQLException ex) {
            Logger.getLogger(ChevalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();
        System.out.println("PathInfo: " + path);

        if ("/list".equals(path)) {
            ArrayList<Vente> lesVentes = DaoVente.getLesVentes(cnx);
            request.setAttribute("pLesVentes", lesVentes);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/list.jsp").forward(request, response);
        }
        if ("/show".equals(path)) {
            try {
                int idVente = Integer.parseInt(request.getParameter("idCheval"));
                Vente laVente = DaoVente.getLaVente(cnx, idVente);

                if (laVente != null) {
                    request.setAttribute("pLaVente", laVente);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/show.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur : l'id du vente n'est pas un nombre valide");
                response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();

        
    }

    public void destroy() {
    }

}
