package josef.ranopa.n01312587;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.util.Calendar;

public class JosefActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_josef);


        drawer = findViewById(R.id.josefdrawer);
        toolbar = findViewById(R.id.joseftoolbar);
        navigationView = findViewById(R.id.josefnavigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.joshome:
                getSupportFragmentManager().beginTransaction().replace(R.id.josef_container,
                        new JoHome()).commit();
                break;

            case R.id.josjosef:
                getSupportFragmentManager().beginTransaction().replace(R.id.josef_container,
                        new JosDown()).commit();
                break;
            case R.id.josranopa:
                getSupportFragmentManager().beginTransaction().replace(R.id.josef_container,
                        new RaSrv()).commit();
                break;
            case R.id.jossetting:
                getSupportFragmentManager().beginTransaction().replace(R.id.josef_container,
                        new RaSet()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

   /*@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawer.closeDrawer(GravityCompat.START);


        if(menuItem.getItemId() == R.id.joshome){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.josef_container,new JoHome());
            fragmentTransaction.commit();
        }

        if(menuItem.getItemId() == R.id.josjosef){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.josef_container,new JosDown());
            fragmentTransaction.commit();
        }

        if(menuItem.getItemId() == R.id.josranopa){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.josef_container,new RaSrv());
            fragmentTransaction.commit();
        }

        if(menuItem.getItemId() == R.id.jossetting){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.josef_container,new RaSet());
            fragmentTransaction.commit();
        }

        return true;
    }*/