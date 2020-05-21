package com.example.bleweight.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bleweight.R;


public class PiciProductAdapter extends RecyclerView.Adapter<PiciProductAdapter.ListHolder> implements View.OnClickListener {
    private OnItemMyClickListener mOnItemMyClickListener;
    private Activity activity;

    int[] icons;
    String[] txt;

    public PiciProductAdapter(Activity activity, int[] icon, String[] productTv) {
        this.activity = activity;
        this.icons = icon;
        this.txt = productTv;

    }


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.pici_grid_item, null);
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
        return this.icons.length;
    }

//    View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            int position = (int) v.getTag();
////            OrderNoProductFragment fragorder = new OrderNoProductFragment();
////            fragorder.setGirlGone();
////            fragorder.setLLHaveProd();
//            XToastUtils.success("点击：" + position);
//        }
//    };

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
        ImageView icon;
        TextView tv_pici_product;

        public ListHolder(View itemView) {
            super(itemView);

//            itemView.setOnClickListener(onClickListener);

            icon = itemView.findViewById(R.id.pic_pici);
            tv_pici_product = itemView.findViewById(R.id.tv_pici_product);
        }

        public void setData(int position) {

            itemView.setTag(position);
            icon.setImageResource(icons[position]);
            tv_pici_product.setText(txt[position]);
        }
    }
}