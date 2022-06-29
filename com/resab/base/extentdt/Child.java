package com.resab.base.extentdt;

import lombok.Data;

@Data
public class Child extends Father {
    private String name;

    public Child() {

    }

    public Child(String str1, String str2) {
        super.setName(str1);
        this.setName(str2);
    }

}
