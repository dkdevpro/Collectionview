package com.din.collectionview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by dineshkumar.m on 19/02/16.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private final Context mContext;
    private int[] images = new int[]{R.drawable.pager1,R.drawable.pager2,
            R.drawable.pager3,R.drawable.pager4,R.drawable.pager5};

    public ViewPagerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //Drawable icon = getResources().obtainTypedArray(iconResId).getDrawable(position);

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.view_pager_item, container, false);


        ImageView iconView = (ImageView) itemView.findViewById(R.id.landing_img_slide);

        iconView.setBackgroundResource(images[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
