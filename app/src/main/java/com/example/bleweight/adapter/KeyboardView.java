package com.example.bleweight.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bleweight.R;

import java.util.ArrayList;
import java.util.List;


public class KeyboardView extends RelativeLayout {

    private RelativeLayout rlBack;
    private RecyclerView recyclerView;
    private List<String> datas;
    private KeyboardAdapter adapter;
    private Animation animationIn;
    private Animation animationOut;


    public KeyboardView(Context context) {
        this(context, null);
    }

    public KeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.layout_key_board, this);
        rlBack = findViewById(R.id.rl_back);
        rlBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) { // 点击关闭键盘
                dismiss();
            }
        });
        recyclerView = findViewById(R.id.recycler_view);

        initData();
        initView();
        initAnimation();
    }

    // 填充数据
    private void initData() {
        datas = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            if (i < 9) {
//                datas.add(String.valueOf(i + 1));
//            } else if (i == 9) {
//                datas.add(".");
//            } else if (i == 10) {
//                datas.add("0");
//            } else {
//                datas.add("");
//            }
//        }

        for (int i = 0; i < 16; i++) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                    datas.add(String.valueOf(i + 1));
                    break;
                case 3://数量
                    datas.add("数量");
                    break;
                case 4:
                case 5:
                case 6:
                    datas.add(String.valueOf(i));
                    break;

                case 7://折扣
                    datas.add("折扣");
                    break;
                case 8:
                case 9:
                case 10:
                    datas.add(String.valueOf(i - 1));
                    break;
                case 11://价格
                    datas.add("价格");
                    break;
                case 12://+/-
                    datas.add("+/-");
                    break;
                case 13:
                    datas.add(String.valueOf(0));
                    break;
                case 14://小数点
                    datas.add(".");
                    break;
                case 15://删除
                    datas.add("");
                    break;
                default:
                    System.out.println("default===========");
                    break;

            }


        }
    }

    // 设置适配器
    public void initView() {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        adapter = new KeyboardAdapter(getContext(), datas);
        recyclerView.setAdapter(adapter);
    }

    // 初始化动画效果
    private void initAnimation() {
        animationIn = AnimationUtils.loadAnimation(getContext(), R.anim.keyboard_in);
        animationOut = AnimationUtils.loadAnimation(getContext(), R.anim.keyboard_out);
    }

    // 弹出软键盘
    public void show() {
        startAnimation(animationIn);
        setVisibility(VISIBLE);
    }

    // 关闭软键盘
    public void dismiss() {
        if (isVisible()) {
            startAnimation(animationOut);
            setVisibility(GONE);
        }
    }

    // 判断软键盘的状态
    public boolean isVisible() {
        if (getVisibility() == VISIBLE) {
            return true;
        }
        return false;
    }

    public void setOnKeyBoardClickListener(KeyboardAdapter.OnKeyboardClickListener listener) {
        adapter.setOnKeyboardClickListener(listener);
    }

    public List<String> getDatas() {
        return datas;
    }

    public RelativeLayout getRlBack() {
        return rlBack;
    }
}
