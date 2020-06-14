package com.example.bleweight.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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
    EditText jianshus, jizhongs, danjias;
    FrameLayout fjijians, fjizhongs;
    Button jijian_btns, jizhong_btns;

    public ProductRecyclerAdapter(LinearLayout top_on_left,
                                  View view_top_on_right,
                                  LinearLayout tv_status_right_top,
                                  TextView tvPro,
                                  EditText jianshu,
                                  EditText jizhong,
                                  EditText danjia,
                                  FrameLayout fjijian,
                                  FrameLayout fjizhong,
                                  Button jijian_btn,
                                  Button jizhong_btn,

                                  MyApplication app) {
        top_on_lefts = top_on_left;
        view_top_on_rights = view_top_on_right;
        tv_status_right_tops = tv_status_right_top;
        tvPros = tvPro;
        jianshus = jianshu;
        jizhongs = jizhong;
        danjias = danjia;
        fjijians = fjijian;
        fjizhongs = fjizhong;
        jijian_btns = jijian_btn;
        jizhong_btns = jizhong_btn;
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
            holder.text(R.id.tv_item_prod_xuhao, model.getxuhao() + "");
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
                    apps.setClickRecyPro(0);//表示点击右边的商品列表

                    top_on_lefts.setVisibility(View.VISIBLE);
                    view_top_on_rights.setVisibility(View.VISIBLE);
                    tv_status_right_tops.setVisibility(View.VISIBLE);
                    tvPros.setText(model.getprodName());

                    //为体验更好：点击商品项目时，进入后，商品是计重的则显示计重按钮，
                    // 并把之前的数据填充到两个edittext中。
                    setValue(model, jianshus, jizhongs,
                            danjias);

                }
            });


        }


    }


    public void setValue(productAddDataInfo dataInfo,
                         EditText jijian,
                         EditText jizhong,
                         EditText danjia) {
        String zhonliangValue = dataInfo.getzhongliang();
        System.out.println("====>>>>  " + zhonliangValue);
        if (zhonliangValue.trim().equals("-")) {
            //表示计件按钮自动被选中，计zhong不能被选中。
            //同时单价，计件的输入框默认填入原本的值

            System.out.println("shi计件------");
            clickJijianbtn(fjijians,fjizhongs,jijian_btns,jizhong_btns);
            System.out.println("---件数---" + dataInfo.getjianshu());
            System.out.println("---单价---" + dataInfo.getdanjia());

            jijian.setText(dataInfo.getjianshu());
            danjia.setText(dataInfo.getdanjia());
            jizhong.setText("");
        } else {
            //表示计重按钮自动被选中，计件不能被选中。
            //同时单价，计重的输入......
            System.out.println("shi计重------");
            System.out.println("---重量---" + dataInfo.getzhongliang());
            System.out.println("---单价---" + dataInfo.getdanjia());
            clickJizhongbtn(fjijians,fjizhongs,jijian_btns,jizhong_btns);

            jijian.setText("");
            danjia.setText(dataInfo.getdanjia());
            jizhong.setText(dataInfo.getzhongliang());
        }

    }


    public void clickJijianbtn(FrameLayout framelayout_jijian,
                               FrameLayout framlayout_jizhong,
                               Button jijian_btn,
                               Button jizhong_btn
    ) {
        apps.setJijianbtn(true);
        framelayout_jijian.setVisibility(View.VISIBLE);
        framlayout_jizhong.setVisibility(View.GONE);

        jijian_btn.setBackgroundResource(R.drawable.ripple_bg_jijian);
        jijian_btn.setTextColor(Color.parseColor("#ff00796b"));

        jizhong_btn.setBackgroundResource(R.drawable.ripple_bg_jizhong);
        jizhong_btn.setTextColor(Color.parseColor("#8a000000"));

    }


    public void clickJizhongbtn(FrameLayout framelayout_jijian,
                                FrameLayout framlayout_jizhong,
                                Button jijian_btn,
                                Button jizhong_btn) {
        apps.setJijianbtn(false);
        framelayout_jijian.setVisibility(View.GONE);
        framlayout_jizhong.setVisibility(View.VISIBLE);

        jizhong_btn.setBackgroundResource(R.drawable.ripple_bg_jijian);
        jizhong_btn.setTextColor(Color.parseColor("#ff00796b"));

        jijian_btn.setBackgroundResource(R.drawable.ripple_bg_jizhong);
        jijian_btn.setTextColor(Color.parseColor("#8a000000"));
    }

}
