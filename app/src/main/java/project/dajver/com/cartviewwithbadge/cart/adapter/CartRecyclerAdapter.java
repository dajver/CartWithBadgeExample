package project.dajver.com.cartviewwithbadge.cart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.dajver.com.cartviewwithbadge.R;
import project.dajver.com.cartviewwithbadge.cart.helper.CartHelper;
import project.dajver.com.cartviewwithbadge.cart.helper.entity.models.CartItemsEntityModel;

public class CartRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<CartItemsEntityModel> productEntityModel;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public CartRecyclerAdapter(Context context, List<CartItemsEntityModel> productEntityModel) {
        this.context = context;
        this.productEntityModel = productEntityModel;
    }

    public void updateItem(int position, CartItemsEntityModel cartItemsEntityModel) {
        if(cartItemsEntityModel.getQuantity() > 0) {
            productEntityModel.set(position, cartItemsEntityModel);
            CartHelper.getCart().update(cartItemsEntityModel.getProduct(), cartItemsEntityModel.getQuantity());
        } else {
            CartHelper.getCart().remove(productEntityModel.get(position).getProduct());
            onItemClickListener.onUpdateList();
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ReceiveViewHolder viewHolder = (ReceiveViewHolder) holder;
        viewHolder.name.setText(productEntityModel.get(position).getProduct().getName());
        viewHolder.description.setText(productEntityModel.get(position).getProduct().getDescription());
        viewHolder.price.setText(String.format(context.getString(R.string.dollars_format), productEntityModel.get(position).getProduct().getPrice()));
        viewHolder.quantity.setText(String.valueOf(productEntityModel.get(position).getQuantity()));
        Picasso.with(context).load(productEntityModel.get(position).getProduct().getImage()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return productEntityModel.size();
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.quantity)
        TextView quantity;
        @BindView(R.id.plus)
        Button plus;
        @BindView(R.id.minus)
        Button minus;

        public ReceiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {
                onItemClickListener.onItemClick(productEntityModel.get(getAdapterPosition()));
            });
            minus.setOnClickListener(view -> {
                onItemClickListener.onItemMinusClicked(getAdapterPosition(), productEntityModel.get(getAdapterPosition()));
            });
            plus.setOnClickListener(view -> {
                onItemClickListener.onItemPlusClicked(getAdapterPosition(), productEntityModel.get(getAdapterPosition()));
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(CartItemsEntityModel cartItemsEntityModel);
        void onItemPlusClicked(int position, CartItemsEntityModel cartItemsEntityModel);
        void onItemMinusClicked(int position, CartItemsEntityModel cartItemsEntityModel);
        void onUpdateList();
    }
}