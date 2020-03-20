package com.saidur.paharadar.ui.avilable_gurd;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.gurd_location.GurdMapsActivity;
import com.saidur.paharadar.ui.gurds.gurds;
import com.saidur.paharadar.ui.home.model.Post;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GurdAdapter extends RecyclerView.Adapter<GurdAdapter.MyViewHolder> implements View.OnClickListener {

    private Context context;
    private List<gurds> gurds= new ArrayList<>();

    public GurdAdapter(Context context, List<gurds> gurds) {
        this.context = context;
        this.gurds = gurds;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.model_gurds_show,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        final gurds gurd = gurds.get(position);
       // holder.location_map.setText(gurd.getLatitude());
        holder.imageView.setImageResource(gurd.getImage());
        holder.name.setText(gurd.getName());
        holder.desig.setText(gurd.getDesignation());
        holder.call.setText("Call");

        holder.call.setOnClickListener(this);
        holder.location_map.setOnClickListener(this);

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Call", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                callIntent.setData(Uri.parse("tel://"+gurd.getPhoneNumber(position)));
                context.startActivity(callIntent);
            }
        });


        if(gurd.getStatus().equals("on"))
        {
            holder.status.setImageResource(R.drawable.shape_circle_green);

        }else {
            holder.status.setImageResource(R.drawable.shape_circle_red);
        }

    }

    @Override
    public int getItemCount() {
        return gurds.size();
    }

    @Override
    public void onClick(View view) {
        final gurds gurd = new gurds();
        switch (view.getId()){
            case R.id.model_tv_gurd_location_show:
                Intent gotomap = new Intent(context, GurdMapsActivity.class);
                context.startActivity(gotomap);
                break;

        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,desig,call,location_map;
        ImageView imageView,status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.model_tv_guard_title_show);
            call = itemView.findViewById(R.id.model_tv_guard_call_show);
            desig = itemView.findViewById(R.id.model_tv_guard_details_show);
            status = itemView.findViewById(R.id.model_tv_guard_status_show);
            imageView = itemView.findViewById(R.id.model_iv_guard_profile_show);
           location_map=itemView.findViewById(R.id.model_tv_gurd_location_show);
            //gurdlocation=itemView.findViewById(R.id.model_tv_gurd_location_show);
        }
    }
}
