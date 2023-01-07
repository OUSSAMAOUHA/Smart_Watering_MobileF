package ma.projet.arrosageintellegentv2.utils;

import ma.projet.arrosageintellegentv2.LoginActivity;


public class Crendentials {
    final public static String access_token = "";

    public static String getaccess_token() {
        return LoginActivity.sharref.getString("access_token", "");

    }

}