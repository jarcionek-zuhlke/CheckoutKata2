package checkoutkata2;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CheckoutSystem {

    @SuppressWarnings("Convert2MethodRef")
    public int checkout(String... items) {
        return stream(items)
                .collect(groupingBy(item -> item, counting()))
                .entrySet().stream()
                .mapToInt(entry -> totalPriceOfItemWithOffer(entry.getKey(), entry.getValue().intValue()))
                .sum();
    }

    private static int totalPriceOfItemWithOffer(String itemName, int itemCount) {
        switch (itemName) {
            case "Apple":  return totalPriceOfItem(itemCount, 60, new Offer(2, 60));
            case "Orange": return totalPriceOfItem(itemCount, 25, new Offer(3, 50));
        }
        throw new IllegalArgumentException(String.format("Price of %s is not defined", itemName));
    }

    private static int totalPriceOfItem(int itemCount, int applePrice, Offer appleOffer) {
        int multiples = itemCount / appleOffer.getItemCount();
        int remainingItems = itemCount % appleOffer.getItemCount();
        return multiples * appleOffer.getSpecialPrice() + remainingItems * applePrice;
    }

}
