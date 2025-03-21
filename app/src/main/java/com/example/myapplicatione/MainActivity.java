package com.example.myapplicatione;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] kosci = {
            R.drawable.k1, R.drawable.k2, R.drawable.k3,
            R.drawable.k4, R.drawable.k5, R.drawable.k6
    };

    private int suma_gry;
    private ImageView[] kosciViews;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        kosciViews = new ImageView[]{
                findViewById(R.id.imageView),
                findViewById(R.id.imageView2),
                findViewById(R.id.imageView3),
                findViewById(R.id.imageView4),
                findViewById(R.id.imageView5)
        };
        random = new Random();

        Button roll_button = findViewById(R.id.buttonRzuc);
        roll_button.setOnClickListener(v -> rzucKoscmi());
        Button reset_button = findViewById(R.id.buttonResetuj);
        reset_button.setOnClickListener(v -> resetujKosci());
    }
    private void rzucKoscmi() {
        int suma_rzutu = 0;
        for (ImageView kosc : kosciViews) {
            int liczba = random.nextInt(6);
            suma_rzutu += liczba;
            suma_gry += liczba;
            TextView wynik_los_textview = findViewById(R.id.WynikLosowania);
            TextView wynik_gry_textview = findViewById(R.id.WynikGry);
            wynik_los_textview.setText(getString(R.string.wynik_tego_losowania) + " " + suma_rzutu);
            wynik_gry_textview.setText(getString(R.string.wynik_gry) + " " + suma_gry);
            kosc.setImageResource(kosci[liczba]);
        }
    }

    private void resetujKosci() {
        int suma_rzutu = 0;
        suma_gry = 0;
        for (ImageView kosc : kosciViews) {
            TextView wynik_los_textview = findViewById(R.id.WynikLosowania);
            TextView wynik_gry_textview = findViewById(R.id.WynikGry);
            wynik_los_textview.setText(getString(R.string.wynik_tego_losowania) + " " + suma_rzutu);
            wynik_gry_textview.setText(getString(R.string.wynik_gry) + " " + suma_gry);
            kosc.setImageResource(R.drawable.kunknown);
        }
    }
}