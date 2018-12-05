package com.bigcoinstar.eth.app;

import com.netson.commonmodule.app.CommonApplication;
import com.netson.commonmodule.utils.MultiLanguageUtil;

public class MyApplication extends CommonApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiLanguageUtil.init(this);
        MultiLanguageUtil.getInstance().updateLanguage(MultiLanguageUtil.getInstance().getLanguageType());
    }
}
