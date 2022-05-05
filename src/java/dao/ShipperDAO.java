/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Shipper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class ShipperDAO {
    private Connection conn;
    private PreparedStatement ps; 
    private ResultSet rs;
    
    
    public List<Shipper> getAllShipper(){
        List<Shipper> list = new ArrayList<Shipper>();
        String query = "select * from shipper";

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Shipper(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                        )
                     );
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    
    public void DeleteShipper(int id){
        String query = "update shipper set isDeleted=1 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void RetrieveShipper(int id){
        String query = "update shipper set isDeleted=0 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void EditShipper(int id, Shipper c){
        String query = "update shipper set tennv=N'"+c.getName()+
                "',sdt = '"+c.getSdt()+"'"
                +" where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void CreateShipper(Shipper c){
        String query = "insert into shipper (tennv,sdt,isDeleted) values (N'"+c.getName()+"','"+c.getSdt()+"',0)";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
}
