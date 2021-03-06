package com.example.administrator.youliao.ui;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.youliao.R;
import com.example.administrator.youliao.bean.SainVideoBean;
import com.example.administrator.youliao.comonent.DaggerHttpComonent;
import com.example.administrator.youliao.ui.adapter.RvVideoAdapter;
import com.example.administrator.youliao.ui.base.BaseFragment;
import com.example.administrator.youliao.ui.contract.SatinVideoContract;
import com.example.administrator.youliao.ui.presenter.SatinVideoPresenter;

import java.util.List;

public class SatinVideoFragment extends BaseFragment<SatinVideoPresenter> implements SatinVideoContract.View{

    private RecyclerView rv_video;

    @Override
    public int getContentLayout() {
        return R.layout.frag_video;
    }
    //注入数据
    @Override
    public void inject() {
        DaggerHttpComonent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        rv_video = view.findViewById(R.id.rv_video);
        rv_video.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加Android自带的分割线
        rv_video.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //请求网络加载数据
        mPresenter.getSatinVideo();
    }

    @Override
    public void showSatinVideo(SainVideoBean sainVideoBean) {
        List<SainVideoBean.DataBean> data = sainVideoBean.getData();
        //设置适配器
        RvVideoAdapter rvVideoAdapter = new RvVideoAdapter(data, getActivity());
        rv_video.setAdapter(rvVideoAdapter);
    }
}
