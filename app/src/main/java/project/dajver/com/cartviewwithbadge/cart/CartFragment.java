package project.dajver.com.cartviewwithbadge.cart;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import project.dajver.com.cartviewwithbadge.BaseFragment;
import project.dajver.com.cartviewwithbadge.R;
import project.dajver.com.cartviewwithbadge.cart.adapter.CartRecyclerAdapter;
import project.dajver.com.cartviewwithbadge.cart.helper.CartHelper;
import project.dajver.com.cartviewwithbadge.cart.helper.entity.models.CartItemsEntityModel;

public class CartFragment extends BaseFragment implements CartRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CartRecyclerAdapter productRecyclerAdapter;

    @Override
    public int getViewId() {
        return R.layout.fragment_cart;
    }

    @Override
    public void onViewCreated(View view) {
        onUpdateList();
    }

    @Override
    public void onItemClick(CartItemsEntityModel cartItemsEntityModel) {
        // open details of product
    }

    @Override
    public void onItemPlusClicked(int position, CartItemsEntityModel cartItemsEntityModel) {
        int quantity = cartItemsEntityModel.getQuantity();
        CartItemsEntityModel cartModel = new CartItemsEntityModel();
        cartModel.setProduct(cartItemsEntityModel.getProduct());
        quantity++;
        cartModel.setQuantity(quantity);
        productRecyclerAdapter.updateItem(position, cartModel);
    }

    @Override
    public void onItemMinusClicked(int position, CartItemsEntityModel cartItemsEntityModel) {
        int quantity = cartItemsEntityModel.getQuantity();
        CartItemsEntityModel cartModel = new CartItemsEntityModel();
        cartModel.setProduct(cartItemsEntityModel.getProduct());
        quantity--;
        cartModel.setQuantity(quantity);
        productRecyclerAdapter.updateItem(position, cartModel);
    }

    @Override
    public void onUpdateList() {
        productRecyclerAdapter = new CartRecyclerAdapter(context, CartHelper.getCartItems());
        productRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(productRecyclerAdapter);
    }

    @OnClick(R.id.buyButton)
    public void onBuyClick() {
        Toast.makeText(context, String.format(getString(R.string.cart_success_message), CartHelper.getCart().getTotalQuantity(), CartHelper.getCart().getTotalPrice()), Toast.LENGTH_LONG).show();
        CartHelper.getCart().clear();
        getActivity().finish();
    }
}
