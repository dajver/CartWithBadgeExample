package project.dajver.com.cartviewwithbadge.product;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.math.BigDecimal;

import butterknife.BindView;
import project.dajver.com.cartviewwithbadge.BaseFragment;
import project.dajver.com.cartviewwithbadge.R;
import project.dajver.com.cartviewwithbadge.cart.CartActivity;
import project.dajver.com.cartviewwithbadge.cart.helper.CartHelper;
import project.dajver.com.cartviewwithbadge.cart.helper.entity.CartEntity;
import project.dajver.com.cartviewwithbadge.cart.helper.entity.models.ProductEntityModel;
import project.dajver.com.cartviewwithbadge.etc.ProductsHelper;
import project.dajver.com.cartviewwithbadge.product.adapter.ProductRecyclerAdapter;
import project.dajver.com.cartviewwithbadge.product.adapter.models.ProductModel;

public class ProductFragment extends BaseFragment implements ProductRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public int getViewId() {
        return R.layout.fragment_product;
    }

    @Override
    public void onViewCreated(View view) {
        ProductRecyclerAdapter productRecyclerAdapter = new ProductRecyclerAdapter(context, ProductsHelper.getProductsList());
        productRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(productRecyclerAdapter);
    }

    @Override
    public void onItemClick(ProductModel productModel) {
        ProductEntityModel product = new ProductEntityModel();
        product.setId(productModel.getId());
        product.setName(productModel.getTitle());
        product.setDescription(productModel.getDescription());
        product.setPrice(BigDecimal.valueOf(productModel.getPrice()));
        product.setImage(productModel.getImage());

        CartEntity cart = CartHelper.getCart();
        cart.add(product, 1);

        Intent intent = new Intent(context, CartActivity.class);
        startActivity(intent);

        getActivity().invalidateOptionsMenu();
    }
}
