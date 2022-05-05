/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class Account {
    int id;
    String username;
    String pass;
    String name;
    String address;
    String sdt;
    String email;
    int isAdmin;
    int isSeller;
    int Active;
    
    public Account(int id){
        this.id = id;
    }

    public Account(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
    

    public Account(int id, String username, String pass, String name, String address, String sdt, String email, int isAdmin, int isSeller,int active) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.address = address;
        this.sdt = sdt;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isSeller = isSeller;
        this.Active = active;
    }

    public Account(String username, String pass, String name, String address, String sdt, String email) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.address = address;
        this.sdt = sdt;
        this.email = email;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int isIsSeller() {
        return isSeller;
    }

    public void setIsSeller(int isSeller) {
        this.isSeller = isSeller;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }
    
    

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", username=" + username + ", pass=" + pass + ", name=" + name + ", address=" + address + ", sdt=" + sdt + ", email=" + email + ", isAdmin=" + isAdmin + ", isSeller=" + isSeller + '}';
    }
    
    
}
