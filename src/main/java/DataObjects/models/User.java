package DataObjects.models;

public class User {

    public User() {

    }

    private String userName = "alina23";

       private String passWord;



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }


}
