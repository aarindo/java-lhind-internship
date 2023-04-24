package com.lhind.internship.springboot.model.dto;

import com.lhind.internship.springboot.model.entity.UserDetail;

public class UserDetailDTO {
    private long id;
    private String email;
    private String phoneNumber;

    public UserDetailDTO() {}

    public UserDetailDTO(UserDetail userDetail) {
        this.setId(userDetail.getId());
        this.setEmail(userDetail.getEmail());
        this.setPhoneNumber(userDetail.getPhoneNumber());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
