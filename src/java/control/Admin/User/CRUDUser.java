/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Admin.User;

import dao.UserDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
@WebServlet(name = "CRUDUser", urlPatterns = {"/user-manage"})
public class CRUDUser extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(action.equals("Edit")){
            Account a = new UserDAO().getAccount(id);
            request.setAttribute("Account", a);
            request.getRequestDispatcher("/Admin/User/user-detail.jsp").forward(request, response);
        }
        if(action.equals("Deactivate")){
            Deactivate(id);
        }
        if(action.equals("Activate")){
            Activate(id);
        }

        if(action.equals("Save")){
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            String phone = request.getParameter("phone");
            String add = request.getParameter("address");
            
            Account a = new Account(username,pass,name,add,phone,email);
            a.setId(id);
            DoEdit(a);
            request.getRequestDispatcher("/admin/user").forward(request, response);
        }
        
        if(action.equals("Authorize")){
            Authorize(id);
        }
        if(action.equals("Reject")){
            Reject(id);
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

    private void Authorize(int id){
        new UserDAO().Authorize(id);
    }
    
    private void Reject(int id){
        new UserDAO().Reject(id);
    }
    
    private void DoEdit(Account c){
        new UserDAO().EditAccount(c.getId(),c);
    }
    
    private void Deactivate(int id){
        new UserDAO().DisableAccount(id);   
    }
    
    private void Activate(int id){
        new UserDAO().ActivateAccount(id);   
    }
}
