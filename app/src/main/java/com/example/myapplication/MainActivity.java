package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button createQRButton;
    private Button scanQRButton;

    private EditText userName;
    private EditText userHp;
    private EditText userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createQRButton = (Button) findViewById(R.id.createQR);
        scanQRButton = (Button) findViewById(R.id.scanQR);

        userName = (EditText) findViewById(R.id.infoName);
        userHp = (EditText) findViewById(R.id.infoHp);
        userEmail = (EditText) findViewById(R.id.infoEmail);

        createQRButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CreateQR.class);
                intent.putExtra("userName",userName.getText().toString());
                intent.putExtra("userHp",userHp.getText().toString());
                intent.putExtra("userEmail",userEmail.getText().toString());
                startActivity(intent);
            }
        });

        scanQRButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ScanQR.class);
                startActivity(intent);
            }
        });
    }
}
