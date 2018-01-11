package cn.stars21.model;

public class SysUser extends SysUserKey{

    private String password;

    private Integer roleId;

    private Long lastPasswordChange;

    private char enable;

    private String username;

    private String authorities;


    public String getPassword() {
        return password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public Long getLastPasswordChange() {
        return lastPasswordChange;
    }

    public char getEnable() {
        return enable;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setLastPasswordChange(Long lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }

    public void setEnable(char enable) {
        this.enable = enable;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public boolean enable() {
        if (this.enable == '1') {
            return true;
        }
        return  false;
    }

}