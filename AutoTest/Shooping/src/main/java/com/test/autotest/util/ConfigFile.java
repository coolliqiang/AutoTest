package com.test.autotest.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("testUrl", Locale.CHINA);
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String interfaceUrl = "";
        //最终的接口请求地址
        String testUrl ;
        if(name == InterfaceName.LOGININFO){
            interfaceUrl = bundle.getString("login.uri");
        }
        if(name == InterfaceName.REGISTERINFO){
            interfaceUrl = bundle.getString("register.uri");
        }
        testUrl = address+interfaceUrl;
        return testUrl;

    }
}
