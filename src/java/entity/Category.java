package entity;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class Category {
    private int catID;
    private String catName;
    private int isDeleted;

    
    public Category(int catID, String catName, int isDeleted) {
        this.catID = catID;
        this.catName = catName;
        this.isDeleted = isDeleted;
    }

    public Category(int catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }
    
    public Category(String catName,int isDeleted) {
        this.catName = catName;
        this.isDeleted = isDeleted;
    }

    public int getCatID() {
        return catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }


    @Override
    public String toString() {
        return "Category{" + "catID=" + catID + ", catName=" + catName + '}';
    }
    
    
}
