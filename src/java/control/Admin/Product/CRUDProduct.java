/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.Admin.Product;

import dao.DAO;
import dao.ProductDAO;
import entity.Brand;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
@MultipartConfig
@WebServlet(name = "CRUDProduct", urlPatterns = {"/product-manage"})
public class CRUDProduct extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(action.equals("Create")){
            if(id==-1){
                DAO dao = new DAO();
                List<Category> listCategory = dao.getAllCategory();
                List<Brand> listBrand = dao.getAllBrand();

                request.setAttribute("listBrand", listBrand);
                request.setAttribute("listCategory", listCategory);
                request.getRequestDispatcher("/Admin/Product/create-form.jsp").forward(request, response);
            }
            else{
                String name = request.getParameter("name");
            String des = request.getParameter("des");
            int category = Integer.parseInt(request.getParameter("category"));
            int brand = Integer.parseInt(request.getParameter("brand"));
            double cost = Double.valueOf(request.getParameter("cost"));
            int available = Integer.parseInt(request.getParameter("avail"));
            Part part = request.getPart("photo");
            
            String realPath = request.getServletContext().getRealPath("/images/products");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Path.of(realPath))){
                Files.createDirectory(Path.of(realPath));
            }
            
            Product p = new Product(id, name, des, category, cost, brand, available);
            ProductDAO dao = new ProductDAO();
            dao.InsertProduct(p);
            
            int numberImage = dao.GetNumberOfImage(id);
            if(!filename.equals("")){
                filename+=".pop";
                String[] namepart = filename.split("\\.");
                filename =  id+"p"+numberImage+"."+namepart[1];

                dao.InsertImage(id, filename);
                part.write(realPath+"/"+filename);
            }
            Product a = new Product(id,name,cost,available);
            DoEdit(a);
            request.getRequestDispatcher("/admin/product").forward(request, response);
            }
        }
        
        if(action.equals("Edit")){
            Product p = new ProductDAO().getProductById(String.valueOf(id));
            request.setAttribute("product", p);
            request.getRequestDispatcher("/Admin/Product/edit-product-form.jsp").forward(request, response);
        }
        
        if(action.equals("Detail")){
            Product p = new ProductDAO().getProductById(String.valueOf(id));
            DAO dao = new DAO();
            List<Category> listCategory = dao.getAllCategory();
            List<Brand> listBrand = dao.getAllBrand();
            
            request.setAttribute("listBrand", listBrand);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("product", p);
            request.getRequestDispatcher("/Admin/Product/detail.jsp").forward(request, response);
        }
        
        if(action.equals("Save")){
            String name = request.getParameter("name");
            double cost = Double.valueOf(request.getParameter("cost"));
            int available = Integer.parseInt(request.getParameter("available"));
            
            //Product a = new Product(id,name,cost,available);
            //DoEdit(a);
            request.getRequestDispatcher("/admin/product").forward(request, response);
        }
        
        if(action.equals("Save Changes")){
            String name = request.getParameter("name");
            String des = request.getParameter("des");
            int category = Integer.parseInt(request.getParameter("category"));
            int brand = Integer.parseInt(request.getParameter("brand"));
            double cost = Double.valueOf(request.getParameter("cost"));
            int available = Integer.parseInt(request.getParameter("avail"));
            Part part = request.getPart("photo");
            
            String realPath = request.getServletContext().getRealPath("/images/products");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Path.of(realPath))){
                Files.createDirectory(Path.of(realPath));
            }
            
            Product p = new Product(id, name, des, category, cost, brand, available);
            ProductDAO dao = new ProductDAO();
            dao.EditDetailProduct(p);
            
            int numberImage = dao.GetNumberOfImage(id);
            if(!filename.equals("")){
                filename+=".pop";
                String[] namepart = filename.split("\\.");
                filename =  id+"p"+numberImage+"."+namepart[1];

                dao.InsertImage(id, filename);
                part.write(realPath+"/"+filename);
            }
            //Product a = new Product(id,name,cost,available);
            //DoEdit(a);
            request.getRequestDispatcher("/admin/product").forward(request, response);
        }
        
        if(action.equals("Delete")){
            DoDelete(id);
        }
        if(action.equals("Retrieve")){
            DoRetrieve(id);
        }
        if(action.equals("Create")){
            //DoInsert(new Shipper(name,sdt));
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

    private void DoInsert(Product p){
        new ProductDAO().InsertProduct(p);
    }
    
    private void DoEdit(Product p){
        new ProductDAO().EditProduct(p);
    }
    
    private void DoDelete(int id){
        new ProductDAO().DeleteProduct(id);   
    }
    
    private void DoRetrieve(int id){
        new ProductDAO().RetrieveProduct(id);   
    }
}
