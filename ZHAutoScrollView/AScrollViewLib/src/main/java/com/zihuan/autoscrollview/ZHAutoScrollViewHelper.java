package com.zihuan.autoscrollview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;


public class ZHAutoScrollViewHelper {
    private static ZHAutoScrollViewHelper mZhAutoScrollViewHelper;

    public static ZHAutoScrollViewHelper getInstance() {
        return mZhAutoScrollViewHelper != null ? mZhAutoScrollViewHelper : (mZhAutoScrollViewHelper = new ZHAutoScrollViewHelper());
    }

    private ZHAutoScrollView mZhAutoScrollView;

    /***
     * 设置滑动的view
     * @param zhAutoScrollView
     */
    public void setLastView(ZHAutoScrollView zhAutoScrollView) {
        if (isHasLastView() && mZhAutoScrollView != zhAutoScrollView) {
            mZhAutoScrollView.reset();
        }
        mZhAutoScrollView = zhAutoScrollView;
    }

    public ZHAutoScrollView getLastView() {
        return mZhAutoScrollView;
    }

    //是否有最后一个view
    private boolean isHasLastView() {
        return getLastView() != null;
    }

    public void bindRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("状态", "newState " + newState);
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING && isHasLastView()) {
                    mZhAutoScrollView.reset();
                }

            }
        });

    }

}