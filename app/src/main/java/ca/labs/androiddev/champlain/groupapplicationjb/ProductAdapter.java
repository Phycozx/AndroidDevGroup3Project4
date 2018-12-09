package ca.labs.androiddev.champlain.groupapplicationjb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;
import ca.labs.androiddev.champlain.groupapplicationjb.Models.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtName;
        TextView txtDescription;
        TextView txtPrice;

        public ViewHolder(View itemView)
        {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtProductName);
            txtDescription = itemView.findViewById(R.id.txtProductDescription);
            txtPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }

    private List<Product> mProducts;

    public ProductAdapter(List<Product> products)
    {
        mProducts = products;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.activity_store_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder viewHolder, int position)
    {
        Product product = mProducts.get(position);

        viewHolder.txtName.setText(product.getName());
        viewHolder.txtDescription.setText(product.getDescription());
        String priceStr = new DecimalFormat("$#,##0.00").format(product.getPrice());
        viewHolder.txtPrice.setText(priceStr);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount()
    {
        return mProducts.size();
    }
}

