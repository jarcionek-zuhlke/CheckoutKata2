package checkoutkata2;

import org.junit.Test;

public class PriceProviderTest {

    private final PriceProvider priceProvider = new PriceProvider();

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForItemWithUndefinedPrice() {
        priceProvider.priceOf("Item with undefined price");
    }

}
