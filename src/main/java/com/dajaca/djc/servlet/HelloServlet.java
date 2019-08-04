/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dajaca.djc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danie
 */
public class HelloServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println(getHTMLHead());
            out.println("<body data-spy=\"scroll\" data-target=\".site-navbar-target\" data-offset=\"300\">\n");
            out.println(getHTMLBodyStart());
            String message = request.getParameter("message") != null ? request.getParameter("message") : "";
            if( !message.isEmpty() && !message.equals("") ){
                out.println("<h2 class=\"text-red\">Goodbye Message Received: </h2><p class=\"mb-4\">"+message+"</p>");
            }
            out.println(getHTMLReply());
            out.println(getHTMLBodyClose());
            out.println(getHTMLScripts());
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }
    
    protected String getHTMLReply(){
        return("<form action=\"/goodbye-servlet/goodbye\" class=\"p-5\" method=\"GET\">\n" +
"                          <div class=\"col-12 text-center\">\n" +
"                                <h2 class=\"section-title mb-3 text-white\">Send Hello Message</h2>\n" +
"                          </div>"+
"                          <div class=\"row form-group\">\n" +
"                                <div class=\"col-md-12\">\n"  +
"                                  <textarea name=\"message\" id=\"message\" cols=\"30\" rows=\"7\" class=\"form-control\" placeholder=\"Write your notes or questions here...\"></textarea>\n" +
"                                </div>\n" +
"                          </div>\n" +
"\n" +
"                          <div class=\"row form-group\">\n" +
"                                <div class=\"col-md-12\">\n" +
"                                  <input type=\"submit\" value=\"Send Message\" class=\"btn btn-primary btn-md text-white\">\n" +
"                                </div>\n" +
"                          </div>\n" +
"                        </form>");
    }
    
    
    protected String getHTMLBodyStart(){
        return ("	  <div class=\"site-wrap\">\n" +
"		<div class=\"site-blocks-cover overlay\" style=\"background-image: url("+getBackgroundImageURL()+");\" data-aos=\"fade\" id=\"home-section\">\n" +
"		  <div class=\"container\">\n" +
"			<div class=\"row align-items-center justify-content-center\">	\n" +
"				<div class=\"container\">\n" +
"					<div style=\"background: rgba(0, 0, 0, 0.5);\" class=\"row align-items-center justify-content-center\">\n" +
"					  <div class=\"col-md-7 mb-5\">");
    }
    
    protected String getHTMLBodyClose(){
        return("					  </div>\n" +
"					</div>\n" +
"				</div>\n" +
"			</div>\n" +
"		  </div>\n" +
"		</div>\n" +
"	  </div> <!-- .site-wrap -->");
    }
    
    protected String getBackgroundImageURL(){
        return("images/blackHEX.jpg");
    }
    
    protected String getHTMLHead(){
        return("<head>" +
                    "<title>DAJACA</title>" +
                    "<meta charset=\"utf-8\">" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">" +
                    "<link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,900\" rel=\"stylesheet\">" +
                    "<link rel=\"stylesheet\" href=\"fonts/icomoon/style.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/jquery-ui.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/jquery.fancybox.min.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">" +
                    "<link rel=\"stylesheet\" href=\"fonts/flaticon/font/flaticon.css\">" +
                   " <link rel=\"stylesheet\" href=\"css/aos.css\">" +
                    "<link rel=\"stylesheet\" href=\"css/style.css\">" + 
                "</head>");
    }
    
    protected String getHTMLScripts(){
        return("<script src=\"js/jquery-3.3.1.min.js\"></script>\n" +
        "	<script src=\"js/jquery-migrate-3.0.1.min.js\"></script>\n" +
        "	<script src=\"js/jquery-ui.js\"></script>\n" +
        "	<script src=\"js/popper.min.js\"></script>\n" +
        "	<script src=\"js/bootstrap.min.js\"></script>\n" +
        "	<script src=\"js/owl.carousel.min.js\"></script>\n" +
        "	<script src=\"js/jquery.stellar.min.js\"></script>\n" +
        "	<script src=\"js/jquery.countdown.min.js\"></script>\n" +
        "	<script src=\"js/bootstrap-datepicker.min.js\"></script>\n" +
        "	<script src=\"js/jquery.easing.1.3.js\"></script>\n" +
        "	<script src=\"js/aos.js\"></script>\n" +
        "	<script src=\"js/jquery.fancybox.min.js\"></script>\n" +
        "	<script src=\"js/jquery.sticky.js\"></script>\n" +
        "	<script src=\"js/main.js\"></script>");
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
