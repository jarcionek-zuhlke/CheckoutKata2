package checkoutkata2;

import org.junit.Test;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class CheckoutSystemTest {

    private final CheckoutSystem checkoutSystem = new CheckoutSystem();

    @Test
    public void calculatesTotalCostOfSingleItem() {
        int totalPrice = checkoutSystem.checkout("Apple");

        assertThat(totalPrice, is(equalTo(60)));
    }

}
