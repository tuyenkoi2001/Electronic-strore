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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
@WebServlet(name = "FilerControl", urlPatterns = {"/filter"})
public class FilerControl extends HttpServlet {

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
        DAO dao = new DAO();
        
        String[] Category = request.getParameterValues("category-chk");
        String[] Brand = request.getParameterValues("brand-chk");
        float MaxPrice = Float.parseFloat(request.getParameter("price-max"));
        float MinPrice = Float.parseFloat(request.getParameter("price-min"));
        
        Set<Product> setProduct = new HashSet<>();
        if(Category!=null){
            for(int i=0;i<Category.length;i++){
                setProduct.addAll(
                    dao.FilterCategory(Category[i],MinPrice,MaxPrice)
                );
            }
        }
        if(Brand!=null){
            for(int i=0;i<Brand.length;i++){
                setProduct.addAll(
                    dao.FilterBrand(Brand[i],MinPrice,MaxPrice)
                );
            }
        }
        request.setAttribute("listP", setProduct);
        
        
        List<Brand> listB = dao.getAllBrand();
        List<Category> listCategory = dao.getAllCategory();
        List listCatID = new DirtyWork().listCategory();
        HashMap<String,String> catIdToCatName = new DirtyWork().catIdToCatName();
        List<Product> topSellingOverall = dao.getOverallTopSelling();
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
