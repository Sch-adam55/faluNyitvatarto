package com.example.falunyitvatarto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class activity_details2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        TextView tvName = findViewById(R.id.tv_details_name);
        TextView tvAddress = findViewById(R.id.tv_details_address);
        TextView tvAge = findViewById(R.id.tv_details_age);
        TextView tvGender = findViewById(R.id.tv_details_gender);
        Button btnBack = findViewById(R.id.btn_back);

        String[] genders = {"Férfi", "Nő", "Semleges"};
        Random random = new Random();
        String randomGender = genders[random.nextInt(genders.length)];

        tvName.setText(getIntent().getStringExtra("name"));
        tvAddress.setText(getIntent().getStringExtra("address"));
        tvAge.setText(String.valueOf(getIntent().getIntExtra("age", 0)));
        tvGender.setText(randomGender);

        btnBack.setOnClickListener(view -> finish());
    }
}