package model;
import java.time.LocalDate;
public class User {
    private int userid;
    private String name;
    private String email;
    private String phone;
    private LocalDate registeredDate;
    public User(int userid, String name, String email, String phone) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registeredDate = LocalDate.now();
    }
    public int getUserid() {
        return userid;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public LocalDate getRegisteredDate() {
        return registeredDate;
    }
}
