package com.example.lnmapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    int fl=1;
    EditText password;
    EditText username;
    Button button;
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Welcome!");

        password=findViewById(R.id.pass);
        username=findViewById(R.id.user);
        if(mAuth.getCurrentUser()!=null){
            login();
        }



    }

    @Override
    protected void onStart() {
        if(mAuth.getCurrentUser()!=null){
            login();
        }
        super.onStart();
    }

    public void goClicked(final View view) {
        if (password.getText().toString().isEmpty()  || username.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter Password and Username", Toast.LENGTH_SHORT).show();
            // return;
        } else {
            final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "",
                    "Loading. Please wait...", true);
            dialog.show();

            Runnable progressRunnable = new Runnable() {

                @Override
                public void run() {
                    dialog.cancel();
                }
            };

            Handler pdCanceller = new Handler();
            pdCanceller.postDelayed(progressRunnable, 1500);
            mAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                FirebaseDatabase.getInstance().getReference().child("users").child(task.getResult().getUser().getUid()).child("email").setValue(username.getText().toString());
                                login();
                            } else {

                                mAuth.createUserWithEmailAndPassword(username.getText().toString(), password.getText().toString());

                                if (task.isSuccessful()) {

                                    FirebaseDatabase.getInstance().getReference().child("users").child(task.getResult().getUser().getUid()).child("email").setValue(username.getText().toString());
                                    login();
                                } else {

                                    Toast.makeText(getApplicationContext(), "Login Failed,Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });

        }
    }
    public void signup(View view){
        Intent intent =new Intent(this,SignUp.class);
        startActivity(intent);
    }
    public void guest(View view){
        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }
    void login(){
      //  FirebaseDatabase.getInstance().getReference().child("users").child("uuid").child("email").setValue(username.getText().toString());

        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        intent.putExtra("username",username.getText());
        Log.i("user",username.getText().toString());
        startActivity(intent);

    }
}