package com.base.mvvmbaseproject.data.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;

import com.base.mvvmbaseproject.utils.Define;

public class SharePreference implements ISharePreference {
    private Context context;
    private SharedPreferences mPrefs = getSharePreference();

    public SharePreference(Context context) {
        this.context = context;
    }

    @Override
    public SharedPreferences getSharePreference() {
        return context.getSharedPreferences(Define.PREF_FILE_NAME, Context.MODE_PRIVATE);
    }
}
