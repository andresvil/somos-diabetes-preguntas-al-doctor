package com.example.andresvil.preguntasaldoctor;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String[] preguntas = {"¿Qué es la diabetes?", "¿Existen factores de riesgo de diabetes?",
        "¿Existen factores de riesgo de diabetes?", "¿Cuántos tipos de diabetes hay?"};

    String[] respuestas = {"La diabetes es una enfermedad que ocurre cuando el organismo es " +
            "incapaz de generar insulina o utilizarla correctamente. El páncreas produce la " +
            "insulina para regular el uso de la glucosa (azúcar) en el organismo.", "Sí. " +
            "Antecedentes de familiares que padezcan, sobrepeso; enfermedad cardiovascular; " +
            "grasas alteradas en sangre (dislipidemia); quistes en los ovarios.", "Sí. " +
            "Antecedentes de familiares que padezcan, sobrepeso; enfermedad cardiovascular; " +
            "grasas alteradas en sangre (dislipidemia); quistes en los ovarios.", "Existen 3 " +
            "tipos de diabetes, las cuales se denominan: Tipo I, Tipo II, y Diabetes " +
            "Gestacional (esta última ocurre durante el embarazo)."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarText = (TextView) toolbar.findViewById(R.id.toolbar_title);

        // Remove default title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        listView = (ListView) findViewById(R.id.listView);
        PreguntasAdapter adapter = new PreguntasAdapter(getApplicationContext(), R.layout.faq_layout);
        listView.setAdapter(adapter);

        for(int i = 0; i < preguntas.length; i++)
        {
            Pregunta p = new Pregunta(preguntas[i], respuestas[i]);
            adapter.add(p);
        }

        TextView faq = (TextView) findViewById(R.id.buttonFAQ);
        TextView misPreguntas = (TextView) findViewById(R.id.buttonMisPreguntas);

        // Load font and set TextViews to that font
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        faq.setTypeface(myFont);
        misPreguntas.setTypeface(myFont);
        toolbarText.setTypeface(myFont);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
