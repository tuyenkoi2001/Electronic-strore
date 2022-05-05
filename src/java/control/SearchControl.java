/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import context.DirtyWork;
import dao.DAO;
import entity.Brand;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {

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
        String productNameInput = request.getParameter("searchInput");
        String catIdOfProduct = request.getParameter("catId");
        
        // đây là đoạn copy từ bên CategoryControl
            DAO dao = new DAO();

            //tải toàn bộ sp
            List<Product> listP = dao.getProductBySearchName(productNameInput, catIdOfProduct);
            //tải toàn bộ nhãn hiệu
            List<Brand> listB = dao.getAllBrand();
            //tải danh sách sản phẩm theo category id
            //load toàn bộ category
            List<Category> listCategory = dao.getAllCategory();
            List listCatID = new ArrayList();
            HashMap<String,String> catIdToCatName = new DirtyWork().catIdToCatName();
            //dùng map để lưu các ánh xạ tới các danh sách sản phẩm(2)
            HashMap<String,List<Product>> mapToParticulerProduct = new DirtyWork().mapToParticulerProduct();

            //lấy ra top selling chung
            List<Product> topSellingOverall = dao.getOverallTopSelling();

            request.setAttribute("listP", listP);
            //gửi đi catID mà người dùng chọn
            request.setAttribute("selectedCatID", catIdOfProduct);
            //danh sách thực thể "nhãn hiệu"
            request.setAttribute("listB", listB);
            //danh sách thực thể category
            request.setAttribute("listC", listCategory);
            //ánh xạ catid tới tên của nó
            request.setAttribute("mapCatId", catIdToCatName);
            //danh sách category dạng chuỗi
            request.setAttribute("catID", listCatID);
            request.setAttribute("topSelling", topSellingOverall);
            request.getRequestDispatcher("store.jsp").forward(request, response);
        // kết thúc phần copy
        
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
