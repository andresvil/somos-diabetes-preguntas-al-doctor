package com.example.andresvil.preguntasaldoctor;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by andresvil on 3/14/16.
 */
public class PreguntasAdapter extends ArrayAdapter {
    private List myList = new ArrayList();

    public PreguntasAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(FAQ object) {
        myList.add(object);
        super.add(object);
    }

    static class ImgHolder
    {
        TextView PREGUNTA;
        TextView RESPUESTA;
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
            row = inflater.inflate(R.layout.faq_layout, parent, false);
            holder = new ImgHolder();
            holder.PREGUNTA = (TextView) row.findViewById(R.id.pregunta);
            holder.RESPUESTA = (TextView) row.findViewById(R.id.respuesta);

            row.setTag(holder);
        }

        else
        {
            holder = (ImgHolder) row.getTag();
        }

        FAQ f = (FAQ) getItem(position);

        // Set textviews for Pregunta & Respuesta
        holder.PREGUNTA.setText(f.getPregunta());
        holder.RESPUESTA.setText(f.getRespuesta());

        // Load font and set TextViews to that font
        AssetManager am = getContext().getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        holder.PREGUNTA.setTypeface(myFont);
        holder.RESPUESTA.setTypeface(myFont);

        return row;
    }
}
