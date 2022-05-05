package entity;

import dao.DAO;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class ProductInCart extends Product{
    private int quantity;

    public ProductInCart() {
    }
    
    public ProductInCart(Product p,int quantity){
        this.id = p.id;
        this.name = p.name;
        this.mota = p.mota;
        this.catId = p.catId;
        this.color = p.color;
        this.cost = p.cost;
        this.brandID = p.brandID;
        this.img = p.img;
        this.quantity = quantity;
    }

    public ProductInCart(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
