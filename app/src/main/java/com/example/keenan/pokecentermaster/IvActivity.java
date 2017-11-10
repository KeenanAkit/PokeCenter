package com.example.keenan.pokecentermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by keenan on 16-08-08.
 */
public class IvActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Integer starDustSpinPos;
    Integer pokeSpinPos;
    Double cpValue;
    Double hpValue;
    Integer dustValue;
    EditText cpValueEdit;
    EditText hpValueEdit;
    TextView testText;
    Spinner dustValueEdit;
    Spinner spinnerPokemon;
    Spinner spinnerStardust;
    Integer pokemonLvl;
    Double cpMulti;
    Double loopStaIv;
    Double staIv;
    Double finalStaIv;
    Double baseSta;
    Double baseAtk;
    Double baseDef;
    List<Double> staIvList;
    Double[] baseStatArray = new Double[453];

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv);

        cpValueEdit = (EditText)findViewById(R.id.cpValueText);
        hpValueEdit = (EditText)findViewById(R.id.hpValueText);
        dustValueEdit = (Spinner)findViewById(R.id.dustValueSpinner);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        spinnerPokemon = (Spinner)findViewById(R.id.pokemon_dropdown);
        ArrayAdapter<CharSequence> adapterPokemon = ArrayAdapter.createFromResource(this,R.array.pokemon_array, android.R.layout.simple_spinner_dropdown_item);
        spinnerPokemon.setAdapter(adapterPokemon);

        spinnerStardust = (Spinner)findViewById(R.id.dustValueSpinner);
        ArrayAdapter<CharSequence> adapterStardust = ArrayAdapter.createFromResource(this,R.array.stardust_cost, android.R.layout.simple_spinner_dropdown_item);
        spinnerStardust.setAdapter(adapterStardust);

        staIvList = new ArrayList<>();

        testText = (TextView)findViewById(R.id.testText);

        /* baseStatArray[0] = 90.0;
        baseStatArray[1] = 126.0;
        baseStatArray[2] = 126.0;
        baseStatArray[3] = ;
        baseStatArray[4] = ;
        baseStatArray[5] = ;
        baseStatArray[6] = ;
        baseStatArray[7] = ;
        baseStatArray[8] = ;
        baseStatArray[9] = ;
        baseStatArray[10] = ;
        baseStatArray[11] = ;
        baseStatArray[12] = ;
        baseStatArray[13] = ;
        baseStatArray[14] = ;
        baseStatArray[15] = ;
        baseStatArray[16] = ;
        baseStatArray[17] = ;
        baseStatArray[18] = ;
        baseStatArray[19] = ;
        baseStatArray[20] = ;
        baseStatArray[21] = ;
        baseStatArray[22] = ;
        baseStatArray[23] = ;
        baseStatArray[24] = ;
        baseStatArray[25] = ;
        baseStatArray[26] = ;
        baseStatArray[27] = ;
        baseStatArray[28] = ;
        baseStatArray[29] = ;
        baseStatArray[30] = ;
        baseStatArray[31] = ;
        baseStatArray[32] = ;
        baseStatArray[33] = ;
        baseStatArray[34] = ;
        baseStatArray[35] = ;
        baseStatArray[36] = ;
        baseStatArray[37] = ;
        baseStatArray[38] = ;
        baseStatArray[39] = ;
        baseStatArray[40] = ;
        baseStatArray[41] = ;
        baseStatArray[42] = ;
        baseStatArray[43] = ;
        baseStatArray[44] = ;
        baseStatArray[45] = ;
        baseStatArray[46] = ;
        baseStatArray[47] = ;
        baseStatArray[48] = ;
        baseStatArray[49] = ;
        baseStatArray[50] = ;
        baseStatArray[51] = ;
        baseStatArray[52] = ;
        baseStatArray[53] = ;
        baseStatArray[54] = ;
        baseStatArray[55] = ;
        baseStatArray[56] = ;
        baseStatArray[57] = ;
        baseStatArray[58] = ;
        baseStatArray[59] = ;
        baseStatArray[60] = ;
        baseStatArray[61] = ;
        baseStatArray[62] = ;
        baseStatArray[63] = ;
        baseStatArray[64] = ;
        baseStatArray[65] = ;
        baseStatArray[66] = ;
        baseStatArray[67] = ;
        baseStatArray[68] = ;
        baseStatArray[69] = ;
        baseStatArray[70] = ;
        baseStatArray[71] = ;
        baseStatArray[72] = ;
        baseStatArray[73] = ;
        baseStatArray[74] = ;
        baseStatArray[75] = ;
        baseStatArray[76] = ;
        baseStatArray[77] = ;
        baseStatArray[78] = ;
        baseStatArray[79] = ;
        baseStatArray[80] = ;
        baseStatArray[81] = ;
        baseStatArray[82] = ;
        baseStatArray[83] = ;
        baseStatArray[84] = ;
        baseStatArray[85] = ;
        baseStatArray[86] = ;
        baseStatArray[87] = ;
        baseStatArray[88] = ;
        baseStatArray[89] = ;
        baseStatArray[90] = ;
        baseStatArray[91] = ;
        baseStatArray[92] = ;
        baseStatArray[93] = ;
        baseStatArray[94] = ;
        baseStatArray[95] = ;
        baseStatArray[96] = ;
        baseStatArray[97] = ;
        baseStatArray[98] = ;
        baseStatArray[99] = ;
        baseStatArray[100] = ;
        baseStatArray[101] = ;
        baseStatArray[102] = ;
        baseStatArray[103] = ;
        baseStatArray[104] = ;
        baseStatArray[105] = ;
        baseStatArray[106] = ;
        baseStatArray[107] = ;
        baseStatArray[108] = ;
        baseStatArray[109] = ;
        baseStatArray[110] = ;
        baseStatArray[111] = ;
        baseStatArray[112] = ;
        baseStatArray[113] = ;
        baseStatArray[114] = ;
        baseStatArray[115] = ;
        baseStatArray[116] = ;
        baseStatArray[117] = ;
        baseStatArray[118] = ;
        baseStatArray[119] = ;
        baseStatArray[120] = ;
        baseStatArray[121] = ;
        baseStatArray[122] = ;
        baseStatArray[123] = ;
        baseStatArray[124] = ;
        baseStatArray[125] = ;
        baseStatArray[126] = ;
        baseStatArray[127] = ;
        baseStatArray[128] = ;
        baseStatArray[129] = ;
        baseStatArray[130] = ;
        baseStatArray[131] = ;
        baseStatArray[132] = ;
        baseStatArray[133] = ;
        baseStatArray[134] = ;
        baseStatArray[135] = ;
        baseStatArray[136] = ;
        baseStatArray[137] = ;
        baseStatArray[138] = ;
        baseStatArray[139] = ;
        baseStatArray[140] = ;
        baseStatArray[141] = ;
        baseStatArray[142] = ;
        baseStatArray[143] = ;
        baseStatArray[144] = ;
        baseStatArray[145] = ;
        baseStatArray[146] = ;
        baseStatArray[147] = ;
        baseStatArray[148] = ;
        baseStatArray[149] = ;
        baseStatArray[150] = ;
        baseStatArray[151] = ;
        baseStatArray[152] = ;
        baseStatArray[153] = ;
        baseStatArray[154] = ;
        baseStatArray[155] = ;
        baseStatArray[156] = ;
        baseStatArray[157] = ;
        baseStatArray[158] = ;
        baseStatArray[159] = ;
        baseStatArray[160] = ;
        baseStatArray[161] = ;
        baseStatArray[162] = ;
        baseStatArray[163] = ;
        baseStatArray[164] = ;
        baseStatArray[165] = ;
        baseStatArray[166] = ;
        baseStatArray[167] = ;
        baseStatArray[168] = ;
        baseStatArray[169] = ;
        baseStatArray[170] = ;
        baseStatArray[171] = ;
        baseStatArray[172] = ;
        baseStatArray[173] = ;
        baseStatArray[174] = ;
        baseStatArray[175] = ;
        baseStatArray[176] = ;
        baseStatArray[177] = ;
        baseStatArray[178] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        baseStatArray[] = ;
        */


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
        } else if (id == R.id.nav_ivCalc) {
            Intent intent = new Intent(this, IvActivity.class);
            startActivity(intent);
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
    public void calcClick(View view){
        starDustSpinPos = spinnerStardust.getSelectedItemPosition();
        pokeSpinPos = spinnerPokemon.getSelectedItemPosition();
        hpValue = Double.parseDouble(hpValueEdit.getText().toString());
        cpValue = Double.parseDouble(cpValueEdit.getText().toString());

        switch(pokeSpinPos){
            case 0:

                break;

        }

        //Switch statement determines which setting the spinner for stardust is in
        switch(starDustSpinPos){
            case 0:
                //For levels 1-4 iterate through to determine all possible values
                for(pokemonLvl = 1; pokemonLvl <= 4; pokemonLvl++){
                    System.out.println(pokemonLvl);
                    //Switch statement to determine possible IVs for each level
                    switch(pokemonLvl){
                        case 1:
                            System.out.println("case 1");
                            cpMulti = 0.094;
                            //IVs range from 0-15 so loop through 0-15 and see if stamina value matches HP value
                            for(loopStaIv = 0.0; loopStaIv <=15; loopStaIv++){
                                staIv = (baseSta + loopStaIv) * cpMulti;
                                finalStaIv = Math.floor(staIv);
                                if (finalStaIv == hpValue){
                                    staIvList.add(finalStaIv);
                                }
                             }
                            break;
                        case 2:
                            System.out.println("case 2");
                            cpMulti = 0.16639787;
                            for(loopStaIv = 0.0; loopStaIv <=15; loopStaIv++){
                                staIv = (baseSta + loopStaIv) * cpMulti;
                                finalStaIv = Math.floor(staIv);
                                if (finalStaIv == hpValue){
                                    staIvList.add(finalStaIv);
                                }
                            }
                            break;
                        case 3:
                            cpMulti = 0.21573247;
                            for(loopStaIv = 0.0; loopStaIv <=15; loopStaIv++){
                                staIv = (baseSta + loopStaIv) * cpMulti;
                                finalStaIv = Math.floor(staIv);
                                if (finalStaIv == hpValue){
                                    staIvList.add(finalStaIv);
                                }
                            }
                            break;
                        case 4:
                            cpMulti = 0.25572005;
                            for(loopStaIv = 0.0; loopStaIv <=15; loopStaIv++){
                                staIv = (baseSta + loopStaIv) * cpMulti;
                                finalStaIv = Math.floor(staIv);
                                if (finalStaIv == hpValue){
                                    staIvList.add(finalStaIv);
                                }
                            }
                            break;
                    }
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }

    }
}
