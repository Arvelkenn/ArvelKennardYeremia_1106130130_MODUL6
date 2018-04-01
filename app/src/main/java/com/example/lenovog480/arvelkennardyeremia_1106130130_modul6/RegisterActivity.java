package com.example.lenovog480.arvelkennardyeremia_1106130130_modul6;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText memail, mpass;
    Button mdaftar;
    TextView mlogin;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Popotoan");

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            Intent pindah = new Intent(RegisterActivity.this, HalamanUtamaActivity.class);
            startActivity(pindah);
            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        memail = (EditText)findViewById(R.id.edtEmail);
        mpass = (EditText)findViewById(R.id.edtPass);
        mdaftar = (Button)findViewById(R.id.btnRegist);
        mlogin = (TextView)findViewById(R.id.txtLogin);

        mdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regist();

            }
        });

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(RegisterActivity.this, HalamanUtamaActivity.class);
                startActivity(login);
                finish();
            }
        });
    }

    public void regist(){
        String Email = memail.getText().toString().trim();
        String Pass = mpass.getText().toString().trim();

        if(TextUtils.isEmpty(Email)){
            Toast.makeText(RegisterActivity.this, "Masukkan Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Pass)){
            Toast.makeText(RegisterActivity.this, "Masukkan Password", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(RegisterActivity.this, "Register berhasil", Toast.LENGTH_SHORT).show();
                    Intent pindah = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(pindah);
                    //startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                }else {
                    Toast.makeText(RegisterActivity.this, "Register gagal, harap ulangi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
