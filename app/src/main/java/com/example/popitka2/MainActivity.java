package com.example.popitka2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);


        loadFragment(new FirstFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_first:
                    loadFragment(new FirstFragment());
                    setTitle(menuItem.getTitle());
                    return true;
                case R.id.nav_second:
                    loadFragment(new SecondFragment());
                    setTitle(menuItem.getTitle());
                    return true;
                default:
                    return false;
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        ImageView headerImage = headerView.findViewById(R.id.header_image);
        headerImage.setOnClickListener(v -> {
            Toast.makeText(this, "Изображение заголовка нажато", Toast.LENGTH_SHORT).show();
        });
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_item1:
                    Toast.makeText(this, "Выбран пользователь", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_item2:
                    Toast.makeText(this, "Выбрана почта", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_item3:
                    Toast.makeText(this, "Выбрана музыка", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_item4:
                    Toast.makeText(this, "Выбраны новости", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_item5:
                    Toast.makeText(this, "Выбраны настройки", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_item6:
                    loadFragment(new FirstFragment());
                    setTitle("Первый фрагмент");
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_item7:
                    loadFragment(new SecondFragment());
                    setTitle("Второй фрагмент");
                    drawerLayout.closeDrawers();
                    return true;
                default:
                    return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        if (fragment instanceof FirstFragment) {
            setTitle("Первый фрагмент");
        } else if (fragment instanceof SecondFragment) {
            setTitle("Второй фрагмент");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_first:
                loadFragment(new FirstFragment());
                setTitle("Первый фрагмент");
                selectBottomNavigationItem(R.id.nav_first);
                return true;
            case R.id.action_second:
                loadFragment(new SecondFragment());
                setTitle("Второй фрагмент");
                selectBottomNavigationItem(R.id.nav_second);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void selectBottomNavigationItem(int itemId) {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(itemId);
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
