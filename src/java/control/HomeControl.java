package control;

import context.DirtyWork;
import dao.DAO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class HomeControl extends HttpServlet {

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
        
     
        
        //load sản phẩm
        DAO dao = new DAO();
        //lấy sản phẩm mới nhất
        List<Product> newProduct = dao.getLateastProduct();
        //load toàn bộ category
        List<Category> listCategory = dao.getAllCategory();
        List listCatID = new DirtyWork().listCategory();
        HashMap<String,String> catIdToCatName = new DirtyWork().catIdToCatName();
        
        //dùng map để lưu các ánh xạ tới các danh sách sản phẩm(2)
        //dùng map để lưu các ánh xạ tới các topSelling
        HashMap<String,List<Product>> mapToLateastProduct = new HashMap<>();
        HashMap<String,List<Product>> mapToTopSelling = new HashMap<>();
        for(Category c:listCategory){
            mapToLateastProduct.put(String.valueOf(c.getCatID()), dao.getLateastProductbyID(c.getCatID()));
            mapToTopSelling.put(String.valueOf(c.getCatID()), dao.getTopSellingById(c.getCatID()));
        }
        //lấy ra top selling chung
        List<Product> topSellingOverall = dao.getOverallTopSelling();
        
        
        //đẩy sp lên request
        request.setAttribute("newest", newProduct);
        request.setAttribute("listP", mapToLateastProduct);
        request.setAttribute("topSellingbyId", mapToTopSelling);
        //danh sách thực thể category
        request.setAttribute("listC", listCategory);
        //ánh xạ catid tới tên của nó
        request.setAttribute("mapCatId", catIdToCatName);
        //danh sách category dạng chuỗi
        request.setAttribute("catID", listCatID);
        request.setAttribute("topSelling", topSellingOverall);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
