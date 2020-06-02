package com.example.bleweight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bleweight.adapter.PiciProductAdapter;
import com.example.bleweight.fragment.BlankOrderFragment;
import com.example.bleweight.fragment.OrderComputeFragment;
import com.example.bleweight.fragment.OrderNoProductFragment;
import com.example.bleweight.utils.MultiPage;
import com.example.bleweight.utils.XToastUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.utils.StatusBarUtils;
import com.xuexiang.xui.widget.button.RippleView;
import com.xuexiang.xui.widget.spinner.materialspinner.MaterialSpinner;
import com.xuexiang.xui.widget.toast.XToast;
import com.example.bleweight.utils.modeldataPage;
import com.yanzhenjie.recyclerview.OnItemClickListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, TabLayout.OnTabSelectedListener {
    TextView tvOne, tvTwo, tvThree, tvFour, tvFive, tvSix, tvSeven, tvEight, tvNine, tvZero,
            tvNums, tvZhekou, tvPrice, tvPlusjian, tvDot;
    ImageView tvDele;
    EditText etInput;
    EditText text_input_danjia;
    EditText text_input_jianshu;
    EditText text_input_zhongliang;
    SharedPreferences.Editor editor;
    RippleView btnLabel;

    TabLayout tab_layout;
    MaterialSpinner mMaterialSpinner;

    RecyclerView recycler_product;

    LinearLayout ll_allFragment;
    PiciProductAdapter mRecyclerAdapter;
    PiciProductAdapter mTwoRecyclerAdapter;
    Button btn_new_order;

    private Fragment currentFragment = new Fragment();
    private List<Fragment> fragments = new ArrayList<>();
    public int currentIndex = 0;
    //当前显示的fragment
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    private LinearLayout top_on_left;
    private LinearLayout main_left;
    private LinearLayout ll_top_on_right;
    private LinearLayout tv_status_right_top;
    private LinearLayout ll_close_bggray;

    CardView card_view_product;
    private FloatingActionButton fab_close;
    private MaterialSpinner spinner_material;
    FrameLayout framelayout_jijian;
    FrameLayout framlayout_jizhong;
    Button jijian_btn;
    Button jizhong_btn;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        StatusBarUtils.fullScreen(this);

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        if (savedInstanceState != null) { // “内存重启”时调用
            System.out.println("非正常启动");
            //获取“内存重启”时保存的索引下标
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT, 0);
            //注意，添加顺序要跟下面添加的顺序一样！！！！
            fragments.removeAll(fragments);
            fragments.add(fragmentManager.findFragmentByTag(0 + ""));
            fragments.add(fragmentManager.findFragmentByTag(1 + ""));
            fragments.add(fragmentManager.findFragmentByTag(2 + ""));
            //恢复fragment页面
            restoreFragment();
        } else {      //正常启动时调用]sout
            System.out.println("正常启动。。。。。。");
            fragments.add(new BlankOrderFragment());
            fragments.add(new OrderNoProductFragment());
            fragments.add(new OrderComputeFragment());

            showFragment();
        }


        findVIew();
        sysKeyBoard(text_input_danjia);
        sysKeyBoard(text_input_zhongliang);
        sysKeyBoard(text_input_jianshu);
        setClick();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        //“内存重启”时保存当前的fragment名字
        outState.putInt(CURRENT_FRAGMENT, currentIndex);
        super.onSaveInstanceState(outState);
    }


    private void sysKeyBoard(EditText xxx) {
        // 设置不调用系统键盘
        if (Build.VERSION.SDK_INT <= 10) {

            xxx.setInputType(InputType.TYPE_NULL);
        } else {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(xxx, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setClick() {
//        int tvHei = getTvheight();
//        float textHeight = (float) ((34 + 0.00000007) / 0.7535);
//        System.out.println("textHeight:"+textHeight);
//        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) findViewById(R.id.ll_cheng_kg).getLayoutParams();
//        linearParams.height = (int) textHeight;
//btn_new_order.setOnClickListener(this);
//        tvOne.setOnClickListener(this);
//        tvTwo.setOnClickListener(this);
//        tvThree.setOnClickListener(this);
//        tvFour.setOnClickListener(this);
//        tvSix.setOnClickListener(this);
//        tvFive.setOnClickListener(this);
//        tvSeven.setOnClickListener(this);
//        tvEight.setOnClickListener(this);
//        tvNine.setOnClickListener(this);
//        tvZero.setOnClickListener(this);
//        tvPlusjian.setOnClickListener(this);
//        tvNums.setOnClickListener(this);
//        tvDot.setOnClickListener(this);
//        tvPrice.setOnClickListener(this);
//        tvZhekou.setOnClickListener(this);
//        tvDele.setOnClickListener(this);
    }

    public void findVIew() {
        editor = MainActivity.this.getSharedPreferences
                ("selectSpecialbtn", MODE_PRIVATE).edit();

        ll_allFragment = findViewById(R.id.frag);

//        etInput = findViewById(R.id.et_input);
//        tvOne = findViewById(R.id.tv_one);
//        tvTwo = findViewById(R.id.tv_two);
//        tvThree = findViewById(R.id.tv_three);
//        tvFour = findViewById(R.id.tv_four);
//        tvFive = findViewById(R.id.tv_five);
//        tvSix = findViewById(R.id.tv_six);
//        tvSeven = findViewById(R.id.tv_seven);
//        tvEight = findViewById(R.id.tv_eight);
//        tvNine = findViewById(R.id.tv_nine);
//        tvZero = findViewById(R.id.tv_zero);
//        tvNums = findViewById(R.id.tv_nums);
//        tvPrice = findViewById(R.id.tv_price);
//        tvZhekou = findViewById(R.id.tv_zhekou);
//        tvPlusjian = findViewById(R.id.tv_plus_jian);
//        tvDot = findViewById(R.id.tv_numdot);
//        tvDele = findViewById(R.id.iv_delete);
//        btnLabel = findViewById(R.id.btn_label);
//        numsBackground();//默认选中 "数量" 的背景为蓝色；
        mMaterialSpinner = findViewById(R.id.spinner);

        //tab
        tab_layout = findViewById(R.id.tab_layout);

        //商品
        recycler_product = findViewById(R.id.recycler_product);
        top_on_left = findViewById(R.id.top_on_left);
        ll_top_on_right = findViewById(R.id.ll_top_on_right);
        tv_status_right_top = findViewById(R.id.tv_status_right_top);
        main_left = findViewById(R.id.main_left);
        card_view_product = findViewById(R.id.card_view_product);
        fab_close = findViewById(R.id.fab_close);
        spinner_material = findViewById(R.id.spinner_material);
        framelayout_jijian = findViewById(R.id.framelayout_jijian);
        framlayout_jizhong = findViewById(R.id.framlayout_jizhong);
        jijian_btn = findViewById(R.id.jijian_btn);
        jizhong_btn = findViewById(R.id.jizhong_btn);

        text_input_danjia = findViewById(R.id.text_input_danjia);
        text_input_zhongliang = findViewById(R.id.text_input_zhongliang);
        text_input_jianshu = findViewById(R.id.text_input_jianshu);

        initviews();

         //默认是计件
        framelayout_jijian.setVisibility(View.VISIBLE);
        framlayout_jizhong.setVisibility(View.GONE);

        findViewById(R.id.tv_zongdian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fab_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XToastUtils.toast("666");
            }
        });
        spinner_material.setOnItemSelectedListener(
                new MaterialSpinner.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                        XToastUtils.success("选择了：" + item.toString());
                    }
                }
        );

        //点击计重按钮
        jizhong_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                framelayout_jijian.setVisibility(View.GONE);
                framlayout_jizhong.setVisibility(View.VISIBLE);

                jizhong_btn.setBackgroundResource(R.drawable.ripple_bg_jijian);
                jizhong_btn.setTextColor(Color.parseColor("#ff00796b"));

                jijian_btn.setBackgroundResource(R.drawable.ripple_bg_jizhong);
                jijian_btn.setTextColor(Color.parseColor("#8a000000"));
            }
        });
        //点击计件按钮
        jijian_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                framelayout_jijian.setVisibility(View.VISIBLE);
                framlayout_jizhong.setVisibility(View.GONE);

                jijian_btn.setBackgroundResource(R.drawable.ripple_bg_jijian);
                jijian_btn.setTextColor(Color.parseColor("#ff00796b"));

                jizhong_btn.setBackgroundResource(R.drawable.ripple_bg_jizhong);
                jizhong_btn.setTextColor(Color.parseColor("#8a000000"));


            }
        });

        //获取屏幕宽度
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int width2 = wm.getDefaultDisplay().getWidth();
        int height2 = wm.getDefaultDisplay().getHeight();
        //设置阴影蒙版的宽度，高度为整个屏幕的高度。
//        top_on_left.setWidth((int) ((width2 * 0.667) ));
//        ll_top_on_right.setWidth((int) ((width2 * 0.334) ));
//        tv_status_right_top.setWidth((int) ((width2 * 0.334) ));
        top_on_left.setMinimumWidth((int) ((width2 * 0.667)));
        ll_top_on_right.setMinimumWidth((int) (width2 * 0.334));
        tv_status_right_top.setMinimumWidth((int) (width2 * 0.334));

    }


    public void initviews() {

        mRecyclerAdapter = new PiciProductAdapter(this,
                modeldataPage.getIconA(), modeldataPage.getProductTv());
        mTwoRecyclerAdapter = new PiciProductAdapter(this,
                modeldataPage.getIconPiciTwoA(), modeldataPage.getProductPicitwoTv());

        //tab
        for (String page : MultiPage.getPageNames()) {
            tab_layout.addTab(tab_layout.newTab().setText(page));
        }
        tab_layout.setTabMode(MODE_SCROLLABLE);
        tab_layout.addOnTabSelectedListener(MainActivity.this);

        //spinner
        mMaterialSpinner.setItems(ResUtils.getStringArray(R.array.sort_mode_entry));
        mMaterialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner spinner, int position, long id, Object item) {
                StatusBarUtils.fullScreen(MainActivity.this);
                SnackbarUtils.Long(spinner, "选中： " + item).show();
            }
        });
        mMaterialSpinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {
            @Override
            public void onNothingSelected(MaterialSpinner spinner) {
                StatusBarUtils.fullScreen(MainActivity.this);

                SnackbarUtils.Long(spinner, "没有选中").show();
            }
        });
        mMaterialSpinner.setSelectedIndex(0);
//        mMaterialSpinner.setSelectedItem("综合排序");


        //recyclerview
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_product.setLayoutManager(layoutManager);
        recycler_product.setAdapter(mRecyclerAdapter);

        mRecyclerAdapter.setOnItemMyClickListener(new PiciProductAdapter.OnItemMyClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                XToastUtils.success("点击了位置：" + position);

            }
        });


        recycler_product.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {

            }
        });


    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {


//        switch (v.getId()) {
//            case R.id.tv_one:
//                //表示按了0之后，后面的只能按. 不能按1-9的数字
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("1");
//
//                break;
//
//            case R.id.tv_two:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("2");
//
//                break;
//
//            case R.id.tv_three:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("3");
//
//
//                break;
//
//            case R.id.tv_four:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("4");
//
//
//                break;
//
//            case R.id.tv_five:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("5");
//
//                break;
//
//            case R.id.tv_six:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("6");
//
//                break;
//
//            case R.id.tv_seven:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("7");
//
//                break;
//
//            case R.id.tv_eight:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("8");
//
//                break;
//
//            case R.id.tv_nine:
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                clickNum("9");
//
//                break;
//
//            case R.id.tv_zero:
//                // 第一个数字按下0的话，第二个数字只能按小数点
//                if ("0".equals(etInput.getText().toString().trim())) {
//                    break;
//                }
//                etInput.setText(etInput.getText().toString().trim() + "0");
//                etInput.setSelection(etInput.getText().length());
//                break;
//
//            case R.id.tv_numdot:
//                //第一个字符不能按 小数点
//                String mynumdot = etInput.getText().toString().trim();
//                if (mynumdot.length() == 0) {
//                    break;
//                }
//                onlyOneDot(mynumdot);
//                break;
//
//            case R.id.tv_nums:
//                numsBackground();
//                break;
//
//            case R.id.tv_price:
//                priceBackground();
//                break;
//
//            case R.id.tv_zhekou:
//                zhekouBackground();
//                break;
//
//            case R.id.tv_plus_jian:
//                plusjianBackground();
//                break;
//
//            case R.id.iv_delete:
//                String numde = etInput.getText().toString().trim();
//                if (numde.length() > 0) {
//                    etInput.setText(numde.substring(0, numde.length() - 1));
//                    etInput.setSelection(etInput.getText().length());
//                }
//                break;
////            case R.id.btn_label:
////                System.out.println("=====----");
////                break;
//
//        }

    }

//    public void numsBackground() {
//        editor.putInt("selectOne", 0);
//        editor.commit();
//        tvNums.setBackgroundResource(R.drawable.textview_border_special_btn);
//        tvPrice.setBackgroundResource(R.drawable.textview_border);
//        tvZhekou.setBackgroundResource(R.drawable.textview_border);
//        tvPlusjian.setBackgroundResource(R.drawable.textview_border);
//    }
//
//    public void priceBackground() {
//        editor.putInt("selectOne", 1);
//        editor.commit();
//        tvNums.setBackgroundResource(R.drawable.textview_border);
//        tvPrice.setBackgroundResource(R.drawable.textview_border_special_btn);
//        tvZhekou.setBackgroundResource(R.drawable.textview_border);
//        tvPlusjian.setBackgroundResource(R.drawable.textview_border);
//    }
//
//    public void zhekouBackground() {
//        editor.putInt("selectOne", 2);
//        editor.commit();
//        tvNums.setBackgroundResource(R.drawable.textview_border);
//        tvPrice.setBackgroundResource(R.drawable.textview_border);
//        tvZhekou.setBackgroundResource(R.drawable.textview_border_special_btn);
//        tvPlusjian.setBackgroundResource(R.drawable.textview_border);
//    }
//
//    public void plusjianBackground() {
//        editor.putInt("selectOne", 3);
//        editor.commit();
//        tvNums.setBackgroundResource(R.drawable.textview_border);
//        tvPrice.setBackgroundResource(R.drawable.textview_border);
//        tvZhekou.setBackgroundResource(R.drawable.textview_border);
//        tvPlusjian.setBackgroundResource(R.drawable.textview_border_special_btn);
//    }
//
//    public void onlyOneDot(String mynumdot) {
//        if (mynumdot.length() > 0 && (mynumdot.subSequence(0, 1).equals("."))) {
//            etInput.setText("");
//        }
//        if (!mynumdot.contains(".")) {
//            mynumdot += ".";
//            etInput.setText(mynumdot);
//            etInput.setSelection(etInput.getText().length());
//        }
//
//    }
//
//    public void clickNum(String num) {
//        etInput.setText(etInput.getText().toString().trim() + num);
//        etInput.setSelection(etInput.getText().length());
//    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getText().equals("批次2")) {
            recycler_product.setAdapter(mTwoRecyclerAdapter);
            mTwoRecyclerAdapter.setOnItemMyClickListener(new PiciProductAdapter.OnItemMyClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    XToastUtils.success("two点击了位置：" + position);

                }
            });
        } else if (tab.getText().equals("批次1")) {

            recycler_product.setAdapter(mRecyclerAdapter);
            mRecyclerAdapter.setOnItemMyClickListener(new PiciProductAdapter.OnItemMyClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    XToastUtils.success("点击了位置：" + position);

                }
            });
        } else {
            recycler_product.setAdapter(mTwoRecyclerAdapter);
            mRecyclerAdapter.setOnItemMyClickListener(new PiciProductAdapter.OnItemMyClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    XToastUtils.success("another点击了位置：" + position);

                }
            });
        }

        XToastUtils.success(tab.getText());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    public void showNoProduct() {
        currentIndex = 1;
        showFragment();
    }


    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    public void showFragment() {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragments.get(currentIndex) != null) {

            //如果之前没有添加过
            if (!fragments.get(currentIndex).isAdded()) {
                System.out.println("9999999999" + currentFragment);
                transaction
                        .hide(currentFragment)
                        .add(R.id.frag, fragments.get(currentIndex), "" + currentIndex);  //第三个参数为添加当前的fragment时绑定一个tag

            } else {
                transaction
                        .hide(currentFragment)
                        .show(fragments.get(currentIndex));
            }

            currentFragment = fragments.get(currentIndex);

            transaction.commit();
        }


    }


    /**
     * 恢复fragment
     */
    private void restoreFragment() {
        FragmentTransaction mBeginTreansaction = fragmentManager.beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {

            if (i == currentIndex) {
                if (fragments.get(i) != null)

                    mBeginTreansaction.show(fragments.get(i));
            } else {
                System.out.println("-=-=:" + fragments.get(i));
                if (fragments.get(i) != null)
                    mBeginTreansaction.hide(fragments.get(i));
            }

        }

        mBeginTreansaction.commit();

        //把当前显示的fragment记录下来
        currentFragment = fragments.get(currentIndex);

    }


}
