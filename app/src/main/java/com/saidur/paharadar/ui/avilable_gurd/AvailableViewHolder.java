package com.saidur.paharadar.ui.avilable_gurd;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.saidur.paharadar.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AvailableViewHolder extends RecyclerView.ViewHolder {
    public TextView email;

    public AvailableViewHolder(@NonNull View itemView) {
        super(itemView);
        email=itemView.findViewById(R.id.gardemail);
    }
}
