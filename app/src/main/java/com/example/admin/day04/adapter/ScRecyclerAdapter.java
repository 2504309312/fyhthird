package com.example.admin.day04.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.day04.R;
import com.example.admin.day04.bean.StudentBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 2018/3/6.
 */

public class ScRecyclerAdapter  extends RecyclerView.Adapter<ScRecyclerAdapter.ViewHolder>{
    private List<StudentBean> mStudentBeans;
    private Context mContext;
    //新加一行代码哈哈啊哈哈哈哈哈哈
    public ScRecyclerAdapter(List<StudentBean> studentBeans, Context context) {
        mStudentBeans = studentBeans;
        mContext = context;
    }
    //新家第二行
    @Override
    public ScRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.scitem, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ScRecyclerAdapter.ViewHolder holder, final int position) {

        Picasso.with(mContext).load(mStudentBeans.get(position).getImg()).into(holder.mImgSc);
        holder.mScContent.setText(mStudentBeans.get(position).getContent());
        holder.mScName.setText(mStudentBeans.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClick.onClicklistener(position);
                    }
                });
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onClick.onClickLonglistener(position);
                        return true;
                    }
                });

    }

    @Override
    public int getItemCount() {
        return mStudentBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImgSc;
        private final TextView mScContent;
        private final TextView mScName;

        public ViewHolder(View itemView) {
            super(itemView);

            mImgSc = itemView.findViewById(R.id.img_sc);
            mScContent = itemView.findViewById(R.id.sc_content);
            mScName = itemView.findViewById(R.id.sc_name);

        }
    }
     public interface OnClick{
             void onClicklistener(int position);

             void onClickLonglistener(int position);

         }
         private OnClick onClick;
         public void setOnClickListener(OnClick onClick){

             this.onClick = onClick;


         }
}
