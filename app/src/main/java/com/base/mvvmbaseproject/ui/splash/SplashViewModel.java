package com.base.mvvmbaseproject.ui.splash;


import com.base.mvvmbaseproject.base.BaseViewModel;
import com.base.mvvmbaseproject.data.sharepreference.ISharePreference;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashViewModel extends BaseViewModel {

    @Inject
    SplashViewModel(CompositeDisposable mCompositeDisposable, ISharePreference mSharePreference) {
        super(mCompositeDisposable, mSharePreference);
    }
}
