/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class Brand {
    private int bID;
    private String bName;
    private int isDeleted;

    public Brand() {
    }

    public Brand(int bID, String bName) {
        this.bID = bID;
        this.bName = bName;
    }

    public Brand(String bName, int isDeleted) {
        this.bName = bName;
        this.isDeleted = isDeleted;
    }

    public Brand(int bID, String bName, int isDeleted) {
        this.bID = bID;
        this.bName = bName;
        this.isDeleted = isDeleted;
    }
    
    

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    
    @Override
    public String toString() {
        return "Brand{" + "bID=" + bID + ", bName=" + bName + '}';
    }
    
    
}
