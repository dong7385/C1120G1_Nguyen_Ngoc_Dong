package fast_food.fast_food_be.entity.paypal_link;

public class PayPalLink {
    private String link;

    public PayPalLink() {
    }

    public PayPalLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
