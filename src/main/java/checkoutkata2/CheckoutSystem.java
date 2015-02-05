package checkoutkata2;

import static java.util.Arrays.stream;

public class CheckoutSystem {

    @SuppressWarnings("Convert2MethodRef")
    public int checkout(String... items) {
        return stream(items).mapToInt(item -> priceOf(item)).sum();
    }

    private static int priceOf(String item) {
        switch (item) {
            case "Apple":  return 60;
            case "Orange": return 25;
        }
        throw new IllegalArgumentException(String.format("Price of %s is not defined", item));
    }

}
