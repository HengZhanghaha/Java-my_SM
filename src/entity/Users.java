package entity;

/**
 * Editor: 张恒
 * Wechat：zh17530588817
 * date: 2021/6/30/19:59
 */

/**
 * 系统管理员
 */
public class Users {
    private int userId;
    private String userName;
    private String password;
    private int roleId; //管理员级别

    public Users() {
    }

    public Users(int userId, String userName, String password, int roleId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
