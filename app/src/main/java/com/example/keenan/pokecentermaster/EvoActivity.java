package com.example.keenan.pokecentermaster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class EvoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener{

    ImageView imageView1;
    Spinner spinner;
    Integer pokeNum;
    Integer candyNum;
    EditText numpok;
    EditText numcand;
    int evoCategory;
    TextView TextView1;
    Integer spinnerCatch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Jordan's Code
        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        numpok = (EditText) findViewById(R.id.num_poke);
        numcand = (EditText) findViewById(R.id.num_candies);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cpCalc) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            System.out.println("CP");
        } else if (id == R.id.nav_ivCalc) {
            Intent intent = new Intent(this, IvActivity.class);
            startActivity(intent);
            System.out.println("IV");
        } else if (id == R.id.nav_xpCalc) {
            Intent intent = new Intent(this,EvoActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_home){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        if (pos == 0) {
            imageView1.setImageResource(R.drawable.pokemon_go_logo);
            spinnerCatch = 1;

        } else if (pos == 1) {
            imageView1.setImageResource(R.drawable.pidgey);
            evoCategory = 12;
            spinnerCatch = 0;
        } else if (pos == 2) {
            imageView1.setImageResource(R.drawable.rattata);
            evoCategory = 25;
            spinnerCatch = 0;
        } else if (pos == 3) {
            imageView1.setImageResource(R.drawable.paris);
            evoCategory = 50;
            spinnerCatch = 0;
        } else if (pos == 4) {
            imageView1.setImageResource(R.drawable.machoke);
            evoCategory = 100;
            spinnerCatch = 0;
        } else if (pos == 5) {
            imageView1.setImageResource(R.drawable.magikarp);
            evoCategory = 400;
            spinnerCatch = 0;
        }
    }
    public void onNothingSelected (AdapterView<?> parent){
        AlertDialog alertDialog = new AlertDialog.Builder(EvoActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Please select a category");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        return;
    }
    public void doneButtonPressed(View view) {
        if(spinnerCatch == 0){
            AlertDialog alertDialog = new AlertDialog.Builder(EvoActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please select a category");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }
        if(numpok.equals("") || numcand.equals("")){
            AlertDialog alertDialog = new AlertDialog.Builder(EvoActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please select a category");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }else {
            Integer numTransfer = 0;
            Integer numEvo = 0;
            pokeNum = Integer.parseInt(numpok.getText().toString());
            candyNum = Integer.parseInt(numcand.getText().toString());
            int evoNow = 0;
            if (pokeNum + candyNum < evoCategory + 1) {
                TextView1 = (TextView) findViewById(R.id.answerTextView);
                String s = "You don't have enough candy and pokemon to evolve a single pokemon my dude";
                TextView1.setText(s);
            } else {
                while (candyNum > evoCategory && pokeNum > 0) {
                    if (evoCategory * pokeNum < candyNum) {
                        evoNow = pokeNum;
                    } else {
                        evoNow = candyNum / evoCategory;
                    }
                    numEvo += evoNow;
                    candyNum = (candyNum % evoCategory) + (evoNow * 2);
                    numTransfer += evoNow;
                    pokeNum -= evoNow;
                    evoNow = 0;
                }
                while (pokeNum > 0) {
                    while (candyNum < evoCategory && pokeNum > 0) {
                        candyNum++;
                        pokeNum--;
                        numTransfer++;
                    }
                    if (pokeNum > 0) {
                        numEvo++;
                        numTransfer++;
                        candyNum = 2;
                        pokeNum--;
                    }
                }
                TextView1 = (TextView) findViewById(R.id.answerTextView);
                String s = "You should evolve " + numEvo.toString() + " Pokemon, and you will transfer " + numTransfer.toString() + " Pokemon throughout this process.";
                TextView1.setText(s);
            }
        }
    }
}


