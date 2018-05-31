package com.example.administrator.youliao.comonent;

import com.example.administrator.youliao.module.HttpModule;
import com.example.administrator.youliao.ui.SatinImgFragment;
import com.example.administrator.youliao.ui.SatinVideoFragment;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComonent {
    void inject(SatinImgFragment satinImgFragment);

    void inject(SatinVideoFragment satinVideoFragment);
}
