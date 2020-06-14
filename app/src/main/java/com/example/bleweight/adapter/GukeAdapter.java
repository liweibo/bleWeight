package com.example.bleweight.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bleweight.R;

import java.util.ArrayList;
import java.util.List;


public class GukeAdapter extends RecyclerView.Adapter<GukeAdapter.ListHolder> implements View.OnClickListener {
    private OnItemMyClickListener mOnItemMyClickListener;
    private Activity activity;

    List<String> gukeListdata = new ArrayList<>();



    public GukeAdapter() {
//        this.activity = activity;
//       this.gukeListdata = gukeListdata;
        gukeListdata.add("李书行");
        gukeListdata.add("廖冰");
        gukeListdata.add("刘波");
        gukeListdata.add("王三毛");
        gukeListdata.add("陈炜");
        gukeListdata.add("刘鹏");
        gukeListdata.add("郝波");
        gukeListdata.add("黄铖");
        gukeListdata.add("王名");
        gukeListdata.add("黎梦");
        gukeListdata.add("吴燕飞");
        gukeListdata.add("燕家云");
        gukeListdata.add("康圆融");
    }


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.guke_grid_item, null);
        ListHolder myViewHolder = new ListHolder(view);
        view.setOnClickListener(this);//将创建的Vie注册点击事件
        return myViewHolder;

    }


    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.itemView.setTag(position);//将position保存在itemView的tag中，一边点击时获取
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return this.gukeListdata.size();
    }



    @Override
    public void onClick(View view) {
        if (mOnItemMyClickListener != null) {
            mOnItemMyClickListener.onItemClick(view, (int) view.getTag());//注意这里使用getTag方法获取position
        }

    }


    public interface OnItemMyClickListener {
        void onItemClick(View view, int position);
    }
    public void setOnItemMyClickListener(OnItemMyClickListener listener) {
        this.mOnItemMyClickListener = listener;
    }

    class ListHolder extends RecyclerView.ViewHolder {

        TextView tv_guke;

        public ListHolder(View itemView) {
            super(itemView);

            tv_guke = itemView.findViewById(R.id.tv_guke_recy_item);
        }

        public void setData(int position) {

            itemView.setTag(position);
            tv_guke.setText(gukeListdata.get(position));
        }
    }
}