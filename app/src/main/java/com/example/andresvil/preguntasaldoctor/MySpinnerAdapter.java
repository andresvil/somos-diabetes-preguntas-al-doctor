package com.example.andresvil.preguntasaldoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by andresvil on 3/16/16.
 */
public class MySpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    String[] doctores;

    public MySpinnerAdapter(Context ctx, String[] doctores)
    {
        super(ctx, R.layout.my_spinner_layout, doctores);

        this.context = ctx;
        this.doctores = doctores;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.my_spinner_layout, null);
        }

        // Get textview
        TextView doctorTextView = (TextView) convertView.findViewById(R.id.doctor_item);

        doctorTextView.setText(doctores[position]);

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.my_spinner_layout, null);
        }

        // Get textview
        TextView doctorTextView = (TextView) convertView.findViewById(R.id.doctor_item);

        doctorTextView.setText(doctores[position]);

        return convertView;
    }
}
