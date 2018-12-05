package com.bigcoinstar.eth.fragment;


import android.widget.TextView;

import com.bigcoinstar.eth.R;
import com.bigcoinstar.eth.holder.HomeBannerHolder;
import com.bigcoinstar.eth.holder.HomeMarketBannerHolder;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.netson.commonmodule.bean.MarketBean;
import com.netson.commonmodule.mvp.BaseFragment;
import com.netson.commonmodule.mvp.BasePresenter;
import com.netson.commonmodule.mvp.BaseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 主页
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.banner_home)
    ConvenientBanner bannerHome;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    Unbinder unbinder;
    @BindView(R.id.tv_home_notice)
    TextView tvHomeNotice;
    @BindView(R.id.market_banner_home)
    ConvenientBanner marketBannerHome;
    Unbinder unbinder1;

    private List<Integer> bannerList = new ArrayList<>();
    private List<List<MarketBean>> marketList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        bannerList.add(R.mipmap.home_banner_01);
        bannerList.add(R.mipmap.home_banner_02);
        bannerList.add(R.mipmap.home_banner_03);

        List<MarketBean> data1 = new ArrayList<>();
        List<MarketBean> data2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data1.add(MarketBean.getMarketBean());
            data2.add(MarketBean.getMarketBean());
        }
        marketList.add(data1);
        marketList.add(data2);
        bannerHome.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new HomeBannerHolder();
            }
        }, bannerList)
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).startTurning(2000L);

        marketBannerHome.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new HomeMarketBannerHolder();
            }
        }, marketList).setPageIndicator(new int[]{R.drawable.indicator_selected, R.drawable.indicator_unselected});
    }

}
