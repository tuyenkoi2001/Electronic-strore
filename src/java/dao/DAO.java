package dao;
import context.DBContext;
import entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAO {
    private Connection conn;
    private PreparedStatement ps; 
    private ResultSet rs;
    
    public List<Product> getAllProduct(){
        List<Product> list;
        String query = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available "
                + "from Sanpham where isdeleted = 0";
        list = getListProductByExcuteQuery(query);
        return list;
    }
    
    public String[] getImageOfProduct(int productID){
        Connection conn;
        PreparedStatement ps; 
        ResultSet rs;
        
        List<String> listImage = new ArrayList<>();
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
    
    public List<Product> getLateastProduct(){
        List<Product> list;
        String query = "select top 4 Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available from sanpham where isDeleted=0 order by id desc";
        list = getListProductByExcuteQuery(query);
        
        return list;
    }
    
    public List<Product> getNext3Product(int amount){
        List<Product> list ;
        String sql = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available from sanpham where isdeleted = 0 order by id offset "
                + amount +" rows fetch next 3 rows only";
        list = getListProductByExcuteQuery(sql);
        return list;
    }
    
    public List<Product> getNext3Product(int amount,int catId){
        List<Product> list ;
        String sql = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available from sanpham where isdeleted = 0 and maloai="
                + catId +" order by id offset "
                + amount +" rows fetch next 3 rows only";
        list = getListProductByExcuteQuery(sql);
        return list;
    }
    
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "select * from loaihang where isdeleted = 0";

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
        } catch (Exception e) {
            
        }
        return list;
    }
    
    public List<Product> getProductbyCategoryID(int catID){
        List<Product> list;
        String query = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available "
                + "from Sanpham where isdeleted = 0 and maloai="+catID;
        list = getListProductByExcuteQuery(query);
        return list;
    }
    
    public List<Product> getLateastProductbyID(int catID){
        List<Product> list;
        String query = "select top 4 Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available from sanpham where isdeleted = 0 and maloai="+catID;
        list = getListProductByExcuteQuery(query);
        
        return list;
    }

    public List<Product> getOverallTopSelling(){
        List<Product> list = new ArrayList<Product>();
        String query = """
                       select top 5 Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available 
                       from tong_ban_trong_thang join Sanpham on Sanpham.Id=tong_ban_trong_thang.idsanpham
                       order by slban desc""";
        list = getListProductByExcuteQuery(query);
        return list;
    }
    
    public List<Product> getTopSellingById(int catId){
        List<Product> list;
        String query = """
                       select top 5 Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available 
                       from tong_ban_trong_thang join Sanpham on Sanpham.Id=tong_ban_trong_thang.idsanpham
                       where isdeleted = 0 and MaLoai = """+catId +
            "order by slban desc";
        list = getListProductByExcuteQuery(query);
        return list;
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
                        rs.getInt(8)
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
    
    public Product getProductById(String pID){
        List<Product> list;
        String query = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available "
                + "from Sanpham where id="+pID;
        list = getListProductByExcuteQuery(query);
        return list.get(0);
    }
    
    public List<Product> getProductBySearchName(String name,String catId){
        String query = "select Sanpham.id,TenSp,Mota,MaLoai,mau,gia,IDnhanhieu,available "
                + "from Sanpham where isdeleted = 0 and tensp like '%"+ name +"%'";
        if(catId.equals("0"))
               return getListProductByExcuteQuery(query);
        else
            return getListProductByExcuteQuery(query += " and maloai="+catId);
        }
    
    public List<Product> FilterCategory(String catId,float min,float max){
        String query = "CategorySelected "+catId+","+min+","+max;
        return getListProductByExcuteQuery(query);
    }
    public List<Product> FilterBrand(String bid,float min,float max){
        String query = "BrandSelected "+bid+","+min+","+max;
        return getListProductByExcuteQuery(query);
    }
    
    public List<Brand> getAllBrand(){
        List<Brand> list = new ArrayList<Brand>();
        String query = "select * from nhanhieu where isdeleted = 0";

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Brand(rs.getInt(1),
                        rs.getString(2))
                     );
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    
    public Account Login(String email, String pass){
        String sql = "select * from [user] where email = '"+email+"' and pass='"+pass+"' ";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)
                );
            }
        } catch (Exception e) {
            
        }
        return null;
    }
    
    public boolean isAccountExist(String email){
        if(email == null){
            return false;
        }
        String sql = "select * from [user] where email = '"+email+"'";
        System.out.println(sql);
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            
        }
        return false;
    }
    
    public void SignUp(String email,String username,String pass){
        String query = "insert into [user] (email,username,pass) values('"+
                email+"','"+
                username+"','"+
                pass+"')";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public List<ProductInCart> LoadUserCart(Account a){
        List<Product> listProduct ;
        List<ProductInCart> list = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        String sql = "select * from user_cart(" + a.getId()+")";
        listProduct = getListProductByExcuteQuery(sql);
        
        //lấy số lượng của từng sản phẩm trong cart
        sql = "select soluong from cart where iduser="+a.getId();
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                quantity.add(rs.getInt(1));
            }
        } catch (Exception e) {
            
        }
        
        int len = listProduct.size();
        for(int i=0;i<len;i++)
        {
            list.add(new ProductInCart(listProduct.get(i),quantity.get(i)));
        }
        
        return list;
    }
    
    public void AddProductIntoUserCart(Account user,int productId,int qty){
        String query = "insert into cart (idsanpham,iduser,soluong) values ("+productId+","+user.getId()+","+qty+")";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void DeleteProductFromUserCart(Account user,int productId){
        String query = "delete from cart where iduser="+user.getId()+" and idsanpham="+productId;
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public void PlaceOrder(int id_user,String address,String NguoiNhan,String phone){
        String query = "PlaceOrder "+id_user+",N'"+address+"',N'"+NguoiNhan+"','"+phone+"'";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
    
    public List<Review> LoadReview(String ProductID){
        List<Review> list = new ArrayList<>();
        String query = "select * from review where ProductId=" + ProductID;

        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Review(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6))
                     );
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    
    public void SaveReview(Review r){
        String query = "insert into review values ("+r.getProductId()+",'"+r.getEmail()+"','"
                +r.getName()+"',N'"+r.getReview()+"','"+r.getTimestamp()+"',"+r.getVote()+ ")";
        try {
            conn = new DBContext().getInstance();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
  
}
