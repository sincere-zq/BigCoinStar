package com.netson.commonmodule.bean;

import java.io.Serializable;

public class OnChangeLanguageEvent implements Serializable {
    public int languageType;

    public OnChangeLanguageEvent(int languageType) {
        this.languageType = languageType;
    }
}
