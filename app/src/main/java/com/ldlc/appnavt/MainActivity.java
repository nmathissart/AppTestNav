
package com.ldlc.appnavt;

import android.arch.lifecycle.LiveData;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LiveData<NavController> currentNavController = null;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         if (savedInstanceState == null) {
             setupBottomNavigationBar();
         } // Else, need to wait for onRestoreInstanceState
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setupBottomNavigationBar();
    }

    @Override
    public boolean onSupportNavigateUp() {
        try {
            return currentNavController.getValue().navigateUp();
        }catch (Exception e) {
            return false;
        }
    }

    private void setupBottomNavigationBar() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);

        List<Integer> navGraphIds = new ArrayList<>();
        navGraphIds.add(R.navigation.home);
        navGraphIds.add(R.navigation.favourite);

        LiveData<NavController> controller = NavigationExtensionsTKt.setupWithNavController(bottomNavigationView, navGraphIds, getSupportFragmentManager(), R.id.nav_host_container, getIntent());

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, (navController) -> {
            NavigationUI.setupActionBarWithNavController(this, navController);
        });

        currentNavController = controller;

    }


}
