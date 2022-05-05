/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Admin.Order;

import dao.DAO;
import dao.OrderDAO;
import entity.Account;
import entity.ProductInCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
@WebServlet(name = "CRUDOrder", urlPatterns = {"/order-manage"})
public class CRUDOrder extends HttpServlet {

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
        
        String MaHoaDon = request.getParameter("id");
        String MaShipper = request.getParameter("shipperid");
        String action = request.getParameter("action");
        
        if(action.equals("Accept")){
            AcceptOrder(MaHoaDon,MaShipper);
        }
        
        if(action.equals("Refuse")){
            RefuseOrder(MaHoaDon);
        }
        
        if(action.equals("Detail")){
            int user = Integer.parseInt(request.getParameter("user"));
            
            float totalPrice=0;
            List<ProductInCart> list = new DAO().LoadUserCart(new Account(user));
            for(ProductInCart o : list){
                totalPrice += o.getCost()*o.getQuantity();
            }
            request.setAttribute("list", list);
            request.setAttribute("totalCost", totalPrice);
            request.getRequestDispatcher("/Admin/Order/OrderDetail.jsp").forward(request, response);
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

    private void AcceptOrder(String id,String Sid){
        new OrderDAO().AcceptOrder(id, Sid);
    }
    
    private void RefuseOrder(String id){
        new OrderDAO().RefuseOrder(id);
    }
}
