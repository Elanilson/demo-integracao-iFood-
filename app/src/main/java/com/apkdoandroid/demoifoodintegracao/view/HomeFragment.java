package com.apkdoandroid.demoifoodintegracao.view;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkdoandroid.demoifoodintegracao.R;
import com.apkdoandroid.demoifoodintegracao.adapter.BannerAdapter;
import com.apkdoandroid.demoifoodintegracao.adapter.DestaqueAdapter;
import com.apkdoandroid.demoifoodintegracao.adapter.LojaAdapter;
import com.apkdoandroid.demoifoodintegracao.databinding.FragmentHomeBinding;
import com.apkdoandroid.demoifoodintegracao.model.Destaque;
import com.apkdoandroid.demoifoodintegracao.viewmodel.HomeViewModel;

import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private ViewPager2 viewPager2Banner;
    private BannerAdapter adapter =  new BannerAdapter();
    private LojaAdapter lojaAdapter = new LojaAdapter();
    private DestaqueAdapter destaqueAdapter = new DestaqueAdapter();
    private Handler slideHandler = new Handler();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater,container, false);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewPager2Banner = binding.viewPagerBannes;
        binding.toolbarHome.toolbar.setTitle("Delivery");
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarHome.toolbar);




        viewModel.getListaBanners();
        viewModel.popuarDestaque();
        viewModel.carregarLoja();
        configurarViewPage();
        configurarRecyclviewDestaque();
        configurarRecyclviewLojas();
        
        observe();
        return binding.getRoot();
    }

    private void configurarRecyclviewLojas(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        binding.recyclerviewLojas.setLayoutManager(manager);
        binding.recyclerviewLojas.setAdapter(lojaAdapter);
        binding.recyclerviewLojas.setNestedScrollingEnabled(false);
    }
    private void configurarRecyclviewDestaque(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        binding.recyclerviewDestaque.setLayoutManager(manager);
        binding.recyclerviewDestaque.setAdapter(destaqueAdapter);
    }
    private void configurarViewPage(){
        viewPager2Banner.setAdapter(adapter);
        viewPager2Banner.setClipToPadding(false);
        viewPager2Banner.setClipChildren(false);
        viewPager2Banner.setOffscreenPageLimit(4);
        viewPager2Banner.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleX(0.95f + r * 0.05f);
            }
        });

        viewPager2Banner.setPageTransformer(compositePageTransformer);
        viewPager2Banner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderHunnable);
                slideHandler.postDelayed(sliderHunnable,3000); // slider duração 3 segundos
            }
        });
    }

    private Runnable sliderHunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2Banner.setCurrentItem(viewPager2Banner.getCurrentItem()+1);

        }
    };

    private void observe() {
        viewModel.lojas.observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                lojaAdapter.attackLista(strings);
            }
        });
        viewModel.destaques.observe(getViewLifecycleOwner(), new Observer<List<Destaque>>() {
            @Override
            public void onChanged(List<Destaque> destaques) {
                destaqueAdapter.attackListar(destaques);
            }
        });
       viewModel.banners.observe(getViewLifecycleOwner(), new Observer<List<String>>() {
           @Override
           public void onChanged(List<String> strings) {
               adapter.attackListaBanner(strings);
           }
       });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_shopping, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}