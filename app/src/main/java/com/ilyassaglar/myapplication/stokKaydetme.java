package com.ilyassaglar.myapplication;



        import android.app.Activity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;


public class stokKaydetme extends AppCompatActivity {
    EditText id,adi,adet,afiyati,aciklama,marka;
    Button bt;




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
        setContentView(R.layout.stokkaydetme);


        bt=(Button)findViewById(R.id.kaydetBtn);


        id= (EditText)findViewById(R.id.urunid);
        marka= (EditText)findViewById(R.id.urunMarka);
        adi= (EditText)findViewById(R.id.urunAdi);
        adet= (EditText)findViewById(R.id.adet);
        afiyati= (EditText)findViewById(R.id.alısFiyati);
        aciklama= (EditText)findViewById(R.id.aciklama);



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(marka.getText().equals("") || marka.getText()==null || adi.getText().equals("") || adi.getText()==null)
                {

                    Toast.makeText(getApplicationContext(), "TÜM ALANLARI DOLDURUNUZ.", Toast.LENGTH_LONG).show();


                }
                else
                {
                    writeNewUser(id.getText().toString(),marka.getText().toString(),adi.getText().toString(),adet.getText().toString(),afiyati.getText().toString(),aciklama.getText().toString());
                    Toast.makeText(getApplicationContext(), "BİLGİLERİNİZ KAYDEDİLDİ.", Toast.LENGTH_LONG).show();
                    id.setText(""); marka.setText(""); adi.setText("");  adet.setText(""); afiyati.setText(""); aciklama.setText("");


                }

            }
        });




    }



}
