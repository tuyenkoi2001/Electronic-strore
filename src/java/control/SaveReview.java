package control;

import dao.DAO;
import entity.Account;
import entity.Review;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
@WebServlet(name = "SaveReview", urlPatterns = {"/savereview"})
public class SaveReview extends HttpServlet {

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
                
        String review = request.getParameter("txt");
        String rating = request.getParameter("rating");
        if(rating == null)
            rating = "4";
        String productId = request.getParameter("pid");
        HttpSession session = request.getSession();
        Account a = (Account)session.getAttribute("acc");
        if(a == null){
            response.sendRedirect("login.jsp");
        }
        else{
            Review r = new Review(Integer.parseInt(productId),a.getEmail(),a.getName(),review,java.time.LocalDate.now().toString(),Integer.parseInt(rating));
            String query = "insert into review values ("+r.getProductId()+",'"+r.getEmail()+"','"
                    +r.getName()+"',N'"+r.getReview()+"','"+r.getTimestamp()+"',"+r.getVote()+ ")";

            DAO dao = new DAO();
            dao.SaveReview(r);
            response.sendRedirect("product?productID="+productId);
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

}
