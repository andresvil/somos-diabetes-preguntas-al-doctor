package com.example.andresvil.preguntasaldoctor;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PreguntaNueva extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_nueva);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Access toolbar text
        TextView toolbarText = (TextView) toolbar.findViewById(R.id.toolbar_title);

        // Remove default title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Get TextView and Text Field
        TextView eligeDoctor = (TextView) findViewById(R.id.eligeDoctorText);
        EditText escribaTuPregunta = (EditText) findViewById(R.id.preguntaField);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        /*// Spinner DropDown Elements
        List<String> doctores = new ArrayList<String>();
        doctores.add("Nutriólogo");
        doctores.add("Endocrinólogo");
        doctores.add("Neurólogo");
        doctores.add("Cardiólogo");*/

        // Spinner DropDown Elements 2
        String[] doctores = {"Nutriólogo", "Endocrinólogo", "Neurólogo", "Cardiólogo"};

        // Create adapter for spinner
        MySpinnerAdapter mySpinnerAdapter = new MySpinnerAdapter(this, doctores);

        /*// Dropdown layout style
        mySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

        // Attach adapter to spinner
        spinner.setAdapter(mySpinnerAdapter);

        // Load font and set TextViews to that font
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Roman_0.otf"));
        eligeDoctor.setTypeface(myFont);
        escribaTuPregunta.setTypeface(myFont);
        toolbarText.setTypeface(myFont);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_pregunta_nueva, menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.guardar_pregunta) {
            Toast.makeText(getApplicationContext(), "Pregunta Guardada!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
