package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<HealthProductItem> healtProdList;
    private Context context;

    public CustomAdapter(List<HealthProductItem> healtProdList, Context context) {
        this.healtProdList = healtProdList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_health_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        HealthProductItem currentItem = healtProdList.get(position);
        holder.textViewHead.setText(currentItem.getHead());
        holder.textViewDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return healtProdList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.itemHead);
            textViewDescription = (TextView) itemView.findViewById(R.id.itemDescription);
        }
    }
}
