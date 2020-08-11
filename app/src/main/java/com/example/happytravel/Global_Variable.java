package com.example.happytravel;

import android.app.Application;

public class Global_Variable extends Application {
    private boolean flag_login;

    public boolean getflag_login() {
        return flag_login;
    }

    public void setflag_login(boolean flag_login) {
        this.flag_login = flag_login;
    }
}
