package com.example.bleweight;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
import com.google.android.material.tabs.TabLayout;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.widget.button.RippleView;
import com.xuexiang.xui.widget.spinner.materialspinner.MaterialSpinner;
import com.xuexiang.xui.widget.toast.XToast;
import com.example.bleweight.utils.modeldataPage;

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
    SharedPreferences.Editor editor;
    RippleView btnLabel;

    TabLayout tab_layout;
    MaterialSpinner mMaterialSpinner;

    RecyclerView recycler_product;

    LinearLayout ll_allFragment;

    Button btn_new_order;

    private Fragment currentFragment = new Fragment();
    private List<Fragment> fragments = new ArrayList<>();
    public int currentIndex = 0;
    //当前显示的fragment
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


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
//        sysKeyBoard();
        setClick();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        //“内存重启”时保存当前的fragment名字
        outState.putInt(CURRENT_FRAGMENT, currentIndex);
        super.onSaveInstanceState(outState);
    }

    private void sysKeyBoard() {
        // 设置不调用系统键盘
        if (Build.VERSION.SDK_INT <= 10) {
            etInput.setInputType(InputType.TYPE_NULL);
        } else {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(etInput, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setClick() {
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


        initviews();
    }


    public void initviews() {
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
                SnackbarUtils.Long(spinner, "选中： " + item).show();
            }
        });
        mMaterialSpinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {
            @Override
            public void onNothingSelected(MaterialSpinner spinner) {
                SnackbarUtils.Long(spinner, "没有选中").show();
            }
        });
        mMaterialSpinner.setSelectedIndex(0);
//        mMaterialSpinner.setSelectedItem("综合排序");


        //recyclerview
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_product.setLayoutManager(layoutManager);
        recycler_product.setAdapter(new PiciProductAdapter(this,
                modeldataPage.getIconA(), modeldataPage.getProductTv()));
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
            recycler_product.setAdapter(new PiciProductAdapter(this,
                    modeldataPage.getIconPiciTwoA(), modeldataPage.getProductPicitwoTv()));
        } else if (tab.getText().equals("批次1")) {
            recycler_product.setAdapter(new PiciProductAdapter(this,
                    modeldataPage.getIconA(), modeldataPage.getProductTv()));
        } else {
            recycler_product.setAdapter(new PiciProductAdapter(this,
                    modeldataPage.iconsss, modeldataPage.productsssTv));
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
