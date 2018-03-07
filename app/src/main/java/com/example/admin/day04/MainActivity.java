package com.example.admin.day04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.admin.day04.activity.ListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toobar;
    private Button btn_tg;
    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();

    }

    private void initData() {

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);

        linear.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void initView() {
        toobar = (Toolbar) findViewById(R.id.toobar);
        btn_tg = (Button) findViewById(R.id.btn_tg);
        setSupportActionBar(toobar);
        btn_tg.setOnClickListener(this);
        linear = (LinearLayout) findViewById(R.id.linear);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tg:
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                break;
        }
    }
}
