package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class envoiesms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoiesms);
        TextView numéro1 = findViewById(R.id.editText9);
        EditText sms = findViewById(R.id.editText10);
        Button sendingsms = findViewById(R.id.button50);

        String usernumber;
        Bundle extras = getIntent().getExtras();
        usernumber = extras.getString("c10");

        numéro1.setText(usernumber);

        ActivityCompat.requestPermissions (envoiesms.this, new String[]{new String(Manifest.permission.SEND_SMS)}, PackageManager.PERMISSION_GRANTED);

        sendingsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendsms(v);
            }
        });
    }
        public void sendsms(View view){
            TextView numéro2 = findViewById(R.id.editText9);
            EditText sms1 = findViewById(R.id.editText10);

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numéro2.getText().toString(),
                    null,
                    sms1.getText().toString(),
                    null,
                    null);
        }
}