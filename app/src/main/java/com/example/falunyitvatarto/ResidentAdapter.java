package com.example.falunyitvatarto;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class ResidentAdapter extends ArrayAdapter<Resident> {
    private Context context;
    private ArrayList<Resident> residents;

    public ResidentAdapter(Context context, ArrayList<Resident> residents) {
        super(context, 0, residents);
        this.context = context;
        this.residents = residents;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_resident, parent, false);
        }

        Resident resident = residents.get(position);

        TextView tvName = convertView.findViewById(R.id.tv_name);
        TextView tvAddress = convertView.findViewById(R.id.tv_address);
        TextView tvAge = convertView.findViewById(R.id.tv_age);
        Button btnDelete = convertView.findViewById(R.id.btn_delete);

        tvName.setText(resident.getName());
        tvAddress.setText(resident.getAddress());
        tvAge.setText(String.valueOf(resident.getAge()));

        btnDelete.setOnClickListener(view -> new AlertDialog.Builder(context)
                .setTitle("Törlés")
                .setMessage("Biztosan törölni szeretnéd?")
                .setPositiveButton("Igen", (dialog, which) -> {
                    residents.remove(position);
                    notifyDataSetChanged();
                })
                .setNegativeButton("Nem", null)
                .show());

        return convertView;
    }
}

