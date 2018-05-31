package com.example.administrator.youliao.ui.presenter;

import com.example.administrator.youliao.bean.SainVideoBean;
import com.example.administrator.youliao.net.SatinApi;
import com.example.administrator.youliao.ui.base.BasePresenter;
import com.example.administrator.youliao.ui.contract.SatinVideoContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SatinVideoPresenter extends BasePresenter<SatinVideoContract.View> implements SatinVideoContract.Presenter {

    private SatinApi satinApi;
    @Inject
    public SatinVideoPresenter(SatinApi satinApi) {
        this.satinApi = satinApi;
    }

    @Override
    public void getSatinVideo() {
        satinApi.getSatinVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SainVideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SainVideoBean sainVideoBean) {
                        mView.showSatinVideo(sainVideoBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
