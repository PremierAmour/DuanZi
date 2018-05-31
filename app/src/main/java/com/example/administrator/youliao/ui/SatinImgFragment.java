package com.example.administrator.youliao.ui;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.youliao.R;
import com.example.administrator.youliao.bean.SatinBean;
import com.example.administrator.youliao.comonent.DaggerHttpComonent;
import com.example.administrator.youliao.ui.adapter.RvImgAdapter;
import com.example.administrator.youliao.ui.base.BaseFragment;
import com.example.administrator.youliao.ui.contract.SatinContract;
import com.example.administrator.youliao.ui.presenter.SatinPresenter;

import java.util.List;

public class SatinImgFragment extends BaseFragment<SatinPresenter> implements SatinContract.View{

    private RecyclerView rv_img;

    @Override
    public int getContentLayout() {
        return R.layout.frag_img;
    }

    @Override
    public void inject() {
        DaggerHttpComonent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        rv_img = view.findViewById(R.id.rv_img);
        rv_img.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加Android自带的分割线
        rv_img.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //获取网络数据
        mPresenter.getSatinimg();
    }

    @Override
    public void showSatinimg(SatinBean satinBean) {
        List<SatinBean.DataBean> data = satinBean.getData();
        //设置适配器
        RvImgAdapter rvImgAdapter = new RvImgAdapter(data, getActivity());
        rv_img.setAdapter(rvImgAdapter);
    }
}
