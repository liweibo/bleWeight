package com.example.bleweight.adapter;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.bleweight.MyApplication;
import com.example.bleweight.R;
import com.example.bleweight.utils.data.productAddDataInfo;
import com.xuexiang.xui.adapter.recyclerview.BaseRecyclerAdapter;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;


public class BillRecyclerAdapter extends BaseRecyclerAdapter<productAddDataInfo> {

    public BillRecyclerAdapter() {

    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.adapter_bill_recy_item;
    }

    @Override
    public void bindData(@NonNull RecyclerViewHolder holder, final int position, final productAddDataInfo model) {
        if (model != null) {
            //给对应的item中的子组件分别赋值；
            holder.text(R.id.tv_item_bill_xuhao, model.getxuhao() + "");
            holder.text(R.id.tv_item_bill_name, model.getprodName());
            holder.text(R.id.tv_item_bill_danjia, model.getdanjia() + "");
            holder.text(R.id.tv_item_bill_jianshu, model.getjianshu() + "");
            holder.text(R.id.tv_item_bill_xiaoji, model.getXiaoji() + "");
            holder.text(R.id.tv_item_bill_zhongliang, model.getzhongliang() + "");


            holder.itemView.findViewById(R.id.ll_recy_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });


        }


    }


}
