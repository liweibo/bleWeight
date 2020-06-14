package com.example.bleweight.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bleweight.MainActivity;
import com.example.bleweight.MyApplication;
import com.example.bleweight.R;
import com.example.bleweight.adapter.ProductRecyclerAdapter;
import com.example.bleweight.utils.OrderPage;
import com.example.bleweight.utils.XToastUtils;
import com.example.bleweight.utils.data.RecyclerItemDataProvider;
import com.example.bleweight.utils.data.productAddDataInfo;
import com.google.android.material.tabs.TabLayout;
import com.kongzue.dialog.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialog.util.BaseDialog;
import com.kongzue.dialog.util.DialogSettings;
import com.kongzue.dialog.v3.MessageDialog;
import com.xuexiang.xui.utils.WidgetUtils;
import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.List;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;


public class OrderNoProductFragment extends Fragment {
    MyApplication apps;
    TabLayout tab_layout;

    //没有商品时的girl图像；
    LinearLayout ll_girl_no_product;
    //有商品时recyclerview
    LinearLayout ll_have_product_recycler;
    SwipeRecyclerView recycler_view_have_prod;
    public ProductRecyclerAdapter mAdapter;
    Button new_order_firstpage;
    private Handler mHandler = new Handler();
    private boolean mEnableLoadMore;
    public int currentSelectTab = -1;
    public Button btn_delete_order;
    public Button btn_piliang_deal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order_no_product, container, false);
        apps = (MyApplication) getActivity().getApplication();
        initviews(v);
        clickViews();
        System.out.println("--每次来都会调用？？？？？");

        return v;
    }


    public void initviews(View v) {
        tab_layout = v.findViewById(R.id.tab_layout_order);

        currentSelectTab = 0;//只要进入该界面，表示一定有订单1，在没有点击继续新建时，设为0即可
        apps.setCurrentTabIndex(currentSelectTab);
        int orderListLen = OrderPage.getOrderList().size();
        if (orderListLen == 0) {

            if (((MainActivity) getActivity()).haveNeworder) {
                OrderPage.addOneOrder();
                tab_layout.addTab(tab_layout.newTab().setText(OrderPage.getOrderList().get(0)));

            }

        } else {
            //tab
            for (String page : OrderPage.getOrderList()) {
                tab_layout.addTab(tab_layout.newTab().setText(page));
            }
        }

        tab_layout.setTabMode(MODE_SCROLLABLE);


        ll_girl_no_product = v.findViewById(R.id.ll_girl_no_product);
        //recyclerview
        recycler_view_have_prod = v.findViewById(R.id.recycler_view_have_prod);


        new_order_firstpage = v.findViewById(R.id.new_order_firstpage_haveorder);
        ll_have_product_recycler = v.findViewById(R.id.ll_have_product_recycler);

        btn_delete_order = v.findViewById(R.id.btn_delete_order);
        btn_piliang_deal = v.findViewById(R.id.btn_piliang_deal);


        showTotalPriceUI();//进入该界面时，判断当前tab下是否有商品，有则显示，无则不显示。

    }


    public void showTotalPriceUI() {
        String whichordername = OrderPage.getOrderList().get(apps.getCurrentTabIndex());
        List<productAddDataInfo> listdatapro = RecyclerItemDataProvider.getAllOrderData().get(whichordername);
        if (listdatapro.size() > 0) {//有商品
            setGirlGone();
            setLLHaveProd();
            //数据刷新
            mAdapter.refresh(listdatapro);
            //有商品才显示 底部总价部分
            ((MainActivity) getActivity()).crdview_zongjia.setVisibility(View.VISIBLE);

            //有商品时，显示总价按钮的 客户名：客户1，客户2....显示总价计算结果
            showTotalPriceAndKehu(listdatapro, whichordername);

        } else {//无商品
            setGirlVisi();
            setLLHaveProdGone();

            //没有商品，不显示底部总价部分
            ((MainActivity) getActivity()).crdview_zongjia.setVisibility(View.GONE);

        }
    }

    private void showTotalPriceAndKehu(List<productAddDataInfo> listdatapro, String whichordername) {

        int lenstr = whichordername.length();
        String kehuname = "客户";
        String totalPriceStr = "88";
        Double totalPriceInt = 0.00;
        if (lenstr > 2) {
            String intVa2 = whichordername.substring(0, 2);//截取出 订单 字样。
            String intStr = whichordername.replace(intVa2, "");//将 订单字样用""替换
            System.out.println("kehu2::" + intStr);
            int strToint = Integer.parseInt(intStr);
            kehuname = "客户" + strToint;
            System.out.println("kehu::" + kehuname);
        }

        //计算某个订单的总价
        for (int i = 0; i < listdatapro.size(); i++) {
            String xioaji = listdatapro.get(i).getXiaoji();
            Double xaiojiDou = Double.parseDouble(xioaji);
            totalPriceInt+=xaiojiDou;
        }
        totalPriceStr =totalPriceInt+"";

        //展示总价与客户名
        ((MainActivity) getActivity()).tv_kehu_name.setText(kehuname);
        ((MainActivity) getActivity()).tv_total_price.setText(totalPriceStr);

    }

    private void clickViews() {
        WidgetUtils.initRecyclerView(recycler_view_have_prod);

        //必须在setAdapter之前调用
        recycler_view_have_prod.setSwipeMenuCreator(swipeMenuCreator);
        //必须在setAdapter之前调用
        recycler_view_have_prod.setOnItemMenuClickListener(mMenuItemClickListener);

        LinearLayout top_on_left = ((MainActivity) getActivity()).top_on_left;
        View layout_right_mengban = ((MainActivity) getActivity()).layout_right_mengban;
        LinearLayout tv_status_right_top = ((MainActivity) getActivity()).tv_status_right_top;
        TextView click_pro_tv = ((MainActivity) getActivity()).click_pro_tv;

        EditText text_input_danjia = ((MainActivity) getActivity()).text_input_danjia;
        EditText text_input_jianshu = ((MainActivity) getActivity()).text_input_jianshu;
        EditText text_input_zhongliang = ((MainActivity) getActivity()).text_input_zhongliang;

        FrameLayout framelayout_jijian = ((MainActivity) getActivity()).framelayout_jijian;
        FrameLayout framlayout_jizhong = ((MainActivity) getActivity()).framlayout_jizhong;
        Button jijian_btn = ((MainActivity) getActivity()).jijian_btn;
        Button jizhong_btn = ((MainActivity) getActivity()).jizhong_btn;

        recycler_view_have_prod.setAdapter(mAdapter = new ProductRecyclerAdapter(
                top_on_left, layout_right_mengban, tv_status_right_top,
                click_pro_tv, text_input_jianshu,
                text_input_zhongliang,
                text_input_danjia,
                framelayout_jijian,
                framlayout_jizhong,
                jijian_btn,
                jizhong_btn
                , apps
        ));

        //新建订单
        new_order_firstpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //生成订单；并生成该订单对应的list，用于存订单数据
                OrderPage.addOneOrder();
                int size = OrderPage.getOrderList().size();
                //tab
                tab_layout.addTab(tab_layout.newTab().setText(OrderPage.getOrderList().get(size - 1)));
                //选中最后一个tab订单即新建订单
                tab_layout.selectTab(tab_layout.getTabAt(size - 1));
                currentSelectTab = size - 1;
                apps.setCurrentTabIndex(currentSelectTab);

            }
        });

//删除订单
        btn_delete_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //知道是哪个tab订单，再调用tab删除即可，弹出确认框
                final String canDelestr = OrderPage.deleteOneOrderNotReal(currentSelectTab);

                if (canDelestr.equals("")) {
                    XToastUtils.error("当前没有订单可删除哦~");
                } else {
                    MessageDialog.build((AppCompatActivity) getActivity())
                            .setStyle(DialogSettings.STYLE.STYLE_IOS)
                            .setTheme(DialogSettings.THEME.LIGHT)
                            .setTitle("提示")
                            .setMessage("确认删除:" + canDelestr + " ？")
                            .setOkButton("确认", new OnDialogButtonClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.N)
                                @Override
                                public boolean onClick(BaseDialog baseDialog, View v) {
                                    OrderPage.deleteOneOrder(currentSelectTab);
                                    tab_layout.removeTab(tab_layout.getTabAt(currentSelectTab));
                                    if (OrderPage.getOrderList().size() == 0) {
                                        //每次删除都判断是否没有订单了，若出现没有订单的情况,展示girl图片

                                        setGirlVisi();
                                        setLLHaveProdGone();

                                        //跳转到最开始的那个新建页面
                                        ((MainActivity) getActivity()).showNewOrderMan();
                                        ((MainActivity) getActivity()).haveNeworder = false;
                                        ((MainActivity) getActivity()).crdview_zongjia.setVisibility(View.GONE);

                                    }
                                    return false;
                                }


                            })
                            .setCancelButton("取消", new OnDialogButtonClickListener() {
                                @Override
                                public boolean onClick(BaseDialog baseDialog, View v) {
                                    return false;
                                }


                            })
                            .show();
                }


            }
        });
//批量操作
        btn_piliang_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                currentSelectTab = tab.getPosition();
                apps.setCurrentTabIndex(currentSelectTab);

                System.out.println("======" + tab.getText());

                //选定tab时，根据tab值，显示对应tab的list商品列表
                //判断当前tab下的list商品是否有值，无则显示girl图片，有则显示列表
                showTotalPriceUI();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void setGirlGone() {
        ll_girl_no_product.setVisibility(View.GONE);
    }

    public void setGirlVisi() {
        ll_girl_no_product.setVisibility(View.VISIBLE);
    }

    public void setLLHaveProd() {
        ll_have_product_recycler.setVisibility(View.VISIBLE);
    }

    public void setLLHaveProdGone() {
        ll_have_product_recycler.setVisibility(View.GONE);
    }


    /**
     * 菜单创建器，在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int position) {
            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);
            // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
            // 2. 指定具体的高，比如80;
            // 3. WRAP_CONTENT，自身高度，不推荐;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;

            // 添加右侧的，如果不添加，则右侧不会出现菜单。
            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(getContext()).setBackground(R.drawable.menu_selector_red)
                        .setImage(R.mipmap.ic_swipe_menu_delete)
                        .setText("删除")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。
            }
        }
    };

    /**
     * RecyclerView的Item的Menu点击监听。
     */
    private OnItemMenuClickListener mMenuItemClickListener = new OnItemMenuClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge, int position) {
            menuBridge.closeMenu();

            int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
            int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。

            if (direction == SwipeRecyclerView.RIGHT_DIRECTION) {
                XToastUtils.toast("list第" + position + "; 右侧菜单第" + menuPosition);
            } else if (direction == SwipeRecyclerView.LEFT_DIRECTION) {
                XToastUtils.toast("list第" + position + "; 左侧菜单第" + menuPosition);
            }
        }
    };


    //接口回调
    public void getEditText(CallBack callBack) {
//        String msg = editText.getText().toString();
        String msg = "";
        callBack.getResult(msg);
    }

    public interface CallBack {
        public void getResult(String result);
    }


    //广播接收

    RecyProdRefreshBroadcastRecei rece;

    @Override
    public void onResume() {
        super.onResume();
        rece = new RecyProdRefreshBroadcastRecei();
        getActivity().registerReceiver(rece,
                new IntentFilter("com.ble.weight"));

    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(rece);
    }


    public class RecyProdRefreshBroadcastRecei extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            setGirlGone();
            setLLHaveProd();

            //监听到广播后，数据刷新 并显示总价ui部分
            showTotalPriceUI();


        }
    }
}
