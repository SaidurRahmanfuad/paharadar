package com.saidur.paharadar.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.home.adapter.PostAdapter;
import com.saidur.paharadar.ui.home.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    private List<Post> posts;
    private PostAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.rv_home_post_show_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        posts = new ArrayList<>();

        posts.add(new Post("Todays Launch", "Lounch can be provided by lounch house","Type_Normal"));
        posts.add(new Post("Meeting", "Meeting at 4pm in central meeting house.All the gards are requested to come at right time in serious issughnbnyghhbfvhhdsfhb vhbn vnbnmnvnbn\n" +
                "vvnn Collecting and analyzing the requirements is a very important term for developing a system or any type of android application. Our application’s target users are doctors and patients. ","Type_Urgent"));
        posts.add(new Post("Regular Duty", "10am to 1pm in main area","Type_Duty"));
        adapter = new PostAdapter(getActivity(),posts);

        recyclerView.setAdapter(adapter);

       // Toast.makeText(getActivity(), posts.get(0).getTitle(), Toast.LENGTH_SHORT).show();



        return root;
    }


}