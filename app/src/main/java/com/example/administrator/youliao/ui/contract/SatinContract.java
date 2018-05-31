package com.example.administrator.youliao.ui.contract;

import com.example.administrator.youliao.bean.SatinBean;
import com.example.administrator.youliao.ui.base.BaseContract;

public interface SatinContract {

    interface View extends BaseContract.BaseView{
        void showSatinimg(SatinBean satinBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getSatinimg();
    }

}
