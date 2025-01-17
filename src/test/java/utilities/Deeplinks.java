package utilities;

public class Deeplinks {
    private static final String completeCheckout = "swaglabs://complete";
    private static final String itemDetail = "swaglabs://swag-item/%d";
    private static final String webView = "swaglabs://webview";
    private static final String yourCart = "swaglabs://cart/%s";
    private static final String shopping = "swaglabs://swag-overview/%s";

    private static void goTo(String deeplink) {
        new DriverProvider().get().get(deeplink);
    }

    public static void goToCompleteCheckout() {
        goTo(completeCheckout);
    }

    public static void goToItemDetail(int index) {
        final var deeplinks = String.format(yourCart, index);
        goTo(deeplinks);
    }

    public static void goToYourCart(String list) {
        final var deepLinks = String.format(yourCart, list);
        goTo(deepLinks);
    }

    public static void goToWebView() {
        goTo(webView);
    }

    public static void goToShopping(String list) {
        final var deeplinks = String.format(shopping, list);
        goTo(deeplinks);
    }
}
