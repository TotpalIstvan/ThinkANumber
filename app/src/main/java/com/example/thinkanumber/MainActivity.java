package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnPlusz, btnMinusz, btnTipp;
    private ImageView hp1, hp2, hp3, hp4;
    private ImageView[] eletek;
    private TextView felhasznaloTippText;
    private int felhasznaloTipp, gondoltSzam, maximum, elet;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//teszt
        init();
        ujJatek();
        btnPlusz.setOnClickListener((view) -> {
            if (felhasznaloTipp < maximum) {
                felhasznaloTipp++;
                felhasznaloTippText.setText(String.valueOf(felhasznaloTipp));
            } else {
                // Hibaüzenet tipp nem lehet maxnál nagyobb
                Toast.makeText(getApplicationContext(), "Nem lehet nagyobb 10-nél", Toast.LENGTH_SHORT).show();
            }
        });
        btnMinusz.setOnClickListener(view -> {
            if (felhasznaloTipp > 1) {
                felhasznaloTipp--;
                felhasznaloTippText.setText(String.valueOf(felhasznaloTipp));
            } else {
                //  Hibaüzenet tipp nem lehet kisebb mint 1
               /* Toast toast = new Toast(getApplicationContext());
                toast.setText("Nem lehet kisebb 1-nél");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();*/
                Toast.makeText(getApplicationContext(), "Nem lehet kisebb 1-nél", Toast.LENGTH_SHORT).show();
            }
        });
        btnTipp.setOnClickListener(view -> {
            if (felhasznaloTipp == gondoltSzam){
                // TODO: Győzelem ALERT DIALOG
            } else if (felhasznaloTipp < gondoltSzam) {
                // TODO: Nagyobb számra gondoltam EGYEDI TOAST
                eletLevon();
            } else {
                // TODO: Kisebb számra gondoltam EGYEDI TOAST
                eletLevon();
            }
        });
    }

    private void eletLevon() {
        if (elet > 0){
            elet--;
        }
        eletek[elet].setImageResource(R.drawable.heart1);
        if (elet == 0){
            // TODO: jatek vege
        }
    }

    private void ujJatek() {
        felhasznaloTipp = 1;
        felhasznaloTippText.setText("1");
        gondoltSzam = random.nextInt(maximum)+1;
        Log.d("gondolt szam", String.valueOf(gondoltSzam));
        elet = 4;
        for (ImageView elet: eletek) {
            elet.setImageResource(R.drawable.heart2);
        }
    }

    private void init(){
        btnPlusz = findViewById(R.id.btn_plusz);
        btnMinusz = findViewById(R.id.btn_minusz);
        btnTipp = findViewById(R.id.btn_tipp);
        hp1 = findViewById(R.id.hp1);
        hp2 = findViewById(R.id.hp2);
        hp3 = findViewById(R.id.hp3);
        hp4 = findViewById(R.id.hp4);
        felhasznaloTippText = findViewById(R.id.felhasznalo_valasztas);
        maximum = 10;
        random = new Random();
        eletek = new ImageView[]{hp1,hp2,hp3,hp4};
    }
}