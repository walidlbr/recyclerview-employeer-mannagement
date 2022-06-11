package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context,"ListeEmloyé",null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE employé(_id INTEGER ,id INTEGER PRIMARY KEY,nom TEXT ,prenom TEXT,datedenaissance TEXT,numerodetel INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS employé");
        onCreate(db);

    }
    public void ajouterEmployé(ModelClass e){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",e.getIdentité());
        cv.put("nom",e.getNom());
        cv.put("prenom",e.getPrenom());
        cv.put("datedenaissance",e.getDate());
        cv.put("numerodetel",e.getNumber());
        db.insert("employé",null,cv);
        db.close();
    }
    public void modifierEmployé(ModelClass e){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("nom",e.getNom());
        cv.put("prenom",e.getPrenom());
        cv.put("datedenaissance",e.getDate());
        cv.put("numerodetel",e.getNumber());
        cv.put("id",e.getIdentité());
        db.update("employé",cv,"id=?",new String []{String.valueOf((e.getIdentité()))});
        db.close();
    }
    public void supprimer (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("employé","id=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public Cursor getAllEmployés(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM employé",null);
        return c;
    }
    public ModelClass getOneEmployé(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM employé WHERE id=?",new String[]{String.valueOf(id)});
        c.moveToFirst();
        ModelClass e =new ModelClass(
                c.getInt(1),
                c.getString(2),
                c.getString(3),
                c.getString(4),
                c.getString(5),
                c.getString(6));

        return e;
    }
}