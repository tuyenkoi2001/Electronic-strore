/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class Product {
    protected int id;
    protected String name;
    protected String mota;
    protected int catId;
    protected String color;
    protected double cost;
    protected int brandID;
    protected String[] img;
    protected int available;
    protected int isDeleted;

    public Product(){}

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
    
    public Product(int id){
        this.id = id;
    }
    
    public Product(int id, String name, String mota, int catId, String color, double cost, int brandID, String[] img) {
        this.id = id;
        this.name = name;
        this.mota = mota;
        this.catId = catId;
        this.color = color;
        this.cost = cost;
        this.brandID = brandID;
        this.img = img;
    }
    
    public Product(int id, String name, String mota, int catId, String color, double cost, int brandID,int available) {
        this.id = id;
        this.name = name;
        this.mota = mota;
        this.catId = catId;
        this.color = color;
        this.cost = cost;
        this.brandID = brandID;
        this.available = available;
    }
    
    public Product(int id, String name, String mota, int catId, String color, double cost, int brandID,int available,int isdeleted) {
        this.id = id;
        this.name = name;
        this.mota = mota;
        this.catId = catId;
        this.color = color;
        this.cost = cost;
        this.brandID = brandID;
        this.available = available;
        this.isDeleted = isdeleted;
    }
    
    public Product(int id, String name, double cost, int available) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.available = available;
    }
    public Product(int id, String name, String mota, int catId, double cost, int brandID,int available) {
        this.id = id;
        this.name = name;
        this.mota = mota;
        this.catId = catId;
        this.available = available;
        this.cost = cost;
        this.brandID = brandID;
    }
    
    public String[] getImg() {
        return img;
    }

    public void setImg(String[] img) {
        this.img = img;
    }
        
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMota() {
        return mota;
    }

    public int getCatId() {
        return catId;
    }

    public String getColor() {
        return color;
    }

    public double getCost() {
        return cost;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", mota=" + mota + ", catId=" + catId + ", color=" + color + ", cost=" + cost + ", brandID=" + brandID + ", img=" + img + '}';
    }

    public boolean equals(Product obj) {
        return this.id == obj.id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return this.id == other.id;
    }

    
    
    
}
