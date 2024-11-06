package com.example.ynsvalidation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ynsvalidation.R;
import com.example.ynsvalidation.database.AppDatabase;
import com.example.ynsvalidation.database.Farm;
import com.example.ynsvalidation.database.Farmer;

import java.util.List;

public class FarmerAdapter extends RecyclerView.Adapter<FarmerAdapter.ViewHolder> {
    private List<Farmer> farmers;
    private AppDatabase db;

    public FarmerAdapter(List<Farmer> farmers, AppDatabase db) {
        this.farmers = farmers;
        this.db = db;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Farmer farmer = farmers.get(position);
        holder.nameTextView.setText(farmer.name);
        holder.mailTextView.setText("Email: " + farmer.email);
        holder.ageTextView.setText("Age: " + String.valueOf(farmer.age));

        new Thread(() -> {
            List<Farm> farms = db.farmDao().getFarmsForFarmer(farmer.id);
            int farmCount = farms.size();
            holder.farmCountTextView.setText("Farms: " + farmCount);

            holder.itemView.setOnClickListener(v -> {
                // Code to display farms in a dialog or new fragment can be implemented here
            });
        }).start();
    }

    @Override
    public int getItemCount() {
        return farmers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, ageTextView, mailTextView, farmCountTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.farmer_name);
            ageTextView = itemView.findViewById(R.id.farmer_age);
            mailTextView = itemView.findViewById(R.id.farmer_mail);
            farmCountTextView = itemView.findViewById(R.id.farm_count);
        }
    }
}
