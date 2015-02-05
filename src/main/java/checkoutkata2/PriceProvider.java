package checkoutkata2;

public class PriceProvider {

    public int priceOf(String item) {
        switch (item) {
            case "Apple":  return 60;
            case "Orange": return 25;
        }
        throw new IllegalArgumentException(String.format("Price of %s is not defined", item));
    }

}
