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
            return multiplesOfTwo * applePrice  + remainingItems * applePrice;
        }
        if (itemNameAndCount.getKey().equals("Orange")) {
            int orangePrice = 25;
            int multiplesOfThree = itemNameAndCount.getValue().intValue() / 3;
            int remainingItems = itemNameAndCount.getValue().intValue() % 3;
            return multiplesOfThree * orangePrice * 2 + remainingItems * orangePrice;

        }
        throw new IllegalArgumentException(String.format("Price of %s is not defined", itemNameAndCount.getKey()));
    }

}
