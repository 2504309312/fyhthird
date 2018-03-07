package com.example.admin.day04.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.day04.R;
import com.example.admin.day04.StudentBeanDao;
import com.example.admin.day04.app.MyApp;
import com.example.admin.day04.bean.StudentBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 2018/3/6.
 */

public class LBRecyclerAdapter extends RecyclerView.Adapter<LBRecyclerAdapter.ViewHolder> {
    private List<StudentBean> mStudent;
    private Context mContext;

    public LBRecyclerAdapter(List<StudentBean> student, Context context) {
        mStudent = student;
        mContext = context;
    }

    @Override
    public LBRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.lbitem, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final LBRecyclerAdapter.ViewHolder holder, final int position) {

        Picasso.with(mContext).load(mStudent.get(position).getImg()).into(holder.mImgLb);
        holder.mTvContent.setText(mStudent.get(position).getContent());
        holder.mTvName.setText(mStudent.get(position).getName());

        holder.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    StudentBeanDao studentBeanDao = MyApp.getMyApp().getDaoSession().getStudentBeanDao();
                    StudentBean studentBean = new StudentBean();
                    Long id = mStudent.get(position).getId();
                    String img = mStudent.get(position).getImg();
                    String content = mStudent.get(position).getContent();
                    String name = mStudent.get(position).getName();
                    studentBean.setImg(img);
                    studentBean.setContent(content);
                    studentBean.setName(name);

                    long insert = studentBeanDao.insert(studentBean);

                    if (insert>0){
                        Log.e("itnr","添加成功");
                    }

                }else {

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mStudent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImgLb;
        private final TextView mTvName;
        private final TextView mTvContent;
        private final CheckBox mCheck;

        public ViewHolder(View itemView) {
            super(itemView);

            mImgLb = itemView.findViewById(R.id.img_lb);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvContent = itemView.findViewById(R.id.tv_content);
            mCheck = itemView.findViewById(R.id.check);


        }
    }
}
