package com.example.falunyitvatarto;

import android.os.Bundle;
import android.content.Intent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private EditText etName, etAddress, etAge;
    private Button btnAdd;
    private ListView lvResidents;
    private ResidentAdapter adapter;
    private ArrayList<Resident> residents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);
        etAge = findViewById(R.id.et_age);
        btnAdd = findViewById(R.id.btn_add);
        lvResidents = findViewById(R.id.lv_residents);

        residents = new ArrayList<>();
        adapter = new ResidentAdapter(this, residents);
        lvResidents.setAdapter(adapter);

        btnAdd.setOnClickListener(view -> addResident());

        lvResidents.setOnItemClickListener((adapterView, view, position, id) -> {
            Resident resident = residents.get(position);
            Intent intent = new Intent(MainActivity.this, activity_details2.class);
            intent.putExtra("name", resident.getName());
            intent.putExtra("address", resident.getAddress());
            intent.putExtra("age", resident.getAge());
            startActivity(intent);
        });
    }

    private void addResident() {
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String ageStr = etAge.getText().toString();

        if (name.isEmpty() || address.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);
        if (age < 0 || age > 100) {
            Toast.makeText(this, "A kor 0 és 100 között lehet!", Toast.LENGTH_SHORT).show();
            return;
        }

        residents.add(new Resident(name, address, age));
        adapter.notifyAll();

        etName.setText("");
        etAddress.setText("");
        etAge.setText("");
    }

    private class ResidentAdapter {
        public ResidentAdapter(MainActivity mainActivity, ArrayList<Resident> residents) {
        }
    }
}