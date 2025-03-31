package vn.phatbee.tuan9_viewflipper_viewpager_fragment.indicator;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import vn.phatbee.tuan9_viewflipper_viewpager_fragment.activity.RecycleViewSearch;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private RecycleViewSearch recycleViewSearch;
    private final float DP;

    public LinePagerIndicatorDecoration(Context context) {
        this.DP = context.getResources().getDisplayMetrics().density;
    }
}

