package com.netson.commonmodule.bean;

/**
 * 市场行情
 */
public class MarketBean {
    public String coin;
    public String price;
    public String percent;
    public String total;

    public MarketBean(String coin, String price, String percent, String total) {
        this.coin = coin;
        this.price = price;
        this.percent = percent;
        this.total = total;
    }

    public static MarketBean getMarketBean() {
        MarketBean marketBean = new MarketBean("ETH/USDT", "597.80", "0.58%", "≈3924.64CNY");
        return marketBean;
    }
}
