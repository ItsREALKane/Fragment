package com.example.fragmentpakaji;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fragmentpakaji.fragments.fragment1;
import com.example.fragmentpakaji.fragments.fragment2;
import com.example.fragmentpakaji.fragments.fragment3;
import com.example.fragmentpakaji.fragments.fragment4;
import com.example.fragmentpakaji.fragments.fragment5;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        // Load the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new fragment1())
                .commit();
    }

    private BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.menu_item1) {
                        selectedFragment = new fragment1();
                    } else if (item.getItemId() == R.id.menu_item2) {
                        selectedFragment = new fragment2();
                    } else if (item.getItemId() == R.id.menu_item3) {
                        selectedFragment = new fragment3();
                    } else if (item.getItemId() == R.id.menu_item4) {
                        selectedFragment = new fragment4();
                    } else if (item.getItemId() == R.id.menu_item5) {
                        selectedFragment = new fragment5();
                    }


                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, selectedFragment)
                            .commit();

                    return true;
                }
            };
}
