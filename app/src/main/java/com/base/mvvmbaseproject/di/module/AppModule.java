package com.base.mvvmbaseproject.di.module;

import android.app.Application;
import android.content.Context;

import com.base.mvvmbaseproject.data.sharepreference.ISharePreference;
import com.base.mvvmbaseproject.data.sharepreference.SharePreference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class AppModule {

    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    public ISharePreference provideSharePreference(Context context) {
        return new SharePreference(context);
    }

    @Provides
    @Singleton
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
