package com.example.mobilef2interface;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;

    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.dashboard);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.Open, R.string.Close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Dashboard()).commit();

            navigationView.setCheckedItem(R.id.dashboard);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        toolbar.setTitle(item.getTitle());
        if(item.getItemId()==R.id.dashboard){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Dashboard()).commit();
        }
        else if(item.getItemId()==R.id.console){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Console()).commit();
        }
        else if(item.getItemId()==R.id.files){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Files()).commit();
        }
        else if(item.getItemId()==R.id.history){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new History()).commit();
        }
        else if(item.getItemId()==R.id.manage){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Manage()).commit();
        }
        else if(item.getItemId()==R.id.config){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new Config()).commit();
        }
        else if(item.getItemId()==R.id.system){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout, new System()).commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

}