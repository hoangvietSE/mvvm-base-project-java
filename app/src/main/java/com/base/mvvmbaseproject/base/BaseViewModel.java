package com.base.mvvmbaseproject.base;

import androidx.lifecycle.ViewModel;

import com.base.mvvmbaseproject.data.sharepreference.ISharePreference;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {
    protected CompositeDisposable mCompositeDisposable;
    protected ISharePreference mSharePreference;

    public BaseViewModel(CompositeDisposable mCompositeDisposable, ISharePreference mSharePreference) {
        this.mCompositeDisposable = mCompositeDisposable;
        this.mSharePreference = mSharePreference;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
            mCompositeDisposable = null;
        }
    }
}
