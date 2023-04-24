package com.system.ZenDesk.Widget.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Requester {

    private String locale_id;
    private String name;
    private String email;

    private String phone;

    public String getLocale_id() {
        return locale_id;
    }

    public void setLocale_id(String locale_id) {
        this.locale_id = locale_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
