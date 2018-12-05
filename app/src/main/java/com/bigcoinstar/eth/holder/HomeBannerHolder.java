package com.bigcoinstar.eth.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;

/**
 * 首页banner Item
 */
public class HomeBannerHolder implements Holder<Integer> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        Glide.with(context).load(data).centerCrop().into(imageView);
    }
}
