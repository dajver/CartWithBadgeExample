package project.dajver.com.cartviewwithbadge.product.adapter;

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
import project.dajver.com.cartviewwithbadge.product.adapter.models.ProductModel;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ProductModel> catalogModels;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public ProductRecyclerAdapter(Context context, List<ProductModel> catalogModels) {
        this.context = context;
        this.catalogModels = catalogModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ReceiveViewHolder viewHolder = (ReceiveViewHolder) holder;
        viewHolder.title.setText(catalogModels.get(position).getTitle());
        viewHolder.description.setText(catalogModels.get(position).getDescription());
        viewHolder.price.setText(String.format(context.getString(R.string.dollars_format), catalogModels.get(position).getPrice()));
        Picasso.with(context).load(catalogModels.get(position).getImage()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return catalogModels.size();
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.buyButton)
        Button buyButton;

        public ReceiveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            buyButton.setOnClickListener(view -> {
                onItemClickListener.onItemClick(catalogModels.get(getAdapterPosition()));
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(ProductModel productModel);
    }
}