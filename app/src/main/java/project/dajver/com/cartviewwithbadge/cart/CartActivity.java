package project.dajver.com.cartviewwithbadge.cart;

import project.dajver.com.cartviewwithbadge.BaseActivity;
import project.dajver.com.cartviewwithbadge.R;

public class CartActivity extends BaseActivity {

    @Override
    public int getViewId() {
        return R.layout.activity_cart;
    }

    @Override
    public void onCreateView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
