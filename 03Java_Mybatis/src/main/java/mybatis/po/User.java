package mybatis.po;

public class User {
    int id;
    String username;
    String password;
    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString(){
        return "User [id="+id+", username=" + username + ", password=" + password + "] ";
    }
}
