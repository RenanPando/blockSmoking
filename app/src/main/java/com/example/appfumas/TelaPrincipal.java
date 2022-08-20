package com.example.appfumas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appfumas.Fragments.FragmentHome;
import com.example.appfumas.Fragments.FragmentRegistros;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class TelaPrincipal extends AppCompatActivity {
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        setTheme(R.style.Theme_BlockSmokingTerciary);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.navigation_view);
        getWindow().setStatusBarColor(getResources().getColor(R.color.whiteish));
        replaceFragment(new FragmentHome());
        toolbar.setTitle("Início");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch(id){
                    case R.id.itemRegistros:
                        replaceFragment(new FragmentRegistros());
                        toolbar.setTitle("Registros");
                        break;
                    case R.id.itemHome:
                        replaceFragment(new FragmentHome());
                        toolbar.setTitle("Início");
                        break;
                    case R.id.itemSair:
                        mudarTela();
                    default:
                        return true;
                }

                return true;
            }
        });

    }

    public void mudarTela(){
        startActivity(new Intent(this, MainActivity.class));
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.constraintLayout, fragment);
        fragmentTransaction.commit();
    }

}