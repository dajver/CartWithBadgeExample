package project.dajver.com.cartviewwithbadge.cart.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project.dajver.com.cartviewwithbadge.cart.helper.i.Saleable;
import project.dajver.com.cartviewwithbadge.cart.helper.entity.CartEntity;
import project.dajver.com.cartviewwithbadge.cart.helper.entity.models.CartItemsEntityModel;
import project.dajver.com.cartviewwithbadge.cart.helper.entity.models.ProductEntityModel;

public class CartHelper {

    private static CartEntity cartEntity = new CartEntity();

    public static CartEntity getCart() {
        if (cartEntity == null) {
            cartEntity = new CartEntity();
        }

        return cartEntity;
    }

    public static List<CartItemsEntityModel> getCartItems() {
        List<CartItemsEntityModel> cartItems = new ArrayList<>();
        Map<Saleable, Integer> itemMap = getCart().getItemWithQuantity();

        for (Map.Entry<Saleable, Integer> entry : itemMap.entrySet()) {
            CartItemsEntityModel cartItem = new CartItemsEntityModel();
            cartItem.setProduct((ProductEntityModel) entry.getKey());
            cartItem.setQuantity(entry.getValue());
            cartItems.add(cartItem);
        }

        return cartItems;
    }
}
