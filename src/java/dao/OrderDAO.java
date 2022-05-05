package dao;

import context.DBContext;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection conn;
    private PreparedStatement ps; 
    private ResultSet rs;
    
    
    public List<Order> getAllOrder(){
        List<Order> list = new ArrayList<>();
        String query = "select * from hoadon where accepted=0";

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Order(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)
                )
                     );
            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    public void AcceptOrder(String id,String shipper_id){
        String query = "AcceptOrder "+id+","+shipper_id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
    
    public void RefuseOrder(String id){
        String query = "delete hoadon where mahoadon="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
}
