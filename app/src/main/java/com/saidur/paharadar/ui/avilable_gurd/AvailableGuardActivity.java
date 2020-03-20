package com.saidur.paharadar.ui.avilable_gurd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.gurds.gurds;

import java.util.ArrayList;
import java.util.List;

public class AvailableGuardActivity extends AppCompatActivity {
    FirebaseRecyclerAdapter<gurds,AvailableViewHolder>Myadapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference onlineref,currentuserref,counterref;

    RecyclerView listavilable_gard;
    GurdAdapter adapter;
    List<gurds> gurds;

    //RecyclerView.LayoutManager layoutManager;
    //  DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_guard);

      /*  listavilable_gard = findViewById(R.id.available);
        listavilable_gard.setLayoutManager(new LinearLayoutManager(this));

        gurds = new ArrayList<>();

        gurds.add(new gurds("1","saidur rahman",R.drawable.me,"Head Security","on","01793208341","df","dfd","dfd"));
        gurds.add(new gurds("2","AGM Khair sabbir",R.drawable.agmk,"Head Security","on","01791587891","df","dfd","dfd"));
        gurds.add(new gurds("3","Muiedur Rahman",R.drawable.vai2,"Security","off","df","df","dfd","dfd"));
        gurds.add(new gurds("4","Fatema-Tuj-Johra",R.drawable.apu,"Security","off","df","df","dfd","dfd"));
        gurds.add(new gurds("5","Labib",R.drawable.labib1,"Security","on","df","df","dfd","dfd"));
        adapter = new GurdAdapter(this,gurds);
        listavilable_gard.setAdapter(adapter);*/
//firebase references
//        onlineref = FirebaseDatabase.getInstance().getReference().child(".info/connected");
//        counterref=FirebaseDatabase.getInstance().getReference("lastOnline");
//        currentuserref=FirebaseDatabase.getInstance().getReference("lastOnline")
//                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//
//        //setupSystem();
        //after setup system, we load all usser from counterref and display
        //this is online list
  //      updateGurdslist();
    }
/*
    private void updateGurdslist()
    {
        Myadapter= new FirebaseRecyclerAdapter<gurds, AvailableViewHolder>(
                gurds.class,R.layout.gard_model,
                AvailableViewHolder.class,
                counterref

        ) {
            @Override
            protected void populateViewHolder(AvailableViewHolder availableViewHolder, gurds gurds, int i)
            {
            //    availableViewHolder.email.setText(gurds.getEmail());
            }
        };

        Myadapter.notifyDataSetChanged();
        listavilable_gard.setAdapter(Myadapter);
    }*/

   /* private void setupSystem() {
        onlineref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue(Boolean.class))
                {
                    currentuserref.onDisconnect().removeValue();//remove user
                    //set online user in list

                    currentuserref.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(new gurds(FirebaseAuth.getInstance().getCurrentUser().getEmail(),"Online"));

                        Myadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        counterref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
                {
                    gurds gurd = postSnapshot.getValue(gurds.class);
                    Log.d("Log",""+gurd.getEmail()+" is"+gurd.getStatus());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

*/

}
