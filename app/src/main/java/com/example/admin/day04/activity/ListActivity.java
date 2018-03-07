package com.example.admin.day04.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.admin.day04.R;
import com.example.admin.day04.adapter.MyFragmentPAGERAdapter;
import com.example.admin.day04.fragment.LBFragment;
import com.example.admin.day04.fragment.SCFragment;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Toolbar toobar_lb;
    private FrameLayout frame;
    private RadioButton btn_lb;
    private RadioButton btn_sc;
    private RadioGroup rg;
    private List<Fragment> mFragmentList;
    private ViewPager vp;
    private MyFragmentPAGERAdapter mMyFragmentPAGERAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        initView();

        initData();
    }

    private void initData() {

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new LBFragment());
        mFragmentList.add(new SCFragment());

        mMyFragmentPAGERAdapter = new MyFragmentPAGERAdapter(getSupportFragmentManager(), mFragmentList);

        vp.setAdapter(mMyFragmentPAGERAdapter);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    rg.getChildAt(position).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {
        btn_lb = (RadioButton) findViewById(R.id.btn_lb);
        btn_sc = (RadioButton) findViewById(R.id.btn_sc);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        vp = (ViewPager) findViewById(R.id.vp);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.btn_lb:
                vp.setCurrentItem(0);
                break;
            case R.id.btn_sc:
                vp.setCurrentItem(1);
                break;
        }
    }

}
