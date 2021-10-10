package utils;

public class Utils {

    public static String getBaseURL(){
        return "http://automationpractice.com/";
    }

    public static String getLoginPageURL(){
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }

    public static String getLoggedUserPageURL(){
        return "http://automationpractice.com/index.php?controller=my-account";
    }
}
