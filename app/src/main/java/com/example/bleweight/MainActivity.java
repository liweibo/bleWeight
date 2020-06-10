package com.example.bleweight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
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
import com.example.bleweight.utils.computeutil;
import com.example.bleweight.utils.data.RecyclerItemDataProvider;
import com.example.bleweight.utils.data.productAddDataInfo;
import com.example.bleweight.utils.modeldataPage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.utils.StatusBarUtils;
import com.xuexiang.xui.widget.button.RippleView;
import com.xuexiang.xui.widget.spinner.materialspinner.MaterialSpinner;

import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, TabLayout.OnTabSelectedListener {
    Button tvOne, tvTwo, tvThree, tvFour, tvFive, tvSix, tvSeven, tvEight, tvNine, tvZero, tvDot;
    ImageButton tvDele;
    MyApplication apps;
    EditText etInput;
    public EditText text_input_danjia;
    public EditText text_input_jianshu;
    public EditText text_input_zhongliang;
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
    public LinearLayout top_on_left;
    private LinearLayout main_left;
    public LinearLayout ll_top_on_right;
    public LinearLayout tv_status_right_top;
    private LinearLayout ll_close_bggray;

    CardView card_view_product;
    private FloatingActionButton fab_close;
    private MaterialSpinner spinner_material;
    public  FrameLayout framelayout_jijian;
    public FrameLayout framlayout_jizhong;
    public Button jijian_btn;
    public Button jizhong_btn;

    FloatingActionButton fab_confirmbtn;
    public View layout_right_mengban;
    public TextView click_pro_tv;
    public int clickLeftRecyProItem = -1;

    public boolean haveNeworder = false;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        StatusBarUtils.fullScreen(this);
        apps = (MyApplication) getApplication();
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

        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        tvFour.setOnClickListener(this);
        tvSix.setOnClickListener(this);
        tvFive.setOnClickListener(this);
        tvSeven.setOnClickListener(this);
        tvEight.setOnClickListener(this);
        tvNine.setOnClickListener(this);
        tvZero.setOnClickListener(this);
        tvDot.setOnClickListener(this);
        tvDele.setOnClickListener(this);


    }

    public void findVIew() {
        editor = MainActivity.this.getSharedPreferences
                ("selectSpecialbtn", MODE_PRIVATE).edit();

        ll_allFragment = findViewById(R.id.frag);


        tvOne = findViewById(R.id.btn_one);
        tvTwo = findViewById(R.id.btn_two);
        tvThree = findViewById(R.id.btn_three);
        tvFour = findViewById(R.id.btn_four);
        tvFive = findViewById(R.id.btn_five);
        tvSix = findViewById(R.id.btn_six);
        tvSeven = findViewById(R.id.btn_seven);
        tvEight = findViewById(R.id.btn_eight);
        tvNine = findViewById(R.id.btn_nine);
        tvZero = findViewById(R.id.btn_zero);
        tvDot = findViewById(R.id.btn_dot);
        tvDele = findViewById(R.id.ibtn_delete);

        mMaterialSpinner = findViewById(R.id.spinner);
        click_pro_tv = findViewById(R.id.click_pro_tv);

        //tab
        tab_layout = findViewById(R.id.tab_layout);

        //商品
        recycler_product = findViewById(R.id.recycler_product);
        top_on_left = findViewById(R.id.top_on_left);
        ll_top_on_right = findViewById(R.id.ll_top_on_right);
        layout_right_mengban = findViewById(R.id.layout_right_mengban);
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
        //确认按钮➡️
        fab_confirmbtn = findViewById(R.id.fab_confirmbtn);


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
                top_on_left.setVisibility(View.GONE);
                layout_right_mengban.setVisibility(View.GONE);
                tv_status_right_top.setVisibility(View.GONE);
            }
        });


        //商品计件，计重信息提交至商品列表中的某个商品
        fab_confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String danjia = text_input_danjia.getText().toString();
                String jianshu = text_input_jianshu.getText().toString();
                String zhongliang = text_input_zhongliang.getText().toString();
                boolean jijianbool = apps.isJijianbtn();
                int adapPos = apps.getAdapterPos();

                List<productAddDataInfo> dataListPro = RecyclerItemDataProvider.getZhongxinfachuListNewInfos();
                productAddDataInfo dataInfo = null;

                if (adapPos > -1 && adapPos < dataListPro.size()) {
                    dataInfo = dataListPro.get(adapPos);
                }

                clickLeftRecyProItem = apps.getClickRecyPro();
                int len = dataListPro.size();
                if (clickLeftRecyProItem == 1) {//表示是，点击了左边商品时，弹出输入框...此时，
                    // 若输入框数据完整，则在右边显示的商品list中添加一行数据；
                    System.out.println("bool计件？" + jijianbool);
                    if (jijianbool) {//计件
                        System.out.println("shi计件");
                        //单价  件数  都有值
                        if (!danjia.equals("") && !jianshu.equals("")) {

                            String realLen;
                            int xuhaoLen = len + 1;//表示序号从01开始
                            if (xuhaoLen > 9) {
                                realLen = xuhaoLen + "";
                            } else {
                                realLen = "0" + xuhaoLen;
                            }

                            //计算单个商品小计
                            double danjiadouble = Double.valueOf(danjia);
                            double jianshudouble = Double.valueOf(jianshu);
                            String str = danjiadouble * jianshudouble + "";
                            double proxiaoji = computeutil.stringToDouble(str);


                            productAddDataInfo onedata = new productAddDataInfo(realLen,
                                    click_pro_tv.getText().toString(),
                                    danjia,
                                    jianshu, "-", "" + proxiaoji);
                            dataListPro.add(onedata);
                            setEdittextEmp();

                            hideMengban();
                        } else {
                            XToastUtils.info("请输入单价，件数哦~");
                            return;
                        }

                    } else {//计重
                        System.out.println("shi计重");

                        //单价  重量  都有值
                        if (!danjia.equals("") && !zhongliang.equals("")) {

                            String realLen;
                            int xuhaoLen = len + 1;//表示序号从01开始
                            if (xuhaoLen > 9) {
                                realLen = xuhaoLen + "";
                            } else {
                                realLen = "0" + xuhaoLen;
                            }

                            //计算单个商品小计
                            double zhongliangdouble = Double.valueOf(zhongliang);
                            double danjiadouble = Double.valueOf(danjia);
                            String str = danjiadouble * zhongliangdouble + "";
                            double proxiaoji = computeutil.stringToDouble(str);


                            productAddDataInfo onedata = new productAddDataInfo(realLen,
                                    click_pro_tv.getText().toString(),
                                    danjia,
                                    "-", zhongliang, "" + proxiaoji);
                            dataListPro.add(onedata);

                            setEdittextEmp();
                            hideMengban();

                        } else {
                            XToastUtils.info("请输入单价，重量哦~");
                            return;

                        }
                    }


                } else if (clickLeftRecyProItem == 0) {//表示时，点击了右边商品列表时，弹出输入框...，
                    //此时若输入框数据完整，则更新商品list某行的数据；



                    if (jijianbool) {//计件
                        //单价  件数  都有值
                        if (!danjia.equals("") && !jianshu.equals("")) {
                            dataInfo.setdanjia(danjia);
                            dataInfo.setjianshu(jianshu);
                            dataInfo.setzhongliang("-");

                            //计算单个商品小计
                            double danjiadouble = Double.valueOf(danjia);
                            double jianshudouble = Double.valueOf(jianshu);
                            String str = danjiadouble * jianshudouble + "";
                            double proxiaoji = computeutil.stringToDouble(str);

                            dataInfo.setxiaoji(proxiaoji + "");
                            setEdittextEmp();
                            hideMengban();
                        } else {
                            XToastUtils.info("请输入单价，件数哦~");
                            return;
                        }

                    } else {//计重
                        //单价  重量  都有值
                        if (!danjia.equals("") && !zhongliang.equals("")) {
                            dataInfo.setdanjia(danjia);
                            dataInfo.setzhongliang(zhongliang);
                            dataInfo.setjianshu("-");

                            //计算单个商品小计
                            double danjiadouble = Double.valueOf(danjia);
                            double zhongliangdouble = Double.valueOf(zhongliang);


                            String str = danjiadouble * zhongliangdouble + "";
                            double proxiaoji = computeutil.stringToDouble(str);


                            dataInfo.setxiaoji(proxiaoji + "");
                            setEdittextEmp();
                            hideMengban();

                        } else {
                            XToastUtils.info("请输入单价，重量哦~");
                            return;

                        }
                    }


                }


                //发送刷新数据的广播:在ordernoproductfragment中刷新。

                Intent intnet = new Intent("com.ble.weight");
                sendBroadcast(intnet);

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
                clickJizhongbtn();
            }
        });
        //点击计件按钮
        jijian_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickJijianbtn();
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
        System.out.println("屏幕宽度：" + width2);
        System.out.println("屏幕gao度：" + height2);
        top_on_left.setMinimumWidth((int) ((width2 * 0.6) + 12));
        ll_top_on_right.setMinimumWidth((int) (width2 * 0.4 - 12));
        tv_status_right_top.setMinimumWidth((int) (width2 * 0.4 - 12));


        //默认是 单价输入框选中
        etInput = text_input_danjia;
        text_input_danjia.setFocusable(true);


        text_input_danjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        text_input_danjia.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                etInput = text_input_danjia;

                return false;
            }
        });
        text_input_zhongliang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                etInput = text_input_zhongliang;

                return false;
            }
        });
        text_input_jianshu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                etInput = text_input_jianshu;

                return false;
            }
        });

    }

    public void clickJizhongbtn() {
        apps.setJijianbtn(false);
        framelayout_jijian.setVisibility(View.GONE);
        framlayout_jizhong.setVisibility(View.VISIBLE);

        jizhong_btn.setBackgroundResource(R.drawable.ripple_bg_jijian);
        jizhong_btn.setTextColor(Color.parseColor("#ff00796b"));

        jijian_btn.setBackgroundResource(R.drawable.ripple_bg_jizhong);
        jijian_btn.setTextColor(Color.parseColor("#8a000000"));
    }

    public void clickJijianbtn() {
        apps.setJijianbtn(true);
        framelayout_jijian.setVisibility(View.VISIBLE);
        framlayout_jizhong.setVisibility(View.GONE);

        jijian_btn.setBackgroundResource(R.drawable.ripple_bg_jijian);
        jijian_btn.setTextColor(Color.parseColor("#ff00796b"));

        jizhong_btn.setBackgroundResource(R.drawable.ripple_bg_jizhong);
        jizhong_btn.setTextColor(Color.parseColor("#8a000000"));

    }

    public void hideMengban() {
        top_on_left.setVisibility(View.GONE);
        layout_right_mengban.setVisibility(View.GONE);
        tv_status_right_top.setVisibility(View.GONE);

    }

    public void setEdittextEmp() {
        text_input_danjia.setText("");
        text_input_jianshu.setText("");
        text_input_zhongliang.setText("");
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
                if (position < modeldataPage.getProductTv().length && position >= 0) {


                    if (haveNeworder) {
                        String tv = modeldataPage.getProductTv()[position];
                        apps.setClickRecyPro(1);//表示点击的是左边的商品列表
                        whenClickProd(tv);
                    } else {
                        XToastUtils.info("请先新增订单哦~");
                    }

                }

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


        switch (v.getId()) {
            case R.id.btn_one:
                //表示按了0之后，后面的只能按. 不能按1-9的数字
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("1");

                break;

            case R.id.btn_two:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("2");

                break;

            case R.id.btn_three:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("3");


                break;

            case R.id.btn_four:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("4");


                break;

            case R.id.btn_five:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("5");

                break;

            case R.id.btn_six:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("6");

                break;

            case R.id.btn_seven:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("7");

                break;

            case R.id.btn_eight:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("8");

                break;

            case R.id.btn_nine:
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                clickNum("9");

                break;

            case R.id.btn_zero:
                // 第一个数字按下0的话，第二个数字只能按小数点
                if ("0".equals(etInput.getText().toString().trim())) {
                    break;
                }
                etInput.setText(etInput.getText().toString().trim() + "0");
                etInput.setSelection(etInput.getText().length());
                break;

            case R.id.btn_dot:
                //第一个字符不能按 小数点
                String mynumdot = etInput.getText().toString().trim();
                if (mynumdot.length() == 0) {
                    break;
                }
                onlyOneDot(mynumdot);
                break;

            case R.id.ibtn_delete:
                String numde = etInput.getText().toString().trim();
                if (numde.length() > 0) {
                    etInput.setText(numde.substring(0, numde.length() - 1));
                    etInput.setSelection(etInput.getText().length());
                }
                break;


        }

    }


    public void onlyOneDot(String mynumdot) {
        if (mynumdot.length() > 0 && (mynumdot.subSequence(0, 1).equals("."))) {
            etInput.setText("");
        }
        if (!mynumdot.contains(".")) {
            mynumdot += ".";
            etInput.setText(mynumdot);
            etInput.setSelection(etInput.getText().length());
        }

    }

    public void clickNum(String num) {
        etInput.setText(etInput.getText().toString().trim() + num);
        etInput.setSelection(etInput.getText().length());
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //下面这段代码根据实际业务改成for循环 取批次 取mRecyclerAdapter，取setOnItemMyClickListener

        if (tab.getText().equals("批次2")) {
            mRecyclerAdapter = new PiciProductAdapter(this,
                    modeldataPage.getIconA(), modeldataPage.getProductPicitwoTv());

            recycler_product.setAdapter(mRecyclerAdapter);

            mRecyclerAdapter.setOnItemMyClickListener(new PiciProductAdapter.OnItemMyClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    if (position < modeldataPage.getProductTv().length && position >= 0) {


                        if (haveNeworder) {
                            apps.setClickRecyPro(1);//表示点击的是左边的商品列表

                            String tv = modeldataPage.getProductPicitwoTv()[position];
                            whenClickProd(tv);
                        } else {
                            XToastUtils.info("请先新增订单哦~");
                        }
                    }


                }
            });

        } else if (tab.getText().equals("批次1")) {
            mRecyclerAdapter = new PiciProductAdapter(this,
                    modeldataPage.getIconA(), modeldataPage.getProductTv());


            recycler_product.setAdapter(mRecyclerAdapter);

            mRecyclerAdapter.setOnItemMyClickListener(new PiciProductAdapter.OnItemMyClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    if (position < modeldataPage.getProductTv().length && position >= 0) {


                        if (haveNeworder) {
                            apps.setClickRecyPro(1);//表示点击的是左边的商品列表

                            String tv = modeldataPage.getProductTv()[position];
                            whenClickProd(tv);
                        } else {
                            XToastUtils.info("请先新增订单哦~");
                        }
                    }


                }
            });


        } else {
            mRecyclerAdapter = new PiciProductAdapter(this,
                    modeldataPage.getIconA(), modeldataPage.getProductPicitwoTv());

            recycler_product.setAdapter(mRecyclerAdapter);
            mRecyclerAdapter.setOnItemMyClickListener(new PiciProductAdapter.OnItemMyClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    if (position < modeldataPage.getProductPicitwoTv().length && position >= 0) {
                        if (haveNeworder) {
                            apps.setClickRecyPro(1);//表示点击的是左边的商品列表

                            String tv = modeldataPage.getProductPicitwoTv()[position];
                            whenClickProd(tv);
                        } else {
                            XToastUtils.info("请先新增订单哦~");
                        }

                    }

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


    public void whenClickProd(String click_pro_tv_string) {
        top_on_left.setVisibility(View.VISIBLE);
        layout_right_mengban.setVisibility(View.VISIBLE);
        tv_status_right_top.setVisibility(View.VISIBLE);
        click_pro_tv.setText(click_pro_tv_string);
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
