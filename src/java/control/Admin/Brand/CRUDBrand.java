/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Admin.Brand;

import dao.BrandDAO;
import entity.Brand;
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
@WebServlet(name = "CRUDBrand", urlPatterns = {"/brand-manage"})
public class CRUDBrand extends HttpServlet {

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
        int idBrand = Integer.parseInt(request.getParameter("bID"));
        String BrandName = request.getParameter("name");
        
        if(action.equals("Edit")){
            DoEdit(new Brand(idBrand, BrandName));
        }
        if(action.equals("Delete")){
            DoDelete(idBrand);
        }
        if(action.equals("Retrieve")){
            DoRetrieve(idBrand);
        }
        if(action.equals("Create")){
            DoInsert(new Brand(BrandName,0));
        }
        
        request.getRequestDispatcher("/admin/brand").forward(request, response);
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

    private void DoInsert(Brand b){
        new BrandDAO().CreateBrand(b);
    }
    
    private void DoEdit(Brand b){
        new BrandDAO().EditBrand(b.getbID(),b);
    }
    
    private void DoDelete(int id){
        new BrandDAO().DeleteBrand(id);   
    }
    
    private void DoRetrieve(int id){
        new BrandDAO().RetrieveBrand(id);   
    }
}
