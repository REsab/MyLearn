package com.resab.base.extentdt;

import lombok.Data;

@Data
public class Child extends Father {
    private String name;

    public Child() {

    }

    public Child(String firstName, String name) {
        super.setName(firstName);
        this.setName(name);
    }

}
