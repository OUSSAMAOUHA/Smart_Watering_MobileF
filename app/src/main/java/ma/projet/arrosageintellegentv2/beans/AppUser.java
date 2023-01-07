package ma.projet.arrosageintellegentv2.beans;

import java.util.List;

public class AppUser {
    private long id;
    private String username;
    private String address;
    private String phone;
    private String password;
    List<EspaceVert> espaceVerts;

    public AppUser() {

    }

    public List<EspaceVert> getEspaceVertResponse() {
        return (List<EspaceVert>)espaceVerts;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AppUser(long id, String username, String address, String phone, String password, String role) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    private String role;
}
