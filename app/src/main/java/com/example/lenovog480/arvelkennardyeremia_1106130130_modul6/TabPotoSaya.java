package com.example.lenovog480.arvelkennardyeremia_1106130130_modul6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TabPotoSaya extends Fragment {

    FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_poto_saya, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null){
            Intent pindah = new Intent(getActivity(), LoginActivity.class);
            startActivity(pindah);
            //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            getActivity().finish();

        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        return rootView;
    }
}
