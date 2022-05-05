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
@WebServlet(name = "LoadProductControl", urlPatterns = {"/loadmore"})
public class LoadProductControl extends HttpServlet {

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
          
        String catID = request.getParameter("catID");
        int amount = Integer.parseInt(request.getParameter("exists"));
        
        DAO dao = new DAO();
        
        List<Product> listP = dao.getNext3Product(amount);

        List<Brand> listB = dao.getAllBrand();
        
        List<Category> listCategory = dao.getAllCategory();
        
        List listCatID = new DirtyWork().listCategory();
        HashMap<String,String> catIdToCatName = new DirtyWork().catIdToCatName();
        HashMap<String,List<Product>> mapToParticulerProduct = new DirtyWork().Next3ProductForEachCategory(amount);
                      
        //up toàn bộ sản phẩm nếu nhấn vào category
        
        if(catID==null || catID.equals("0"))
            request.setAttribute("listP", listP);
        else{
            request.setAttribute("listP", mapToParticulerProduct.get(catID));
        }
        //gửi đi catID mà người dùng chọn
        request.setAttribute("selectedCatID", catID);
        //danh sách thực thể "nhãn hiệu"
        request.setAttribute("listB", listB);
        //danh sách thực thể category
        request.setAttribute("listC", listCategory);
        //ánh xạ catid tới tên của nó
        request.setAttribute("mapCatId", catIdToCatName);
        //danh sách category dạng chuỗi
        request.setAttribute("catID", listCatID);
        request.getRequestDispatcher("nextProduct.jsp").forward(request, response);  
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
