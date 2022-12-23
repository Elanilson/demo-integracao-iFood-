package com.apkdoandroid.demoifoodintegracao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.apkdoandroid.demoifoodintegracao.databinding.ActivityMainBinding;
import com.apkdoandroid.demoifoodintegracao.view.CarrinhoFragment;
import com.apkdoandroid.demoifoodintegracao.view.HomeFragment;
import com.apkdoandroid.demoifoodintegracao.view.ProdutosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding  binding;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        configuracaoBottomNavigation();
    }

    private void configuracaoBottomNavigation(){
        bottomNavigationView = binding.buttonNavigation;
        getSupportFragmentManager().beginTransaction().replace(R.id.linarBody,new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.produtos:
                        fragment = new ProdutosFragment();
                        break;
                    case R.id.carrinho:
                        fragment = new CarrinhoFragment();
                        break;
                   /* case R.id.home:
                        fragment = new HomeFragment();
                        break;*/

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.linarBody,fragment).commit();

                return true;
            }
        });
    }

}
