package com.example.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tittle3);
        TextView nom = findViewById(R.id.editText);
        TextView prenom = findViewById(R.id.editText2);
        TextView identifiant = findViewById(R.id.editText3);
        TextView dateNaissance = findViewById(R.id.editTextDate);
        TextView numéro = findViewById(R.id.editTextNumberDecimal2);
        ImageView pic = findViewById(R.id.imageView);

        Bundle extras = getIntent().getExtras();

        String username = "username not set";
        String usernickname = "usernickname not set";
        String userid = "userid not set";
        String userdate = "userdate not set";
        String usernumber = "usernumber not set";
        ImageView userpic ;

        if(extras != null){
            username = extras.getString("c1");
            userid = extras.getString("c2");
            usernumber = extras.getString("c3");/* 'a faire aprés'
            pic.setImageResource(Integer.parseInt(extras.getString("c4")));*/
        }
        nom.setText(username);
        identifiant.setText(userid);
            numéro.setText(usernumber);
    }
}