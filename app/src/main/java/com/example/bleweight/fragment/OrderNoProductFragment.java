package com.example.bleweight.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.bleweight.MainActivity;
import com.example.bleweight.MyApplication;
import com.example.bleweight.R;
import com.example.bleweight.adapter.ProductRecyclerAdapter;
import com.example.bleweight.utils.MaterialLoadMoreView;
import com.example.bleweight.utils.OrderPage;
import com.example.bleweight.utils.XToastUtils;
import com.example.bleweight.utils.data.RecyclerItemDataProvider;
import com.google.android.material.tabs.TabLayout;
import com.xuexiang.xui.utils.WidgetUtils;
import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

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
    private SwipeRefreshLayout swipeRefreshLayout;
    private Handler mHandler = new Handler();
    private boolean mEnableLoadMore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order_no_product, container, false);
        apps = (MyApplication)getActivity().getApplication();
        initviews(v);
        clickViews();
        return v;
    }


    public void initviews(View v) {
        tab_layout = v.findViewById(R.id.tab_layout_order);
        //tab
        for (String page : OrderPage.getPageNames()) {
            tab_layout.addTab(tab_layout.newTab().setText(page));
        }
        tab_layout.setTabMode(MODE_SCROLLABLE);
        tab_layout.addOnTabSelectedListener((MainActivity) getActivity());


        ll_girl_no_product = v.findViewById(R.id.ll_girl_no_product);
        //recyclerview
        recycler_view_have_prod = v.findViewById(R.id.recycler_view_have_prod);

        swipeRefreshLayout = v.findViewById(R.id.swipe_refresh_layout_havaorder);
        swipeRefreshLayout.setColorSchemeColors(0xff0099cc, 0xffff4444, 0xff669900, 0xffaa66cc, 0xffff8800);

        new_order_firstpage = v.findViewById(R.id.new_order_firstpage_haveorder);
        ll_have_product_recycler = v.findViewById(R.id.ll_have_product_recycler);
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

        recycler_view_have_prod.setAdapter(mAdapter = new ProductRecyclerAdapter(
                top_on_left,layout_right_mengban,tv_status_right_top,click_pro_tv,
                apps
        ));

        new_order_firstpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGirlGone();
                setLLHaveProd();
                //加载recycler上展示的数据
                mAdapter.refresh(RecyclerItemDataProvider.getZhongxinfachuListNewInfos());

            }
        });

        // 刷新监听。
        swipeRefreshLayout.setOnRefreshListener(mRefreshListener);
        refresh();


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


    /**
     * 刷新。
     */
    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            loadData();
        }
    };

    private void refresh() {
        swipeRefreshLayout.setRefreshing(true);
        loadData();
    }

    private void loadData() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.refresh(RecyclerItemDataProvider.getZhongxinfachuListNewInfos());
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                enableLoadMore();
            }
        }, 1000);
    }

    /**
     * 确保有数据加载了才开启加载更多
     */
    private void enableLoadMore() {
        if (recycler_view_have_prod != null && !mEnableLoadMore) {
            mEnableLoadMore = true;
            useMaterialLoadMore();
            // 加载更多的监听。
            recycler_view_have_prod.setLoadMoreListener(mLoadMoreListener);
            recycler_view_have_prod.loadMoreFinish(false, true);
        }
    }

    private void useMaterialLoadMore() {
        MaterialLoadMoreView loadMoreView = new MaterialLoadMoreView(getContext());
        recycler_view_have_prod.addFooterView(loadMoreView);
        recycler_view_have_prod.setLoadMoreView(loadMoreView);
    }

    /**
     * 加载更多。
     */
    private SwipeRecyclerView.LoadMoreListener mLoadMoreListener = new SwipeRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdapter.loadMore(RecyclerItemDataProvider.getZhongxinfachuListNewInfos());
                    if (recycler_view_have_prod != null) {
                        recycler_view_have_prod.loadMoreFinish(false, true);
                    }
                }
            }, 1000);
        }
    };


}
