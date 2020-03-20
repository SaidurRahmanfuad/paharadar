package com.saidur.paharadar.ui.avilable_gurd;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.gurd_location.GurdMapsActivity;
import com.saidur.paharadar.ui.gurds.gurds;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Available_gurdFragment extends Fragment {

    private RecyclerView listavilable_gard;
    private GurdAdapter adapter;
    private List<gurds> gurds;
    //TextView gard_location;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_available_gurd, container, false);

        //gard_location = root.findViewById(R.id.model_tv_gurd_location_show);
        listavilable_gard = root.findViewById(R.id.available);
        listavilable_gard.setLayoutManager(new LinearLayoutManager(getActivity()));

        gurds = new ArrayList<>();

        gurds.add(new gurds("1","saidur rahman",R.drawable.me,"Head Security","on","01793208341","df","dfd","dfd"));
        gurds.add(new gurds("2","AGM Khair sabbir",R.drawable.agmk,"Head Security","on","01791587891","df","dfd","dfd"));
        gurds.add(new gurds("3","Muiedur Rahman",R.drawable.vai2,"Security","off","01822823904","df","dfd","dfd"));
        gurds.add(new gurds("4","Fatema-Tuj-Johra",R.drawable.apu,"Security","off","01723806959","df","dfd","dfd"));
        gurds.add(new gurds("5","Labib",R.drawable.labib1,"Security","on","01234567891","dg","dfd","dfd"));
        gurds.add(new gurds("6","Labib",R.drawable.agmk,"Security","on","01672296300","df","dfd","dfd"));
        gurds.add(new gurds("7","Labib",R.drawable.me,"Security","on","0195324321","df","dfd","dfd"));
        gurds.add(new gurds("8","Labib",R.drawable.labib1,"Security","on","0163423478","df","dfd","dfd"));
        gurds.add(new gurds("9","Labib",R.drawable.me,"Security","on","0123216436","df","dfd","dfd"));
        gurds.add(new gurds("10","Labib",R.drawable.vai2,"Security","on","01420420420","df","dfd","dfd"));

        adapter = new GurdAdapter(getActivity(),gurds);
        listavilable_gard.setAdapter(adapter);

      /*  gard_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gomap = new Intent(getActivity(), GurdMapsActivity.class);
                startActivity(gomap);
            }
        });*/
//firebase references
        return root;
    }

}
