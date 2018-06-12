package com.ilyassaglar.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


// Created by ilyas on 12.11.2017.


public class ara_sil extends AppCompatActivity {


    DatabaseReference dref;
    ListView listview;

ArrayList<String> urunler=new ArrayList();
    EditText id, adi, adet, afiyati, aciklama, marka,araText;
    private TextView listele,urunidText,markasi,adiText,adetText,aciklamaText,urunSayisi;

    private Button araBtn,listeleBtn;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ara_sil);
        //listele= (TextView) findViewById(R.id.listele);
        araBtn= (Button) findViewById(R.id.araBtn);
        listeleBtn= (Button) findViewById(R.id.silBtn);
        urunidText= (TextView) findViewById(R.id.urunidText);
       markasi= (TextView) findViewById(R.id.urunidText);
        adiText= (TextView) findViewById(R.id.textView8);
        adetText= (TextView) findViewById(R.id.textView9);
        aciklamaText= (TextView) findViewById(R.id.textView10);

        araText= (EditText) findViewById(R.id.araText);

//listView= (ListView) findViewById(R.id.listView);
        araBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ara(araText.getText().toString());
            }
        });

        listeleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sil(araText.getText().toString());

            }
        });

    }

    private void ara(String id){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myref = database.getReference().child("Urunler");
            final DatabaseReference oku = FirebaseDatabase.getInstance().getReference().child("Urunler").child(id);

            oku.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User k = new User();
                    k = dataSnapshot.getValue(User.class);
                    if(k!=null) {
                        urunidText.setText(k.urunAdi);
                        markasi.setText(k.urunMarka);
                        adiText.setText(k.urunAdi);
                        adetText.setText(k.urunAdet);
                        aciklamaText.setText(k.aciklama);
                    }else{
                        Toast.makeText(getApplicationContext(), "İD NUMARASIN AİT BİLGİ BULUNAMADI.", Toast.LENGTH_LONG).show();

                    }

                    //    urunSayisi.setText(urunler.add(String.valueOf(key.getChildrenCount())));          ???

                    //urunler.add(String.valueOf(key.getChildrenCount()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

    }


    private void sil(String id2){
        ara("");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference().child("Urunler");

        final DatabaseReference oku=FirebaseDatabase.getInstance().getReference().child("Urunler").child(id2);

             /*   User k=new User();
                k=dataSnapshot.getValue(User.class);
                listele.append(k.urunAdi+" "+k.urunMarka+"\n");      */
               //urunler.add(String.valueOf(key.getChildrenCount()));
        if(id2.equals("")){

            Toast.makeText(getApplicationContext(), "İD NUMARASINA AİT BİLGİ BULUNAMADI.", Toast.LENGTH_LONG).show();


        }
            else{
            Toast.makeText(getApplicationContext(), "İD NUMARASI İLE İLİŞKİLİ VERİLER SİLİNDİ.", Toast.LENGTH_LONG).show();
            oku.removeValue();
        }




    }


}


