package com.example.bleweight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bleweight.adapter.BillRecyclerAdapter;
import com.example.bleweight.adapter.GukeAdapter;
import com.example.bleweight.adapter.ProductRecyclerAdapter;
import com.example.bleweight.utils.BillBtnclick;
import com.example.bleweight.utils.OrderPage;
import com.example.bleweight.utils.XToastUtils;
import com.example.bleweight.utils.data.RecyclerItemDataProvider;
import com.example.bleweight.utils.data.productAddDataInfo;
import com.example.bleweight.utils.modeldataPage;
import com.xuexiang.xui.utils.WidgetUtils;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BillActivity extends AppCompatActivity {
    Button bill_style_mobile;
    Button bill_style_cash;
    Button bill_style_shezhang;
    RecyclerView recycler_guke;

    List<String> gukeListdata = new ArrayList<>();

    SwipeRecyclerView recycler_view_bill;
    private BillRecyclerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        initView();
        setClick();
        new modeldataPage().setGukeListdata(gukeListdata);
    }



    private void initView() {
//        gukeListdata.add("李书行");
//        gukeListdata.add("廖冰");
//        gukeListdata.add("刘波");
//        gukeListdata.add("王三毛");
//        gukeListdata.add("陈炜");
//        gukeListdata.add("刘鹏");
//        gukeListdata.add("郝波");
//        gukeListdata.add("黄铖");
//        gukeListdata.add("王名");
//        gukeListdata.add("黎梦");
//        gukeListdata.add("吴燕飞");
//        gukeListdata.add("燕家云");
//        gukeListdata.add("康圆融");
//        new modeldataPage().setGukeListdata(gukeListdata);

        bill_style_mobile = findViewById(R.id.bill_style_mobile);
        bill_style_cash = findViewById(R.id.bill_style_cash);
        bill_style_shezhang = findViewById(R.id.bill_style_shezhang);

        recycler_guke = findViewById(R.id.recycler_guke);

        recycler_view_bill = findViewById(R.id.recycler_view_bill);
        WidgetUtils.initRecyclerView(recycler_view_bill);
        recycler_view_bill.setAdapter(mAdapter = new BillRecyclerAdapter());

    }

    private void setClick() {

        BillBtnclick billBtn = new BillBtnclick(bill_style_mobile, bill_style_cash, bill_style_shezhang);
        bill_style_mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billBtn.clickbtnMobile();

            }
        });

        bill_style_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billBtn.clickbtnCash();


            }
        });

        bill_style_shezhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billBtn.clickShezhang();


            }
        });
        System.out.println("------:"+new modeldataPage().getGukeListdata().size());

        GukeAdapter mRecyclerAdapter = new GukeAdapter();
        System.out.println("------:"+new modeldataPage().getGukeListdata().size());

        for (int i = 0; i < new modeldataPage().getGukeListdata().size(); i++) {
            System.out.println("------:"+new modeldataPage().getGukeListdata().get(i));
        }

        //recyclerview
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_guke.setLayoutManager(layoutManager);
        recycler_guke.setAdapter(mRecyclerAdapter);

        String whichordername = OrderPage.getOrderList().get(0);
        List<productAddDataInfo> listdatapro = RecyclerItemDataProvider.getAllOrderData().get(whichordername);
            //数据刷新
        mAdapter.refresh(listdatapro);


        mRecyclerAdapter.setOnItemMyClickListener(new GukeAdapter.OnItemMyClickListener() {
            @Override
            public void onItemClick(View view, int position) {




            }
        });




    }
}
