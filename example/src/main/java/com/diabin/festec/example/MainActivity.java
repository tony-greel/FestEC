package com.diabin.festec.example;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.diabin.festec.example.adapter.TabNameAdapter;
import com.diabin.festec.example.fragment.ClassificationFragment;
import com.diabin.festec.example.fragment.MainFragment;
import com.diabin.festec.example.fragment.MyFragment;
import com.diabin.festec.example.fragment.RecommendedFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_vp)
    ViewPager mainVp;
    @BindView(R.id.img_home)
    ImageView imgHome;
    @BindView(R.id.ll_main_recommend)
    LinearLayout llMainRecommend;
    @BindView(R.id.img_classification)
    ImageView imgClassification;
    @BindView(R.id.ll_main_science)
    LinearLayout llMainScience;
    @BindView(R.id.img_popular)
    ImageView imgPopular;
    @BindView(R.id.ll_main_journalism)
    LinearLayout llMainJournalism;
    @BindView(R.id.img_personal)
    ImageView imgPersonal;
    @BindView(R.id.ll_main_automobile)
    LinearLayout llMainAutomobile;

    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;
    private final boolean isLazyLoad = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mFragments.add(new MainFragment());
        mFragments.add(new RecommendedFragment());
        mFragments.add(new ClassificationFragment());
        mFragments.add(new MyFragment());
        TabNameAdapter tabNameAdapter = new TabNameAdapter(getSupportFragmentManager(), mFragments);
        mainVp.setAdapter(tabNameAdapter);
    }

    @OnClick({R.id.ll_main_recommend, R.id.ll_main_science, R.id.ll_main_journalism, R.id.ll_main_automobile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_main_recommend:
                mainVp.setCurrentItem(0);
                break;
            case R.id.ll_main_science:
                mainVp.setCurrentItem(1);
                break;
            case R.id.ll_main_journalism:
                mainVp.setCurrentItem(2);
                break;
            case R.id.ll_main_automobile:
                mainVp.setCurrentItem(3);
                break;
        }
    }

}
