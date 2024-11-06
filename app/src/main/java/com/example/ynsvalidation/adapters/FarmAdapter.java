package com.example.ynsvalidation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ynsvalidation.R;
import com.example.ynsvalidation.database.Farm;

import java.util.List;

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.ViewHolder> {
    private List<Farm> farms;

    public FarmAdapter(List<Farm> farms) {
        this.farms = farms;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farm_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Farm farm = farms.get(position);
        holder.nameTextView.setText(farm.name);
        holder.locationTextView.setText(String.valueOf(farm.location));
        holder.farmerIdTextView.setText(farm.farmerId);
    }

    @Override
    public int getItemCount() {
        return farms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, locationTextView , farmerIdTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.farm_name);
            locationTextView = itemView.findViewById(R.id.farm_location);
            farmerIdTextView = itemView.findViewById(R.id.farmer_id);
        }
    }
}
