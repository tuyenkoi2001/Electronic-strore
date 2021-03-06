
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
        
        //load to??n b??? category
        List<Category> listCategory = dao.getAllCategory();
                //chuy???n to??n b??? category ID sang d???ng chu???i ????? s??? d???ng trong EL(1)
        List listCatID = new DirtyWork().listCategory();
                //??nh x??? catID t???i catName cho d??? g???i
        HashMap<String,String> catIdToCatName = new DirtyWork().catIdToCatName();
        
        //d??ng map ????? l??u c??c ??nh x??? t???i c??c danh s??ch s???n ph???m(2)
        HashMap<String,List<Product>> mapToParticulerProduct = new HashMap<String,List<Product>>();
        for(Category c:listCategory){
            mapToParticulerProduct.put(String.valueOf(c.getCatID()), dao.getNext3Product(0,c.getCatID()));
        }
                
        //l???y ra top selling chung
        List<Product> topSellingOverall = dao.getOverallTopSelling();
        
        //up to??n b??? s???n ph???m n???u nh???n v??o category
        
        //danh s??ch th???c th??? category
        request.setAttribute("listC", listCategory);
        //??nh x??? catid t???i t??n c???a n??
        request.setAttribute("mapCatId", catIdToCatName);
        //danh s??ch category d???ng chu???i
        request.setAttribute("catID", listCatID);
        request.setAttribute("topSelling", topSellingOverall);
    }
    
}
