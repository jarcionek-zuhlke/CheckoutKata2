package checkoutkata2;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CheckoutSystem {

    public int checkout(String... items) {
        return stream(items)
                .collect(groupingBy(item -> item, counting()))
                .entrySet().stream()
                .mapToInt(entry -> priceOfItem(entry.getKey(), entry.getValue().intValue()))
                .sum();
    }

    private static int priceOfItem(String itemName, int itemCount) {
        switch (itemName) {
            case "Apple":  return priceOfItem(60, itemCount, new Offer(2, 60));
            case "Orange": return priceOfItem(25, itemCount, new Offer(3, 50));
        }
        throw new IllegalArgumentException(String.format("Price of %s is not defined", itemName));
    }

    private static int priceOfItem(int itemPrice, int itemCount, Offer offer) {
        int multiples = itemCount / offer.getItemCount();
        int remainingItems = itemCount % offer.getItemCount();
        return multiples * offer.getSpecialPrice() + remainingItems * itemPrice;
    }

}
