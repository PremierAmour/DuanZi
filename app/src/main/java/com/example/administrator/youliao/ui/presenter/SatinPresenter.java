package com.example.administrator.youliao.ui.presenter;

import com.example.administrator.youliao.bean.SatinBean;
import com.example.administrator.youliao.net.SatinApi;
import com.example.administrator.youliao.ui.base.BasePresenter;
import com.example.administrator.youliao.ui.contract.SatinContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SatinPresenter extends BasePresenter<SatinContract.View> implements SatinContract.Presenter {

    private SatinApi satinApi;
    @Inject
    public SatinPresenter(SatinApi satinApi) {
        this.satinApi = satinApi;
    }

    @Override
    public void getSatinimg() {
        satinApi.getSatinimg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SatinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SatinBean satinBean) {
                        mView.showSatinimg(satinBean);
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
