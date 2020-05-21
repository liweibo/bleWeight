package com.example.bleweight.adapter;

import androidx.annotation.NonNull;

import com.example.bleweight.R;
import com.example.bleweight.utils.data.productAddDataInfo;
import com.xuexiang.xui.adapter.recyclerview.BaseRecyclerAdapter;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;


public class ProductRecyclerAdapter extends BaseRecyclerAdapter<productAddDataInfo> {

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.adapter_product_recy_item;
    }

    @Override
    public void bindData(@NonNull RecyclerViewHolder holder, int position, productAddDataInfo model) {
        if (model != null) {
            //给对应的item中的子组件分别赋值；
            holder.text(R.id.tv_item_prod_xuhao, model.getxuhao() + "");//工单编号
            holder.text(R.id.tv_item_prod_name, model.getprodName());
            holder.text(R.id.tv_item_prod_danjia, model.getdanjia() + "");
            holder.text(R.id.tv_item_prod_jianshu, model.getjianshu() + "");
            holder.text(R.id.tv_item_prod_xiaoji, model.getXiaoji() + "");
            holder.text(R.id.tv_item_prod_zhongliang, model.getzhongliang() + "");

        }
    }

}
