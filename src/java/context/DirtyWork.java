/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import dao.DAO;
import entity.Brand;
import entity.Category;
import entity.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class DirtyWork {
    DAO dao = new DAO();
        
    
    public HashMap<String,String> catIdToCatName(){
        List<Category> listCategory = dao.getAllCategory();
        HashMap<String,String> catIdToCatName = new HashMap<>();
        //chuyển toàn bộ category ID sang dạng chuỗi để sử dụng trong EL(1)
        //ánh xạ catID tới catName cho dễ gọi
        for(Category c:listCategory){
            String catId = String.valueOf(c.getCatID());
            String catName = String.valueOf(c.getCatName());
            catIdToCatName.put(catId,catName);
        }
        return catIdToCatName;
    }
    
    public List<String> listCategory(){
        List<Category> listCategory = dao.getAllCategory();
        List listCatID = new ArrayList();
        
        for(Category c:listCategory){
            String catId = String.valueOf(c.getCatID());
            listCatID.add(catId);
        }
        return listCatID;
    }
    
    public HashMap<String,List<Product>> Next3ProductForEachCategory(int amount){
        //tải toàn bộ sp
        List<Product> listP = dao.getNext3Product(amount);
        //tải toàn bộ nhãn hiệu        
        //dùng map để lưu các ánh xạ tới các danh sách sản phẩm(2)
        HashMap<String,List<Product>> mapToParticulerProduct = new HashMap<String,List<Product>>();
        List<Category> listCategory = dao.getAllCategory();
        for(Category c:listCategory){
            mapToParticulerProduct.put(String.valueOf(c.getCatID()), dao.getNext3Product(amount,c.getCatID()));
        }
        return mapToParticulerProduct;
    }
    
    public HashMap<String,List<Product>> mapToParticulerProduct(){
        var mapToParticulerProduct = new HashMap<String,List<Product>>();
        for(String c:listCategory()){
            mapToParticulerProduct.put(c, dao.getProductbyCategoryID(Integer.parseInt(c)));
        }
        return mapToParticulerProduct;
    }       
}
