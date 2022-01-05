package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
Button b1;
EditText e1,e2,e3,e4;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        b1=(Button)findViewById(R.id.button);
        firebaseDatabase=FirebaseDatabase.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference=firebaseDatabase.getReference("users");
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                if(s4.length()!=10)
                {
                    Toast.makeText(MainActivity.this, "Enter A valid Phone Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    users users=new users(s1,s2,s3,s4);
                    databaseReference.child(s4).setValue(users);
                    Toast.makeText(MainActivity.this, "Database Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}