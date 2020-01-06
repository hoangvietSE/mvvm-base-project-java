package com.base.mvvmbaseproject.ui.main;

import com.base.mvvmbaseproject.base.BaseViewModel;
import com.base.mvvmbaseproject.data.sharepreference.ISharePreference;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(CompositeDisposable mCompositeDisposable, ISharePreference mSharePreference) {
        super(mCompositeDisposable, mSharePreference);
    }
}
