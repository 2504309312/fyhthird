package com.example.admin.day04.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.day04.R;
import com.squareup.picasso.Picasso;

public class ShowActivity extends AppCompatActivity {

    private ImageView show_img;
    private TextView show_name;
    private TextView show_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();

        initData();
    }

    private void initData() {

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String content = intent.getStringExtra("content");
        String img = intent.getStringExtra("img");

        Picasso.with(ShowActivity.this).load(img).into(show_img);
        show_content.setText(content);
        show_name.setText(name);

    }

    private void initView() {
        show_img = (ImageView) findViewById(R.id.show_img);
        show_name = (TextView) findViewById(R.id.show_name);
        show_content = (TextView) findViewById(R.id.show_content);
    }
}
