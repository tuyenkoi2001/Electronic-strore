package dao;
import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class UserDAO {
    private Connection conn;
    private PreparedStatement ps; 
    private ResultSet rs;
    
    
    public List<Account> getAllAccount(){
        List<Account> list = new ArrayList<Account>();
        String query = "select * from [user]";

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(
                        new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)
                    )
                );
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    
    public Account getAccount(int id){
        String query = "select * from [user] where id=" + id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return (
                        new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)
                    )
                );
            }
        } catch (Exception e) {
            
        }
        return null;
    }
    
    public void DisableAccount(int id){
        String query = "update [user] set active=0 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void ActivateAccount(int id){
        String query = "update [user] set active=1 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void Authorize(int id){
        String query = "update [user] set isadmin=1 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void Reject(int id){
        String query = "update [user] set isadmin=0 where id="+id;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void EditAccount(int id, Account acc){
        String query = "User_Edit_User "+id+",'"
                +acc.getUsername()+"','"
                +acc.getPass()+"',N'"
                +acc.getName()+"',N'"
                +acc.getAddress()+"','"
                +acc.getSdt()+"','"
                +acc.getEmail()+"'";

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
}
