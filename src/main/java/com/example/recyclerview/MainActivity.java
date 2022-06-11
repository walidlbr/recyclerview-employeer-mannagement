package com.example.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private List<Call.Details> detailsList;

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>userList = new ArrayList<>();
    Adapter adapter;
    static ModelClass modelClass;

    DatabaseAdapter databaseAdapter;
    RecyclerView rvPrograms;
    int temp=-1;
    FloatingActionButton floatingActionButton;
    ImageView bouttonmodifier;
    ImageView bouttonsupprimer,xi,xt;
    String x1,x2,x3,x4,x5;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tittle2);
        databaseAdapter = new DatabaseAdapter(this);
        userList = databaseAdapter.getAllContacts();
        mrecyclerView=findViewById(R.id.RecyclerView);
        mrecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(this,userList, (Adapter.ItemClickListener) mrecyclerView);
        //initData();
        //initRecyclerView();
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                                                    public void onClick(View v) {
                                                        startActivity(new Intent(MainActivity.this,ajouterActivity.class));
                                                    }
                                                }
        );
        Bundle extras = getIntent().getExtras();
        /*xi.setImageResource(Integer.parseInt(extras.getString("c56")));
        x1 = extras.getString("c51");
        x2 = extras.getString("c52");
        x3 = extras.getString("c53");
        x4 = extras.getString("c54");
        x5 = extras.getString("c55");
        userList.add(new ModelClass(R.drawable.gi,x1,x2,x3,x4,x5));
    */
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(temp != -1){
            if(modelClass!=null){
                userList.add(modelClass);
                adapter.notifyItemInserted(userList.size()-1);

                modelClass= null;
            }
            temp = -1 ;
        }
    }

    public void deleteitem(int position){
        userList.remove(position);
        adapter.notifyItemRemoved(position);
    }
    @SuppressLint("WrongViewCast")
    private void initRecyclerView() {
        mrecyclerView=findViewById(R.id.RecyclerView);
        bouttonmodifier = findViewById(R.id.button3);
        bouttonsupprimer = findViewById(R.id.button4);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);

        adapter=new Adapter(context,userList, new Adapter.ItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(MainActivity.this,plusdinformation.class);
                i.putExtra("c1",userList.get(position).getTextview1().toString());
                i.putExtra("c2",userList.get(position).getTextview2().toString());
                i.putExtra("c3",userList.get(position).getNumber().toString()  );
                i.putExtra("c4",String.valueOf(userList.get(position).getImage()));
                temp = position ;

                startActivity(i);

            }

            @Override
            public void onDeleteClick(int position) {
                deleteitem(position);
            }

            @Override
            public void onModifyClick(int position) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("c1",userList.get(position).getTextview1().toString());
                i.putExtra("c2",userList.get(position).getTextview2().toString());
                i.putExtra("c3",userList.get(position).getNumber().toString()  );

                startActivity(i);

            }


        });
        /*Adapter.ItemClickListener(new Adapter.ItemClickListener(){
            @Override
            public void onItemCLick(int position){
                change
            }
        })*/

        mrecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {
        userList = new ArrayList<>();

        userList.add(new ModelClass(null,"Anjali","5614984153248","0666666666","Femme","alissa"));
    }


}