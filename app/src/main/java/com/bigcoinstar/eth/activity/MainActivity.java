package com.bigcoinstar.eth.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bigcoinstar.eth.R;
import com.bigcoinstar.eth.fragment.BiBiFragment;
import com.bigcoinstar.eth.fragment.MainFragment;
import com.bigcoinstar.eth.fragment.MarketFragment;
import com.bigcoinstar.eth.fragment.MoreFragment;
import com.bigcoinstar.eth.fragment.OTCFragment;
import com.netson.commonmodule.mvp.BaseActivity;
import com.netson.commonmodule.mvp.BasePresenter;
import com.netson.commonmodule.mvp.BaseView;
import com.netson.commonmodule.utils.DrawableUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.rbt_home)
    RadioButton rbtHome;
    @BindView(R.id.rbt_market)
    RadioButton rbtMarket;
    @BindView(R.id.rbt_bibi)
    RadioButton rbtBibi;
    @BindView(R.id.rbt_otc)
    RadioButton rbtOtc;
    @BindView(R.id.rbt_more)
    RadioButton rbtMore;
    @BindView(R.id.rgp_groups)
    RadioGroup rgpGroups;

    private MainFragment mainFragment;

    private MarketFragment marketFragment;

    private BiBiFragment biBiFragment;

    private OTCFragment otcFragment;

    private MoreFragment moreFragment;

    private FragmentManager fragmentManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
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
        fragmentManager = getSupportFragmentManager();
        initFragment(R.id.rbt_home);
        rgpGroups.setOnCheckedChangeListener(this);
    }

    /**
     * 初始化fragment
     */
    private void initFragment(int pos) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideAllFrag(transaction);
        setDefaultImg();
        switch (pos) {
            case R.id.rbt_home:
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    transaction.add(R.id.fl_content, mainFragment);
                } else {
                    transaction.show(mainFragment);
                }
                DrawableUtils.drawableTop(rbtHome, R.mipmap.home_selected);
                break;
            case R.id.rbt_market:
                if (marketFragment == null) {
                    marketFragment = new MarketFragment();
                    transaction.add(R.id.fl_content, marketFragment);
                } else {
                    transaction.show(marketFragment);
                }
                DrawableUtils.drawableTop(rbtMarket, R.mipmap.market_selected);
                break;
            case R.id.rbt_bibi:
                if (biBiFragment == null) {
                    biBiFragment = new BiBiFragment();
                    transaction.add(R.id.fl_content, biBiFragment);
                } else {
                    transaction.show(biBiFragment);
                }
                DrawableUtils.drawableTop(rbtBibi, R.mipmap.bibi_selected);
                break;
            case R.id.rbt_otc:
                if (otcFragment == null) {
                    otcFragment = new OTCFragment();
                    transaction.add(R.id.fl_content, otcFragment);
                } else {
                    transaction.show(otcFragment);
                }
                DrawableUtils.drawableTop(rbtOtc, R.mipmap.otc_selected);
                break;
            case R.id.rbt_more:
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    transaction.add(R.id.fl_content, moreFragment);
                } else {
                    transaction.show(moreFragment);
                }
                DrawableUtils.drawableTop(rbtMore, R.mipmap.market_selected);
                break;
        }
        transaction.commit();
    }

    /**
     * 初始化图标
     */
    private void setDefaultImg() {
        DrawableUtils.drawableTop(rbtHome, R.mipmap.home_default);
        DrawableUtils.drawableTop(rbtMarket, R.mipmap.market_default);
        DrawableUtils.drawableTop(rbtBibi, R.mipmap.bibi_default);
        DrawableUtils.drawableTop(rbtOtc, R.mipmap.otc_default);
        DrawableUtils.drawableTop(rbtMore, R.mipmap.market_default);
    }

    /**
     * 隐藏fragment
     *
     * @param transaction
     */
    private void hideAllFrag(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
        if (marketFragment != null) {
            transaction.hide(marketFragment);
        }
        if (biBiFragment != null) {
            transaction.hide(biBiFragment);
        }
        if (otcFragment != null) {
            transaction.hide(otcFragment);
        }
        if (moreFragment != null) {
            transaction.hide(moreFragment);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int radioBtnId) {
        initFragment(radioBtnId);
    }
}
