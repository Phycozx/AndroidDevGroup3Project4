package ca.labs.androiddev.champlain.groupapplicationjb.Models;

public class User
{
    private int id;
    private String username;
    private String password;

    private static boolean isLoggedIn = false;
    private static String currUser;

    public static final String USER_TAB_NAME = "User";
    public static final String USER_COL_ID = "Id";
    public static final String USER_COL_USERNAME = "Username";
    public static final String USER_COL_PASSWORD = "Password";

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        User.isLoggedIn = isLoggedIn;
    }

    public static String getCurrUser() {
        return currUser;
    }

    public static void setCurrUser(String currUser) {
        User.currUser = currUser;
    }
}
