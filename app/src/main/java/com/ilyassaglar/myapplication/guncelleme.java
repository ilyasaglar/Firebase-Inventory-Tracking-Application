package com.ilyassaglar.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by ilyas on 26.11.2017.
 */

public class guncelleme extends Activity {
    EditText idText,adi,adet,afiyati,aciklama,marka;
    private Button guncelleBtn,araBtn;




    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myref=database.getReference();

    private void writeNewUser(String urunİd,String urunMarka,String urunAdi,String urunAdet,String aFiyati,String aciklama){


        User kullanıclar=new User(urunMarka,urunAdi,urunAdet,aFiyati,aciklama);

        myref.child("Urunler").child(urunİd).setValue(kullanıclar);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.guncelleme);


        guncelleBtn=(Button)findViewById(R.id.guncelleButon);
        araBtn=(Button)findViewById(R.id.araBtn);


        idText= (EditText)findViewById(R.id.urunid);
        marka= (EditText)findViewById(R.id.urunMarka);
        adi= (EditText)findViewById(R.id.urunAdi);
        adet= (EditText)findViewById(R.id.adet);
        afiyati= (EditText)findViewById(R.id.alısFiyati);
        aciklama= (EditText)findViewById(R.id.aciklama);

        guncelleBtn.setEnabled(false);


araBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ara(idText.getText().toString());
    }
});


        guncelleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(marka.getText().equals("") || marka.getText()==null || idText.getText().equals("") || idText.getText()==null){

                }else{
                    writeNewUser(idText.getText().toString(),marka.getText().toString(),adi.getText().toString(),adet.getText().toString(),afiyati.getText().toString(),aciklama.getText().toString());
                    Toast.makeText(getApplicationContext(), "İD NUMARASINA AİT BİLGİLER GÜNCELLENDİ.", Toast.LENGTH_LONG).show();
                    marka.setText(""); adi.setText("");  adet.setText(""); afiyati.setText(""); aciklama.setText("");

                }
                ara(idText.getText().toString());


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
                    //id.setText(k.urunAdi);
                    marka.setText(k.urunMarka);
                    adi.setText(k.urunAdi);
                    adet.setText(k.urunAdet);
                    afiyati.setText(k.aFiyati);
                    aciklama.setText(k.aciklama);
                    guncelleBtn.setEnabled(true);
                }else{

                }
                guncelleBtn.setEnabled(true);
                //    urunSayisi.setText(urunler.add(String.valueOf(key.getChildrenCount())));          ???

                //urunler.add(String.valueOf(key.getChildrenCount()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }











}
