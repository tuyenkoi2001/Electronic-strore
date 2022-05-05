
package control;

import context.DirtyWork;
import dao.DAO;
import entity.Account;
import entity.Brand;
import entity.Category;
import entity.Product;
import entity.ProductInCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class CheckoutControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SomeMessyWork(request);
        
        DAO dao = new DAO();

        HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("acc");
        List<Category> listCategory = dao.getAllCategory();
        
        request.setAttribute("listC", listCategory);

        if(a==null){
            response.sendRedirect("login");
        }
        else{
            float totalPrice=0;
            List<ProductInCart> list = dao.LoadUserCart(a);
            for(ProductInCart o : list){
                totalPrice += o.getCost()*o.getQuantity();
            }
            request.setAttribute("list", list);
            request.setAttribute("totalCost", totalPrice);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
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

    public void SomeMessyWork(HttpServletRequest request){
        DAO dao = new DAO();
        
        //load toàn bộ category
        List<Category> listCategory = dao.getAllCategory();
                //chuyển toàn bộ category ID sang dạng chuỗi để sử dụng trong EL(1)
        List listCatID = new DirtyWork().listCategory();
                //ánh xạ catID tới catName cho dễ gọi
        HashMap<String,String> catIdToCatName = new DirtyWork().catIdToCatName();
        
        //dùng map để lưu các ánh xạ tới các danh sách sản phẩm(2)
        HashMap<String,List<Product>> mapToParticulerProduct = new HashMap<String,List<Product>>();
        for(Category c:listCategory){
            mapToParticulerProduct.put(String.valueOf(c.getCatID()), dao.getNext3Product(0,c.getCatID()));
        }
                
        //lấy ra top selling chung
        List<Product> topSellingOverall = dao.getOverallTopSelling();
        
        //up toàn bộ sản phẩm nếu nhấn vào category
        
        //danh sách thực thể category
        request.setAttribute("listC", listCategory);
        //ánh xạ catid tới tên của nó
        request.setAttribute("mapCatId", catIdToCatName);
        //danh sách category dạng chuỗi
        request.setAttribute("catID", listCatID);
        request.setAttribute("topSelling", topSellingOverall);
    }
    
}
