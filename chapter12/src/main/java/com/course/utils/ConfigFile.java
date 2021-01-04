package com.course.utils;

import com.course.entity.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: gq
 * @createtime: 2020/12/18 15:18
 * @description: 从properties文件获取测试的url
 */
public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name) {
        String gateway = bundle.getString("gateway.url");
        String uri = null;
        //最终的测试地址
        String url = null;

        if (name == InterfaceName.GETUSERLIST) {
            uri = bundle.getString("getUserList.uri");
        }
        if (name == InterfaceName.LOGIN) {
            uri = bundle.getString("login.uri");
        }
        if (name == InterfaceName.UPDATEUSERINFO) {
            uri = bundle.getString("updateUserInfo.uri");
        }
        if (name == InterfaceName.GETUSERINFO) {
            uri = bundle.getString("getUserInfo.uri");
        }
        if (name == InterfaceName.ADDUSER) {
            uri = bundle.getString("addUser.uri");
        }
        url = gateway + uri;

        return url;
    }
}
