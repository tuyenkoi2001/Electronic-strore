package entity;

public class Order {
    int Mahoadon;
    int idUser;
    int idShipper;
    String NgayLap;
    String NoiNhan;
    int Accepted;
    String NguoiNhan;
    String Phone;

    public Order(int Mahoadon, int idUser, int idShipper, String NgayLap, String NoiNhan, int Accepted, String NguoiNhan, String Phone) {
        this.Mahoadon = Mahoadon;
        this.idUser = idUser;
        this.idShipper = idShipper;
        this.NgayLap = NgayLap;
        this.NoiNhan = NoiNhan;
        this.Accepted = Accepted;
        this.NguoiNhan = NguoiNhan;
        this.Phone = Phone;
    }

    public int getMahoadon() {
        return Mahoadon;
    }

    public void setMahoadon(int Mahoadon) {
        this.Mahoadon = Mahoadon;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(int idShipper) {
        this.idShipper = idShipper;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getNoiNhan() {
        return NoiNhan;
    }

    public void setNoiNhan(String NoiNhan) {
        this.NoiNhan = NoiNhan;
    }

    public int getAccepted() {
        return Accepted;
    }

    public void setAccepted(int Accepted) {
        this.Accepted = Accepted;
    }

    public String getNguoiNhan() {
        return NguoiNhan;
    }

    public void setNguoiNhan(String NguoiNhan) {
        this.NguoiNhan = NguoiNhan;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    
}
