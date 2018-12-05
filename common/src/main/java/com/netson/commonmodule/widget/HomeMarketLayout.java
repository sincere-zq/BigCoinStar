package com.netson.commonmodule.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.netson.commonmodule.R;
import com.netson.commonmodule.bean.MarketBean;

import java.util.List;

public class HomeMarketLayout extends LinearLayout {


    public HomeMarketLayout(Context context) {
        this(context, null);
    }

    public HomeMarketLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeMarketLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(List<MarketBean> datas) {
        for (MarketBean marketBean : datas) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_market, null);
            TextView tvCoin = view.findViewById(R.id.tv_coin);
            tvCoin.setText(marketBean.coin);
            TextView tvPrice = view.findViewById(R.id.tv_price);
            tvPrice.setText(marketBean.price);
            TextView tvPercent = view.findViewById(R.id.tv_percent);
            tvPercent.setText(marketBean.percent);
            TextView tvToal = view.findViewById(R.id.tv_total);
            tvToal.setText(marketBean.total);
            addView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        }
    }
}
