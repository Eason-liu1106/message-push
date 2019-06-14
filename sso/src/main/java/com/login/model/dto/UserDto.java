package com.login.model.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author JialinLiu
 * @date 2019/5/27 0027 14:26
 */
public class UserDto {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String salt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
