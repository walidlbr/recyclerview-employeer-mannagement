package com.example.recyclerview;

import android.graphics.Bitmap;
import android.widget.EditText;

public class ModelClass {
    public ModelClass(int image, String anjali, String s, String s1, String femme, String alissa){

    };
  private Bitmap image;
  private String nom;
  private String identité;
    private String number;

    public ModelClass(int i, String trim, String s, String trim1, String s1) {

    }

    public ModelClass() {

    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    private String date;
    private String prenom;



   ModelClass (Bitmap image , String nom, String identité, String number, String date, String prenom)
   {
       this.image=image;
       this.nom=nom;
       this.prenom=prenom;
       this.identité=identité;
       this.number=number;
       this.date= date;
   }


        public String getTextview1() {
        return String.valueOf(this.nom);
    }

    public String getNumber() {
        return String.valueOf(number);
    }

    public void setDivider(String number) {
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return String.valueOf(this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrenom() {
        return String.valueOf(this.prenom);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTextview2() {
        return String.valueOf(identité);
    }

    public String getNom() {
        return String.valueOf(nom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentité() {
        return String.valueOf(identité);
    }

    public void setIdentité(String identité) {
        this.identité = identité;
    }
}
