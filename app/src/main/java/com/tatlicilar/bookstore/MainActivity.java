package com.tatlicilar.bookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name,password;
    String loginName, loginPass;
    Intent intent;
    ArrayList<Kisi> uyeler;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        image = (ImageView) findViewById(R.id.image);
        kisileriOlustur();
    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.button:
                loginName = name.getText().toString();
                loginPass = password.getText().toString();
                int yetkili=0;
                for(int i=0;i<uyeler.size();i++) {
                    if (uyeler.get(i).getIsim().equals(loginName) && uyeler.get(i).getParola().equals(loginPass)) {
                        yetkili = 1;
                        intent = new Intent(this, HomePage.class);
                        intent.putExtra("kisi",uyeler.get(i));
                        startActivity(intent);
                    }
                }
                if(yetkili==0)
                    Toast.makeText(this, "Hatalı giriş", Toast.LENGTH_SHORT).show();
                break;
    }}
        public void kisileriOlustur(){

            Kisi k1 = new Kisi("Ted","1234","rumeysa@gmail.com","Erkek","07.01.1998","ted","http://www.google.com");
            Kisi k2 = new Kisi("Barney","5678","cici@gmail.com","Erkek","08.01.1998","barney","http://www.facebook.com");
            Kisi k3 = new Kisi("Shakira","9101","bici@gmail.com","Kadın","09.01.1998","shakira","http://www.twitter.com");
            Kisi k4 = new Kisi("Sherlock","1112","neval@gmail.com","Erkek","10.01.1998","sherlock","https://github.com/Surinovi");

            uyeler=new ArrayList<Kisi>();

            uyeler.add(k1);
            uyeler.add(k2);
            uyeler.add(k3);
            uyeler.add(k4);

        }
}