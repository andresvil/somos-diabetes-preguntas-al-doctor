package com.example.andresvil.preguntasaldoctor;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by andresvil on 3/14/16.
 */
public class MisPreguntasAdapter extends ArrayAdapter {
    private List myList = new ArrayList();

    public MisPreguntasAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Pregunta object) {
        myList.add(object);
        super.add(object);
    }

    static class ImgHolder
    {
        TextView PREGUNTA;
        TextView DOCTOR;
    }

    @Override
    public int getCount() {
        return this.myList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImgHolder holder;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.mis_preguntas_layout, parent, false);
            holder = new ImgHolder();
            holder.PREGUNTA = (TextView) row.findViewById(R.id.mi_pregunta);
            holder.DOCTOR = (TextView) row.findViewById(R.id.doctor);

            row.setTag(holder);
        }

        else
        {
            holder = (ImgHolder) row.getTag();
        }

        Pregunta p = (Pregunta) getItem(position);

        // Set textviews for Pregunta & Respuesta
        holder.PREGUNTA.setText(p.getPregunta());
        holder.DOCTOR.setText(p.getDoctor());

        // Load font and set TextViews to that font
        AssetManager am = getContext().getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        holder.PREGUNTA.setTypeface(myFont);
        holder.DOCTOR.setTypeface(myFont);

        return row;
    }
}
