
package control.Admin.Category;

import dao.CategoryDAO;
import entity.Category;
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
@WebServlet(name = "CRUDCategory", urlPatterns = {"/category-manage"})
public class CRUDCategory extends HttpServlet {

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
        int idCategory = Integer.parseInt(request.getParameter("catID"));
        String CategoryName = request.getParameter("name");
        
        if(action.equals("Edit")){
            DoEdit(new Category(idCategory, CategoryName));
        }
        if(action.equals("Delete")){
            DoDelete(idCategory);
        }
        if(action.equals("Retrieve")){
            DoRetrieve(idCategory);
        }
        if(action.equals("Create")){
            DoInsert(new Category(CategoryName,0));
        }
        
        request.getRequestDispatcher("/admin/category").forward(request, response);
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

    
    private void DoInsert(Category c){
        new CategoryDAO().CreateCategory(c);
    }
    
    private void DoEdit(Category c){
        new CategoryDAO().EditCategory(c.getCatID(),c);
    }
    
    private void DoDelete(int id){
        new CategoryDAO().DeleteCategory(id);   
    }
    
    private void DoRetrieve(int id){
        new CategoryDAO().RetrieveCategory(id);   
    }
}
