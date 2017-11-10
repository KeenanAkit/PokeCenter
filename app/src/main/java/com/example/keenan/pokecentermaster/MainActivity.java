package com.example.keenan.pokecentermaster;

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
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,AdapterView.OnItemSelectedListener {

    TextView textView1;
    EditText PokeEdit;
    TextView textView2;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        PokeEdit = (EditText)findViewById(R.id.userCP);
        textView1 = (TextView)findViewById(R.id.Results);
        textView2 = (TextView)findViewById(R.id.userReslt);
        pos=0;

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.evo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
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
            Intent intent = new Intent(this, EvoActivity.class);
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
    @Override
    public void onItemSelected (AdapterView<?> parent, View view, int mypos, long id) {
        pos = mypos;
        System.out.println("Setting pos to "+pos);
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void doneButtonPressed (View view) {
        int CP = 0;
        double multi = 0;
        Integer endCP = 0;

        if (pos == 0) {
            textView2.setText("Please select a Pokemon");
        }
        else if(pos == 1) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.25;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 2) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.91;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 3) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.34;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 4) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.01;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 5) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.74;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 6) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.83;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 7) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.49;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 8) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 3.38;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 9) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.17;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 10) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 3.28;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 11) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.92;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 12) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.94;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 13) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.63;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 14) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.64;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 15) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.22;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 16) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.46;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 17) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.35;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 18) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.71;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 19) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.84;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 20) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.68;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 21) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.83;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 22) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.93;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 23) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.5;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 24) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.41;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 25) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 3.15;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 26) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.53;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 27) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.05;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 28) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.94;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 29) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.9;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 30) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 3.18;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 31) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.2;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 32) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.31;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 33) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.14;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 34) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.35;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 35) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.72;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 36) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.79;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 37) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.59;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }else if(pos == 38) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.09;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 39) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.69;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }else if(pos == 40) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.56;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 41) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.89;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 42) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.49;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 43) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 3.47;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 44) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.84;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 45) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.68;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 46) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.5;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 47) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.23;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }else if(pos == 48) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.23;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 49) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.2;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }else if(pos == 50) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.68;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 51) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.44;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }else if(pos == 52) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.58;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }else if(pos == 53) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.95;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 54) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.9;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 55) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.09;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 56) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.36;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 57) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.01;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 58) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.61;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 59) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 1.79;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 60) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 4;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 61) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.06;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 62) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.19;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 63) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.21;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 64) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.37;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 65) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 10.55;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 66) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.59;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 67) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.13;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 68) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.76;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 69) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 4.44;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 70) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.11;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 71) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.56;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
        else if(pos == 72) {
            CP = Integer.parseInt(PokeEdit.getText().toString());
            multi = 2.01;
            endCP = (int) Math.round(multi * CP);
            textView2.setText("Your Pokemon's CP will be " + endCP.toString());
        }
    }
}
