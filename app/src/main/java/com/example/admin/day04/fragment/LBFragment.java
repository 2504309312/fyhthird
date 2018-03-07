package com.example.admin.day04.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.day04.R;
import com.example.admin.day04.adapter.LBRecyclerAdapter;
import com.example.admin.day04.bean.LBbean;
import com.example.admin.day04.bean.StudentBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LBFragment extends Fragment {

    private RecyclerView recycler_lb;
    private String path = "http://172.16.54.31:8080/more/data.txt";
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            Gson gson = new Gson();
            LBbean lBbean = gson.fromJson(str, LBbean.class);
            mStudent = lBbean.getStudents().getStudent();

            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

            recycler_lb.setLayoutManager(staggeredGridLayoutManager);

            LBRecyclerAdapter lbRecyclerAdapter = new LBRecyclerAdapter(mStudent, getActivity());

            recycler_lb.setAdapter(lbRecyclerAdapter);


        }
    };
    private List<StudentBean> mStudent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_lb, container, false);

        initView(inflate);

        initData();

        return inflate;
    }

    private void initData() {

        OkHttpClient okhttp = new OkHttpClient().newBuilder().cache(new Cache(getActivity().getCacheDir(), 10 * 1024 * 1024)).build();

        Request build = new Request.Builder().url(path).build();

        okhttp.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message = new Message();
                message.obj = string;
                mHandler.sendMessage(message);
            }
        });

    }

    private void initView(View inflate) {
        recycler_lb = (RecyclerView) inflate.findViewById(R.id.recycler_lb);
    }
}
