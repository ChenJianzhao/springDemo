package org.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jzchen on 2017/1/10 0010.
 */
@Entity
@Table(name = "user", catalog = "test")
public class UserInfo extends CoreBase implements java.io.Serializable{

    private String username;
    private String password;

    @Column(name = "username", length = 80)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", length = 80)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
