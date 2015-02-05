package checkoutkata2;

import static java.util.Arrays.stream;

public class CheckoutSystem {

    @SuppressWarnings("Convert2MethodRef")
    public int checkout(String... items) {
        return stream(items).mapToInt(item -> priceOf(item)).sum();
    }

    private static int priceOf(String item) {
        if (item.equals("Apple")) {
            return 60;
        } else {
            return 25;
        }
    }

}
