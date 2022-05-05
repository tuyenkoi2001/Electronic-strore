
package dao;

import context.DBContext;
import entity.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class BrandDAO {
    private Connection conn;
    private PreparedStatement ps; 
    private ResultSet rs;
    
    
    public List<Brand> getAllBrand(){
        List<Brand> list = new ArrayList<Brand>();
        String query = "select * from nhanhieu";

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Brand(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3))
                     );
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    
    public void DeleteBrand(int id){
        String query = "update nhanhieu set isDeleted=1 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void RetrieveBrand(int id){
        String query = "update nhanhieu set isDeleted=0 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void EditBrand(int id, Brand b){
        String query = "update nhanhieu set tennhanhieu=N'"+b.getbName()+
                "'"+" where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void CreateBrand(Brand b){
        String query = "insert into nhanhieu (tennhanhieu,isDeleted) values (N'"+b.getbName()+"',0)";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
}
