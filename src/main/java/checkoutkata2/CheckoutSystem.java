package checkoutkata2;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CheckoutSystem {

    private final PriceProvider priceProvider = new PriceProvider();
    private final OfferProvider offerProvider = new OfferProvider(priceProvider);

    public int checkout(String... items) {
        return stream(items)
                .collect(groupingBy(item -> item, counting()))
                .entrySet().stream()
                .mapToInt(entry -> priceOfItem(entry.getKey(), entry.getValue().intValue()))
                .sum();
    }

    private int priceOfItem(String itemName, int itemCount) {
        Offer offer = offerProvider.offerFor(itemName);

        int multiples = itemCount / offer.getItemCount();
        int remainingItems = itemCount % offer.getItemCount();
        return multiples * offer.getSpecialPrice() + remainingItems * priceProvider.priceOf(itemName);
    }

}
