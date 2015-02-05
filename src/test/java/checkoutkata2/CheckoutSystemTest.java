package checkoutkata2;

import org.junit.Test;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class CheckoutSystemTest {

    private static final int APPLE_PRICE = 60;
    private static final int ORANGE_PRICE = 25;

    private final CheckoutSystem checkoutSystem = new CheckoutSystem();

    @Test
    public void calculatesTotalCostOfSingleItem() {
        int totalPrice = checkoutSystem.checkout("Apple");

        assertThat(totalPrice, is(equalTo(APPLE_PRICE)));
    }

    @Test
    public void calculatesTotalCostOfTwoSameItems() {
        int totalPrice = checkoutSystem.checkout("Orange", "Orange");

        assertThat(totalPrice, is(equalTo(ORANGE_PRICE * 2)));
    }

    @Test
    public void calculatesTotalCostOfMultipleVariousItems() {
        int totalPrice = checkoutSystem.checkout("Apple", "Orange", "Orange");

        assertThat(totalPrice, is(equalTo(APPLE_PRICE + ORANGE_PRICE * 2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenPriceOfItemIsUndefined() {
        checkoutSystem.checkout("Non-Existing-Item");
    }

    @Test
    public void calculatesTotalCostOfTwoApplesInOfferBuyOneGetOneFree() {
        int totalPrice = checkoutSystem.checkout("Apple", "Apple");

        assertThat(totalPrice, is(equalTo(APPLE_PRICE)));
    }
    
    @Test
    public void calculatesTotalCostOfThreeOrangesInOfferBuyTwoGetOneFree() {
        int totalPrice = checkoutSystem.checkout("Orange", "Orange", "Orange");

        assertThat(totalPrice, is(equalTo(ORANGE_PRICE * 2)));
    }

}
