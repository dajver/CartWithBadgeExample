package project.dajver.com.cartviewwithbadge.cart.helper.entity.models;

public class CartItemsEntityModel {
    private ProductEntityModel product;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntityModel getProduct() {
        return product;
    }

    public void setProduct(ProductEntityModel product) {
        this.product = product;
    }
}
