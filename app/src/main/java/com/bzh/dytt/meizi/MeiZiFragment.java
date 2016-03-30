package com.bzh.dytt.meizi;

import android.os.Bundle;

import com.bzh.dytt.base.refresh_recyclerview.RefreshRecyclerFragment;
import com.bzh.dytt.base.refresh_recyclerview.RefreshRecyclerPresenter;
import com.bzh.dytt.film.DomesticFilmPresenterFilm;

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
public class MeiZiFragment extends RefreshRecyclerFragment implements MeiZiIView {

    public static MeiZiFragment newInstance() {
        Bundle args = new Bundle();
        MeiZiFragment fragment = new MeiZiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected RefreshRecyclerPresenter initRefreshRecyclerPresenter() {
        return new MeiZiPresenter(getBaseActivity(), this, this);
    }
}
