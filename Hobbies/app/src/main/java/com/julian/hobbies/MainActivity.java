package com.julian.hobbies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.julian.hobbies.fragments.FragmentFutbol;
import com.julian.hobbies.fragments.FragmentSeriesPeliculas;
import com.julian.hobbies.fragments.FragmentTodos;
import com.julian.hobbies.fragments.FragmentVideojuegos;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView imagenCabecera;
    private TextView textoCabecera;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        //configurarToolbar();
        acciones();
    }

    private void acciones() {


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()) {

                    case R.id.item_futbol:
                        fragmentTransaction.replace(R.id.sitioFragment, new FragmentFutbol(), "fFutbol");
                        fragmentTransaction.addToBackStack("fFutbol");
                        imagenCabecera.setImageResource(R.drawable.champion);
                        textoCabecera.setText("Futbol");

                        break;
                    case R.id.item_seriesPeliculas:
                        fragmentTransaction.replace(R.id.sitioFragment, new FragmentSeriesPeliculas(), "fSeriesPeliculas");
                        fragmentTransaction.addToBackStack("fSeriesPeliculas");
                        imagenCabecera.setImageResource(R.drawable.film);
                        textoCabecera.setText("Series-Peliculas");
                        break;
                    case R.id.item_videojuegos:
                        fragmentTransaction.replace(R.id.sitioFragment, new FragmentVideojuegos(), "fVideojuegos");
                        fragmentTransaction.addToBackStack("fVideojuegos");
                        imagenCabecera.setImageResource(R.drawable.xbox);
                        textoCabecera.setText("Videojuegos");
                        break;
                    case R.id.item_todos:
                        fragmentTransaction.replace(R.id.sitioFragment, new FragmentTodos(), "fTodos");
                        fragmentTransaction.addToBackStack("fTodos");
                        imagenCabecera.setImageResource(R.drawable.fondo_defecto);
                        textoCabecera.setText("Todos");
                        break;
                }
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    private void instancias() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        imagenCabecera = findViewById(R.id.img_cabecera);
        textoCabecera = findViewById(R.id.txt_cabecera);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        imagenCabecera = navigationView.getHeaderView(0).findViewById(R.id.img_cabecera);
        textoCabecera = navigationView.getHeaderView(0).findViewById(R.id.txt_cabecera);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (drawerLayout.isOpen()) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                finish();
            } else {
                super.onBackPressed();
            }

        }
    }
}