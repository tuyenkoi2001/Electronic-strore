/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class ProductDAO {
    private Connection conn;
    private PreparedStatement ps; 
    private ResultSet rs;
    
    public List<Product> getAllProduct(){
        List<Product> list = new ArrayList<>();
        String query = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available,isdeleted "
                + "from Sanpham";
        list = getListProductByExcuteQuery(query);
        return list;
    }
    
    public String[] getImageOfProduct(int productID){
        Connection conn;
        PreparedStatement ps; 
        ResultSet rs;
        
        List<String> listImage = new ArrayList<String>();
        String query = "select HinhAnh from HinhAnh where idSanpham = " + productID;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            //bảng kết quả của query
            rs = ps.executeQuery();
            while(rs.next()){
                listImage.add(rs.getString(1));
            }
            
            return listImage.toArray(new String[listImage.size()]);
            
        } catch (Exception e) {
        }
        
        return null;
    }
    //hàm này trả về danh sách sản phẩm dựa trên câu lệnh sql(các cột được select phải được đặt đúng vị trí)
    public List<Product> getListProductByExcuteQuery(String sql){
        List<Product> list = new ArrayList<>();
        String query = sql;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            //bảng kết quả của query
            rs = ps.executeQuery();
                    
            int lastIndex = 0;
            while(rs.next()){
                //thêm product vào list
                list.add(new Product( 
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));
                // set hình ảnh cho các product
                int idProduct = list.get(lastIndex).getId();
                String[] listImageOfProduct = getImageOfProduct(idProduct);
                list.get(lastIndex).setImg(listImageOfProduct);
                lastIndex ++;
            }
        } catch (Exception e) {
            
        }
        
        return list;
    }
    
    public int GetNumberOfImage(int id){
        String query = "select count(HinhAnh)as sohinh from HinhAnh where idSanpham="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return rs.getInt(1);
            }
            
        } catch (Exception e) {
            
        }
        return 0;
    }
    
    public void InsertImage(int id,String filename){
        String query = "insert into hinhanh (hinhanh,idsanpham) values ('"+filename+"',"+id+")";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public Product getProductById(String pID){
        List<Product> list;
        String query = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available,isdeleted "
                + "from Sanpham where id="+pID;
        list = getListProductByExcuteQuery(query);
        return list.get(0);
    }
    
    public void DeleteProduct(int id){
        String query = "update [sanpham] set isdeleted=1 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void RetrieveProduct(int id){
        String query = "update [sanpham] set isdeleted=0 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void EditProduct(Product p){
        String query = "update sanpham set tensp=N'"+p.getName()+"'"
                + ",gia="+p.getCost()+""
                + ",available="+p.getAvailable()+""
                + "  where id="+p.getId();

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void EditDetailProduct(Product p){
        String sql = "Edit_Product "+p.getId()+",N'"+p.getName()+"',N'"+p.getMota()+"',"+
                p.getCatId()+","+p.getCost()+","+p.getBrandID()+","+p.getAvailable()+",0";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void InsertProduct(Product p){
        String sql = "Insert_Product N'"+p.getName()+"',N'"+p.getMota()+"',"+
                p.getCatId()+","+p.getCost()+","+p.getBrandID()+","+p.getAvailable()+",0";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
}
