package checkoutkata2;

public class OfferProvider {

    private final PriceProvider priceProvider;

    public OfferProvider(PriceProvider priceProvider) {
        this.priceProvider = priceProvider;
    }

    public Offer offerFor(String item) {
        switch (item) {
            case "Apple":  return new Offer(2, priceProvider.priceOf(item));
            case "Orange": return new Offer(3, 2 * priceProvider.priceOf(item));
        }
        throw new IllegalArgumentException(String.format("No offer for %s", item));
    }

}
