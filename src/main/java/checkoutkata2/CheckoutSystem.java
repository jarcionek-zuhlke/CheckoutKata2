package checkoutkata2;

import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CheckoutSystem {

    @SuppressWarnings("Convert2MethodRef")
    public int checkout(String... items) {
        return stream(items)
                .collect(groupingBy(item -> item, counting()))
                .entrySet().stream()
                .mapToInt(itemNameAndCount -> totalPriceOf(itemNameAndCount))
                .sum();
    }

    private int totalPriceOf(Map.Entry<String, Long> itemNameAndCount) {
        if (itemNameAndCount.getKey().equals("Apple")) {
            int applePrice = 60;
            int multiplesOfTwo = itemNameAndCount.getValue().intValue() / 2;
            int remainingItems = itemNameAndCount.getValue().intValue() % 2;
            return applePrice * multiplesOfTwo + applePrice * remainingItems;
        }
        return priceOf(itemNameAndCount.getKey()) * itemNameAndCount.getValue().intValue();
    }

    private static int priceOf(String item) {
        switch (item) {
            case "Orange": return 25;
        }
        throw new IllegalArgumentException(String.format("Price of %s is not defined", item));
    }

}
