package com.bigcoinstar.eth.holder;

import android.content.Context;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.netson.commonmodule.bean.MarketBean;
import com.netson.commonmodule.widget.HomeMarketLayout;

import java.util.List;

public class HomeMarketBannerHolder implements Holder<List<MarketBean>> {
    private HomeMarketLayout homeMarketLayout;

    @Override
    public View createView(Context context) {
        homeMarketLayout=new HomeMarketLayout(context);
        return homeMarketLayout;
    }

    @Override
    public void UpdateUI(Context context, int position, List<MarketBean> datas) {
        homeMarketLayout.init(datas);
    }
}
