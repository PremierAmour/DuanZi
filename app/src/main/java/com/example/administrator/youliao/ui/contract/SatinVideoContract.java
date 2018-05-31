package com.example.administrator.youliao.ui.contract;

import com.example.administrator.youliao.bean.SainVideoBean;
import com.example.administrator.youliao.ui.base.BaseContract;

public interface SatinVideoContract {

    interface View extends BaseContract.BaseView{
        void showSatinVideo(SainVideoBean sainVideoBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getSatinVideo();
    }

}
