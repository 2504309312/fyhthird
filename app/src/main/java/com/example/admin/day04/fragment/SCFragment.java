package com.example.admin.day04.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.day04.R;
import com.example.admin.day04.StudentBeanDao;
import com.example.admin.day04.activity.ShowActivity;
import com.example.admin.day04.adapter.ScRecyclerAdapter;
import com.example.admin.day04.app.MyApp;
import com.example.admin.day04.bean.StudentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SCFragment extends Fragment {

    private RecyclerView recycler_sc;
    private List<StudentBean> mStudentBeans;
    private List<List>list=new ArrayList<>();
    private StudentBeanDao mStudentBeanDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_sc, container, false);
        mStudentBeanDao = MyApp.getMyApp().getDaoSession().getStudentBeanDao();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {



        mStudentBeans = mStudentBeanDao.loadAll();
        list.add(mStudentBeans);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        recycler_sc.setLayoutManager(staggeredGridLayoutManager);

        ScRecyclerAdapter scRecyclerAdapter = new ScRecyclerAdapter(list.get(0), getActivity());

        recycler_sc.setAdapter(scRecyclerAdapter);


        scRecyclerAdapter.notifyDataSetChanged();


        scRecyclerAdapter.setOnClickListener(new ScRecyclerAdapter.OnClick() {
            @Override
            public void onClicklistener(int position) {

                String name = mStudentBeans.get(position).getName();
                String content = mStudentBeans.get(position).getContent();
                String img = mStudentBeans.get(position).getImg();

                Intent intent = new Intent(getActivity(), ShowActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("content",content);
                intent.putExtra("img",img);
                startActivity(intent);

            }

            @Override
            public void onClickLonglistener(int position) {

            }
        });

    }

    private void initView(View inflate) {
        recycler_sc = (RecyclerView) inflate.findViewById(R.id.recycler_sc);
    }

    @Override
    public void onResume() {
        super.onResume();
        list.add(mStudentBeanDao.loadAll());
    }
}
