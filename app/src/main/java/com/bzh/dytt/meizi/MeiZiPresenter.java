package com.bzh.dytt.meizi;

import android.support.annotation.IntegerRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bzh.data.basic.BaseInfoEntity;
import com.bzh.data.basic.MeiZiEntity;
import com.bzh.data.repository.Repository;
import com.bzh.dytt.R;
import com.bzh.dytt.base.basic.BaseActivity;
import com.bzh.dytt.base.basic.BaseFragment;
import com.bzh.dytt.base.refresh_recyclerview.RefreshRecyclerPresenter;
import com.bzh.dytt.base.refresh_recyclerview.RefreshRecyclerView;
import com.bzh.recycler.ExCommonAdapter;
import com.bzh.recycler.ExRecyclerView;
import com.bzh.recycler.ExViewHolder;

import java.util.ArrayList;

import rx.Observable;

/**
 * ==========================================================<br>
 * <b>版权</b>：　　　别志华 版权所有(c)2016<br>
 * <b>作者</b>：　　  biezhihua@163.com<br>
 * <b>创建日期</b>：　16-3-20<br>
 * <b>描述</b>：　　　<br>
 * <b>版本</b>：　    V1.0<br>
 * <b>修订历史</b>：　<br>
 * ==========================================================<br>
 */
public class MeiZiPresenter extends RefreshRecyclerPresenter<MeiZiEntity, ArrayList<MeiZiEntity>> implements SwipeRefreshLayout.OnRefreshListener, ExCommonAdapter.OnItemClickListener, ExRecyclerView.OnLoadMoreListener {

    public MeiZiPresenter(BaseActivity baseActivity, BaseFragment baseFragment, RefreshRecyclerView iView) {
        super(baseActivity, baseFragment, iView);
    }

    @Override
    public String getMaxPage() {
        return String.valueOf(Integer.MAX_VALUE);
    }

    @Override
    public Observable<ArrayList<MeiZiEntity>> getRequestListDataObservable(String nextPage) {
        return Repository.getInstance().getMeiZi(Integer.valueOf(nextPage));
    }

    @Override
    public void onItemClick(ExViewHolder viewHolder) {
        super.onItemClick(viewHolder);
    }

    @Override
    public ExCommonAdapter<MeiZiEntity> getExCommonAdapter() {
        return new ExCommonAdapter<MeiZiEntity>(getBaseActivity(), R.layout.item_meizi) {
            @Override
            protected void convert(ExViewHolder viewHolder, MeiZiEntity item) {
                ImageView iv_meizi = (ImageView) viewHolder.getView(R.id.iv_meizi);
                Glide.with(getBaseActivity())
                        .load(item.getUrl())
                        .placeholder(R.drawable.ic_placeholder)
                        .into(iv_meizi);
            }
        };
    }
}
