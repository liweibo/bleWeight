package com.example.bleweight.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bleweight.MainActivity;
import com.example.bleweight.MyApplication;
import com.example.bleweight.R;
import com.example.bleweight.utils.XToastUtils;
import com.example.bleweight.utils.data.productAddDataInfo;
import com.xuexiang.xui.adapter.recyclerview.BaseRecyclerAdapter;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;


public class ProductRecyclerAdapter extends BaseRecyclerAdapter<productAddDataInfo> {
    LinearLayout top_on_lefts, tv_status_right_tops;
    View view_top_on_rights;
    TextView tvPros;
    MyApplication apps;

    public ProductRecyclerAdapter(LinearLayout top_on_left,
                                  View view_top_on_right,
                                  LinearLayout tv_status_right_top,
                                  TextView tvPro, MyApplication app) {
        top_on_lefts = top_on_left;
        view_top_on_rights = view_top_on_right;
        tv_status_right_tops = tv_status_right_top;
        tvPros = tvPro;
        apps = app;
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.adapter_product_recy_item;
    }

    @Override
    public void bindData(@NonNull RecyclerViewHolder holder, final int position, final productAddDataInfo model) {
        if (model != null) {
            //给对应的item中的子组件分别赋值；
            holder.text(R.id.tv_item_prod_xuhao, model.getxuhao() + "");//工单编号
            holder.text(R.id.tv_item_prod_name, model.getprodName());
            holder.text(R.id.tv_item_prod_danjia, model.getdanjia() + "");
            holder.text(R.id.tv_item_prod_jianshu, model.getjianshu() + "");
            holder.text(R.id.tv_item_prod_xiaoji, model.getXiaoji() + "");
            holder.text(R.id.tv_item_prod_zhongliang, model.getzhongliang() + "");


            holder.itemView.findViewById(R.id.ll_recy_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    XToastUtils.success("pro:" + model.getprodName());
                    apps.setAdapterPos(position);//记录点击的adapter的位置
                    top_on_lefts.setVisibility(View.VISIBLE);
                    view_top_on_rights.setVisibility(View.VISIBLE);
                    tv_status_right_tops.setVisibility(View.VISIBLE);
                    tvPros.setText(model.getprodName());

                }
            });


        }
    }

}
