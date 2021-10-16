package utils;

public class Utils {

    public static String getHomePageURL() {
        return "http://automationpractice.com/";
    }

    public static String getLoginPageURL() {
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }

    public static String getAccountCreationURL() {
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    }

    public static String getLoggedUserPageURL() {
        return "http://automationpractice.com/index.php?controller=my-account";
    }

    public static String getSearchByDressPageURL() {
        return "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
    }
}