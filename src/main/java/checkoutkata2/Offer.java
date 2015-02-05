package checkoutkata2;

public class Offer {

    private final int itemCount;
    private final int specialPrice;

    public Offer(int itemCount, int specialPrice) {
        this.itemCount = itemCount;
        this.specialPrice = specialPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

}
