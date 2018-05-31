package com.example.administrator.youliao.net;

import com.example.administrator.youliao.bean.SainVideoBean;
import com.example.administrator.youliao.bean.SatinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface SatinApiService {

    @GET("satinApi?type=3&page=1")
    Observable<SatinBean> getSatinimg();

    @GET("satinApi?type=4&page=1")
    Observable<SainVideoBean> getSatinVideo();

}
