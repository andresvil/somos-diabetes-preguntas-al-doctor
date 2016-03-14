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

    public void add(Pregunta object) {
        myList.add(object);
        super.add(object);
    }

    static class ImgHolder
    {
        ImageView ICON;
        TextView MENUITEM;
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
            row = inflater.inflate(R.layout.row_layout, parent, false);
            holder = new ImgHolder();
            holder.ICON = (ImageView) row.findViewById(R.id.icon);
            holder.MENUITEM = (TextView) row.findViewById(R.id.menu_item);

            row.setTag(holder);
        }

        else
        {
            holder = (ImgHolder) row.getTag();
        }

        MenuItems mi = (MenuItems) getItem(position);

        // Set text and image
        holder.ICON.setImageResource(mi.getIcon_rsc());
        holder.MENUITEM.setText(mi.getMenuItem());

        // Load font and set TextViews to that font
        AssetManager am = getContext().getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        holder.MENUITEM.setTypeface(myFont);

        return row;
    }
}
