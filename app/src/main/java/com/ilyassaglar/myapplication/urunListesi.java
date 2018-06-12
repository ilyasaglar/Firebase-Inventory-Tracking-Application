package com.ilyassaglar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebHistoryItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class urunListesi extends AppCompatActivity {

   ArrayList<String> urunler=new ArrayList();
  private ListView urunListesiL;
  int adet=0;
   public int  kayitSayisi=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_listesi);
        //listele= (TextView) findViewById(R.id.listele);
        urunListesiL= (ListView) findViewById(R.id.listViewUrun);




        for (int i=100;i<107;i++){
                listele(String.valueOf(i));
        }





    }





    private void listele(String id){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference().child("Urunler");

        DatabaseReference oku=FirebaseDatabase.getInstance().getReference().child("Urunler").child(id);
        final ArrayAdapter adapter=new ArrayAdapter<String>(urunListesi.this,android.R.layout.simple_list_item_1,urunler);

        oku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User k=new User();
                k=dataSnapshot.getValue(User.class);
               // listele.append(k.urunAdi+" "+k.urunMarka+"\n");
                adet++;
                urunler.add(adet+". "+k.urunMarka+" "+k.urunAdi+" ürününden "+k.urunAdet+" adet stokta var");
                //urunler.add(String.valueOf(key.getChildrenCount()));   ????

                urunListesiL.setAdapter(adapter);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
















}
