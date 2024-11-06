package com.example.ynsvalidation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ynsvalidation.R;
import com.example.ynsvalidation.database.Farmer;

import java.util.List;

public class FarmerAdapter extends RecyclerView.Adapter<FarmerAdapter.ViewHolder> {
    private List<Farmer> farmers;

    public FarmerAdapter(List<Farmer> farmers) {
        this.farmers = farmers;
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
    }

    @Override
    public int getItemCount() {
        return farmers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, ageTextView, mailTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.farmer_name);
            ageTextView = itemView.findViewById(R.id.farmer_age);
            mailTextView = itemView.findViewById(R.id.farmer_mail);
        }
    }
}
