package com.example.bleweight.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bleweight.R;
import com.example.bleweight.utils.XToastUtils;


public class PiciProductAdapter extends RecyclerView.Adapter<PiciProductAdapter.ListHolder> {

    private Context mContext;
//    int iconA[] = {
//            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
//
//    String productTv[] = {"大蒜1", "大蒜2", "大蒜3", "大蒜4", "大蒜5", "大蒜6", "大蒜7",
//            "大蒜8", "大蒜9", "大蒜10", "大蒜11", "大蒜12", "大蒜13", "大蒜14", "大蒜15",
//            "大蒜16", "大蒜17", "大蒜18",
//            "大蒜19", "大蒜20"};
    int[] icons;
    String[] txt;

    public PiciProductAdapter(Context context, int[] icon, String[] productTv) {
        this.mContext = context;
        this.icons = icon;
        this.txt = productTv;

    }


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.pici_grid_item, null);
        return new ListHolder(view);
    }


    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return  this.icons.length;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            XToastUtils.success("点击：" + position);
        }
    };


    class ListHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView tv_pici_product;

        public ListHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(onClickListener);

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