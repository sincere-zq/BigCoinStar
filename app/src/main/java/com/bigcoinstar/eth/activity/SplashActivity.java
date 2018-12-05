package com.bigcoinstar.eth.activity;

import com.bigcoinstar.eth.R;
import com.netson.commonmodule.mvp.BaseActivity;
import com.netson.commonmodule.mvp.BasePresenter;
import com.netson.commonmodule.mvp.BaseView;
import com.netson.commonmodule.utils.BackgroundTasks;

public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
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
        BackgroundTasks.getInstance().postDelayed(new Runnable() {
            @Override
            public void run() {
                openActivity(MainActivity.class);
                finish();
            }
        }, 2000);
    }
}
