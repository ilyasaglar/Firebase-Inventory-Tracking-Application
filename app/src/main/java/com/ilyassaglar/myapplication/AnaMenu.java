package com.ilyassaglar.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by ilyas on 12.11.2017.
 */

public class AnaMenu extends Activity {
    Button oyna;
    Button ayarlar,urunListeBtn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ana_menu);

        oyna = (Button) findViewById(R.id.stokkaydiButton);
        ayarlar = (Button) findViewById(R.id.guncelStokButton);
        urunListeBtn1= (Button) findViewById(R.id.urunListeBtn1);


        urunListeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), urunListesi.class);
                startActivity(intent);
            }
        });





    }

    public void Tiklendi(View v) {
        if (v.getId() == R.id.stokkaydiButton) {
            Intent intent = new Intent(getApplicationContext(), stokKaydetme.class);
            startActivity(intent);

        }


        if (v.getId() == R.id.urunListeBtn1) {
            Intent intent = new Intent(getApplicationContext(), urunListesi.class);
            startActivity(intent);
        }



        if (v.getId() == R.id.guncelStokButton) {
            Intent intent = new Intent(getApplicationContext(), ara_sil.class);
            startActivity(intent);


        }
       /* if (v.getId() == R.id.urunGirisBtn) {

         Intent intent2 = new Intent(getApplicationContext(),urunGiris.class);
           startActivity(intent);


        }     */
        if (v.getId() == R.id.urunCikisButton) {
            Intent intent = new Intent(getApplicationContext(), guncelleme.class);
            startActivity(intent);


        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Çıkış")
                .setMessage("Uygulamadan çıkmak istediğinizden emin misiniz?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }).setNegativeButton("Hayır", null).show();
    }

}
