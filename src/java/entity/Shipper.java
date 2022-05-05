package entity;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class Shipper {
    int id;
    String name;
    String sdt;
    int Deleted;

    public Shipper(int id, String name, String sdt, int Deleted) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.Deleted = Deleted;
    }

    public Shipper(String name, String sdt) {
        this.name = name;
        this.sdt = sdt;
    }

    public Shipper(int id, String name, String sdt) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getDeleted() {
        return Deleted;
    }

    public void setDeleted(int Deleted) {
        this.Deleted = Deleted;
    }
    
    
}
