package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_MyApplication);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(binding.navView, navController);

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home).setOpenableLayout(binding.drawerLayout).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }

//    public void openActivity2() {
//        Intent intent = new Intent(this, Activity2.class);
//        startActivity(intent);
//    }
//
//    public void submitbuttonHandler(View view) {
//
//    }
//
//    public void radioButtonhandler(View view) {
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}