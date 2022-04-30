package User;

public class User {
    protected String idUser;
    protected Integer userType;
    protected String name;
    protected String password;
    protected String email;

    public User() {
    }

    public User(String idUser, Integer userType, String name, String password, String email) {
        this.idUser = idUser;
        this.userType = userType;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
