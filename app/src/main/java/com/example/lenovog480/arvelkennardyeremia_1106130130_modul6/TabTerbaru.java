package com.example.lenovog480.arvelkennardyeremia_1106130130_modul6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TabTerbaru extends Fragment {

    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Information> list;
    RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.tab_terbaru, container, false);


        database = FirebaseDatabase.getInstance();
       myRef = FirebaseDatabase.getInstance().getReference().child("arvelkennardyeremia");
        myRef.keepSynced(true);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        onstart();


        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null){
            Intent pindah = new Intent(getActivity(), LoginActivity.class);
            startActivity(pindah);
            //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            getActivity().finish();

        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //onstart();

        return rootView;
    }

    public void onstart(){
        //super.onStart();
        FirebaseRecyclerAdapter<Information, InformationViewHolder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Information, InformationViewHolder>
                (Information.class, R.layout.card_view, InformationViewHolder.class,myRef) {
            @Override
            protected void populateViewHolder(InformationViewHolder viewHolder, Information model, int position) {
                viewHolder.setTitle(model.getTitles());
                viewHolder.setDetail(model.getPost());
                viewHolder.setImage(getContext(), model.getThumbnail());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class InformationViewHolder extends RecyclerView.ViewHolder {
        View view;
        public InformationViewHolder(View itemView){
            super(itemView);
            view = itemView;
        }
        public void setTitle(String title){
            TextView post_titel = (TextView)view.findViewById(R.id.txtJudul);
            post_titel.setText(title);
        }
        public void setDetail(String detail){
            TextView post_detail = (TextView)view.findViewById(R.id.txtDetail);
            post_detail.setText(detail);
        }
        public void setImage(Context ctx,String image){
            ImageView post_gambar = (ImageView)view.findViewById(R.id.gambar);
            Picasso.with(ctx).load(image).into(post_gambar);
    }}}

