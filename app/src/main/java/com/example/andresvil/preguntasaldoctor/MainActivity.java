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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListView misPreguntasList;
    FloatingActionButton fab;
    Button faqButton;
    Button misPreguntasButton;

    String[] faqs = {"¿Qué es la diabetes?", "¿Existen factores de riesgo de diabetes?",
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

    String[] misPreguntas = {"¿La diabetes es una enfermedad que ocurre cuando el organismo es " +
            "incapaz de generar insulina o utilizarla correctamente?", "¿Cual es el riesgo que " +
            "corren mis hijos de adquirir diabetes?", "¿Existen factores de riesgo de diabetes?",
            "¿Cuántos tipos de diabetes hay y cómo se denominan?", "¿La diabetes es una enfermedad " +
            "que ocurre cuando el organismo es incapaz de generar insulina o utilizarla " +
            "correctamente?", "¿Cual es el riesgo que corren mis hijos de adquirir diabetes?",
            "¿Existen factores de riesgo de diabetes?", "¿Cuántos tipos de diabetes hay y cómo " +
            "se denominan?"};

    String[] doctores = {"Nutriólogo", "Nutriólogo", "Nutriólogo", "Nutriólogo", "Neurólogo",
            "Nefrólogo", "Todólogo", "Diabetólogo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbarText = (TextView) toolbar.findViewById(R.id.toolbar_title);

        // Remove default title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Get 2 buttons
        faqButton = (Button) findViewById(R.id.buttonFAQ);
        misPreguntasButton = (Button) findViewById(R.id.buttonMisPreguntas);

        // Populate FAQ ListView
        listView = (ListView) findViewById(R.id.listView);
        PreguntasAdapter adapter = new PreguntasAdapter(getApplicationContext(), R.layout.faq_layout);
        listView.setAdapter(adapter);
        for(int i = 0; i < faqs.length; i++)
        {
            FAQ f = new FAQ(faqs[i], respuestas[i]);
            adapter.add(f);
        }

        // Populate Mis Preguntas ListView
        misPreguntasList = (ListView) findViewById(R.id.mis_preguntas_listView);
        MisPreguntasAdapter misPreguntasAdapter = new MisPreguntasAdapter(getApplicationContext(), R.layout.mis_preguntas_layout);
        misPreguntasList.setAdapter(misPreguntasAdapter);
        for(int i = 0; i < misPreguntas.length; i++)
        {
            Pregunta p = new Pregunta(misPreguntas[i], doctores[i]);
            misPreguntasAdapter.add(p);
        }

        TextView faq = (TextView) findViewById(R.id.buttonFAQ);
        TextView misPreguntas = (TextView) findViewById(R.id.buttonMisPreguntas);

        // Load font and set TextViews to that font
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        faq.setTypeface(myFont);
        misPreguntas.setTypeface(myFont);
        toolbarText.setTypeface(myFont);

        // Floating Action Button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    // Show Mis Preguntas ListView, Add button and hide FAQ
    public void showMisPreguntas(View view)
    {
        // Switch listViews
        listView.setVisibility(View.INVISIBLE);
        fab.setVisibility(View.VISIBLE);
        misPreguntasList.setVisibility(View.VISIBLE);

        // Change buttons
        faqButton.setEnabled(true);
        faqButton.setAlpha((float) 0.5);
        misPreguntasButton.setEnabled(false);
        misPreguntasButton.setAlpha(1);

    }

    // Show FAQ ListView, Add button and hide FAQ
    public void showFAQ(View view)
    {
        // Switch listViews
        fab.setVisibility(View.INVISIBLE);
        misPreguntasList.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);

        // Change buttons
        faqButton.setEnabled(false);
        faqButton.setAlpha(1);
        misPreguntasButton.setEnabled(true);
        misPreguntasButton.setAlpha((float) 0.5);
    }
}
