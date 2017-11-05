package cn.ssd.wean2016.springsecurity.model.domain;

import cn.ssd.wean2016.springsecurity.model.LoginDetail;
import cn.ssd.wean2016.springsecurity.model.TokenDetail;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/10/3 1:45
 */

@Entity
@Table(name = "sys_user")
public class SysUser implements LoginDetail, TokenDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "last_password_change")
    private Long lastPasswordChange;
    @Column(name = "enable")
    private char enable;


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "roleId")
    private Set<SysRole> roles = new HashSet<SysRole>();

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SysUser() {
    }

    public SysUser setUsername(String username) {
        this.userName = username;
        return this;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getLastPasswordChange() {
        return lastPasswordChange;
    }

    public SysUser setLastPasswordChange(Long lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
        return this;
    }

    public SysUser setEnable(char enable) {
        this.enable = enable;
        return this;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean enable() {
        if (this.enable == '1'){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastPasswordChange=" + lastPasswordChange +
                ", enable=" + enable +
                '}';
    }
}
