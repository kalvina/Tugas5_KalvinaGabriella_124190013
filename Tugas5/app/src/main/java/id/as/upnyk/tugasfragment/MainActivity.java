package id.as.upnyk.tugasfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import id.as.upnyk.tugasfragment.product.album.AlbumFragment;
import id.as.upnyk.tugasfragment.product.merch.MerchFragment;
import id.as.upnyk.tugasfragment.order.OrderFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new OrderFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_item_order:
                fragment = new OrderFragment();
                break;
            case R.id.nav_item_album:
                fragment = new AlbumFragment();
                break;
            case R.id.nav_item_merch:
                fragment = new MerchFragment();
        }
        return loadFragment(fragment);
    }
}