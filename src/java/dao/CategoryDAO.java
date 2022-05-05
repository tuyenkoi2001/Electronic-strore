/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class CategoryDAO {
    private Connection conn;
    private PreparedStatement ps; 
    private ResultSet rs;
    
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "select * from loaihang";

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3))
                     );
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    public void DeleteCategory(int id){
        String query = "update loaihang set isDeleted=1 where maloai="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
    
    public void RetrieveCategory(int id){
        String query = "update loaihang set isDeleted=0 where maloai="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
    
    public void EditCategory(int id, Category c){
        String query = "update loaihang set tenloai=N'"+c.getCatName()+
                "'"+" where maloai="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
    
    public void CreateCategory(Category c){
        String query = "insert into LoaiHang (tenloai,isDeleted) values (N'"+c.getCatName()+"',0)";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
}
