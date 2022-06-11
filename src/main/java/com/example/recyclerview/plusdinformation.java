package com.example.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class plusdinformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plusdinformation);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tittle3);
        TextView nom = (TextView) findViewById(R.id.editText);
        TextView prenom = findViewById(R.id.editText2);
        TextView identifiant = findViewById(R.id.editText3);
        TextView dateNaissance = findViewById(R.id.editTextDate);
        TextView numéro = findViewById(R.id.editTextNumberDecimal2);
        ImageView pic = findViewById(R.id.imageView);
        ImageView call = findViewById(R.id.button5);
        ImageView sendsms = findViewById(R.id.button4);

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
            usernumber = extras.getString("c3");
//            pic.setImageResource(Integer.parseInt(extras.getString("c4")));
        }
        nom.setText(username);

        identifiant.setText(userid);
        numéro.setText(usernumber);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + numéro.getText().toString()));

                startActivity(intent);
            }
        });
        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plusdinformation.this,envoiesms.class);
                intent.putExtra("c10",numéro.getText().toString());

                startActivity(intent);
            }
        });
    }
}