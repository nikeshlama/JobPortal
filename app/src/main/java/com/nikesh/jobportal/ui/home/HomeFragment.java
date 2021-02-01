 package com.nikesh.jobportal.ui.home;

 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.EditText;
 import android.widget.ImageView;
 import android.widget.ProgressBar;

 import androidx.annotation.NonNull;
 import androidx.fragment.app.Fragment;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

 import com.google.firebase.auth.FirebaseAuth;
 import com.google.firebase.auth.FirebaseUser;
 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.Query;
 import com.google.firebase.database.ValueEventListener;
 import com.nikesh.jobportal.Adapter.HomeAdapter;
 import com.nikesh.jobportal.Model.Events;
 import com.nikesh.jobportal.Model.Following;
 import com.nikesh.jobportal.R;

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.List;

 import de.hdodenhof.circleimageview.CircleImageView;

 public class HomeFragment extends Fragment {


     RecyclerView recyclerView;



     List<Events> events;
     DatabaseReference reference;
     FirebaseUser firebaseUser;
     HomeAdapter homeAdapter;
     private RecyclerView.LayoutManager layoutManager;
     ProgressBar progressBar;


     public View onCreateView(@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {

         View root = inflater.inflate(R.layout.fragment_home, container, false);
         recyclerView = root.findViewById(R.id.homeRecycleView);
         recyclerView.setHasFixedSize(true);
         layoutManager = new LinearLayoutManager(getContext());
         recyclerView.setLayoutManager(layoutManager);
         events = new ArrayList<>();
         firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
         progressBar = root.findViewById(R.id.progressbarRecycleView);

         readEvents();
         return root;
     }
     public void readEvents()
     {
         progressBar.setVisibility(View.VISIBLE);

         reference = FirebaseDatabase.getInstance().getReference("Events");

         reference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                 {
                     Events event = dataSnapshot1.getValue(Events.class);
                     events.add(event);
                     progressBar.setVisibility(View.GONE);

                 }
                 Collections.reverse(events);
                 homeAdapter = new HomeAdapter(getContext(),events,firebaseUser.getUid());
                 recyclerView.setAdapter(homeAdapter);
             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }

         });
         progressBar.setVisibility(View.GONE);

     }

     @Override
     public void onStart() {
         super.onStart();
     }

 }