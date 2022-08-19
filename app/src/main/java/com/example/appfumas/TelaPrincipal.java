package com.example.appfumas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.appfumas.Fragments.FragmentGraficos;
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
        replaceFragment(new FragmentRegistros());
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

                    case R.id.itemConta:
                        Toast.makeText(TelaPrincipal.this, "teste conta", Toast.LENGTH_SHORT).show();
                    case R.id.itemRegistros:
                        replaceFragment(new FragmentRegistros());
                        break;
                    case R.id.itemGraficos:
                        replaceFragment(new FragmentGraficos());
                        break;
                    case R.id.itemGastos:
                        Toast.makeText(TelaPrincipal.this, "teste gastos", Toast.LENGTH_SHORT).show();
                    case R.id.itemConfig:
                        Toast.makeText(TelaPrincipal.this, "teste config", Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }

                return true;
            }
        });

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.constraintLayout, fragment);
        fragmentTransaction.commit();
    }

}