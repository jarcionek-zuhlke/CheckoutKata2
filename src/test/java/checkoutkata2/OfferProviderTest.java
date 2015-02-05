package checkoutkata2;

import org.junit.Test;

public class OfferProviderTest {

    private static final PriceProvider UNUSED_PRICE_PROVIDER = null;

    private final OfferProvider offerProvider = new OfferProvider(UNUSED_PRICE_PROVIDER);

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForItemWithNoOffer() {
        offerProvider.offerFor("item with no offer");
    }

}
