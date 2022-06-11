package com.example.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ajouterActivity extends AppCompatActivity {

    private Button btnImport;
    private ImageView selectedImg;
    private EditText nom ;
    private EditText prenom ;
    private EditText identité;
    Database database;
    Bitmap selectedImage;

    private EditText date;
    private EditText num;

    static final int RESULT_LOAD_IMG = 1;
    Button btnajouter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_activity);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tittle1);
        btnImport = findViewById(R.id.button2);
        selectedImg = findViewById(R.id.imageView);
        btnajouter = findViewById(R.id.button);
        nom = findViewById(R.id.editText);
        prenom = findViewById(R.id.editText2);
        identité = findViewById(R.id.editText3);
        date = findViewById(R.id.editText3);
        num =findViewById(R.id.editTextNumberDecimal2);
        MainActivity.modelClass=new ModelClass();
        btnImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);

            }
        });
        btnajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelClass e=new ModelClass(Integer.parseInt(identité.getText().toString().trim()),nom.getText().toString().trim(),
                        prenom.getText().toString().trim(),
                        date.getText().toString().trim(),
                        num.getText().toString().trim());
                
                Intent intent=new Intent(ajouterActivity.this,MainActivity.class);
                startActivity(intent);
                /*
                MainActivity.modelClass.setNom(nom.getText().toString());
                MainActivity.modelClass.setPrenom(prenom.getText().toString());
                MainActivity.modelClass.setIdentité(identité.getText().toString());
                MainActivity.modelClass.setNumber(num.getText().toString());
                MainActivity.modelClass.setDate(date.getText().toString());
                Intent i = new Intent(ajouterActivity.this,MainActivity.class);
                i.putExtra("c51",nom.getText().toString());
                i.putExtra("c52",prenom.getText().toString());
                i.putExtra("c53",identité.getText().toString());
                i.putExtra("c54",date.getText().toString());
                i.putExtra("c55",num.getText().toString());
                i.putExtra("c56",String.valueOf(selectedImg));

                MainActivity.modelClass.setImage(selectedImage);
                MainActivity.modelClass.setNom(nom);
                MainActivity.modelClass.setIdentité(identité);
                MainActivity.modelClass.setNumber(num);
                MainActivity.modelClass.setDate(date);
                MainActivity.modelClass.setPrenom(prenom);
*/

            }
        });
    }
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                /*selectedImage = BitmapFactory.decodeStream(imageStream);
                selectedImg.setImageBitmap(selectedImage);
            */} catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Une erreur s'est produite",Toast.LENGTH_LONG).show();

            }

        }else {
            Toast.makeText(getApplicationContext(),"Vous n'avez pas choisi d'image", Toast.LENGTH_LONG).show();

        }
    }
}