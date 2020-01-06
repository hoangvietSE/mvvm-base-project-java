package com.base.mvvmbaseproject.ui.home;

import androidx.lifecycle.MutableLiveData;

import com.base.mvvmbaseproject.base.BaseViewModel;
import com.base.mvvmbaseproject.base.ListLoadmoreReponse;
import com.base.mvvmbaseproject.data.network.repository.Repository;
import com.base.mvvmbaseproject.data.sharepreference.ISharePreference;
import com.base.mvvmbaseproject.entity.SearchResponse;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModel extends BaseViewModel {
    private Repository repository;
    private MutableLiveData<ListLoadmoreReponse<SearchResponse>> search = new MutableLiveData<>();
    private int pageIndex = 1;

    @Inject
    public HomeViewModel(Repository repository, CompositeDisposable mCompositeDisposable, ISharePreference mSharePreference) {
        super(mCompositeDisposable, mSharePreference);
        this.repository = repository;
    }

    public MutableLiveData<ListLoadmoreReponse<SearchResponse>> getSearch() {
        return search;
    }

    public void search(boolean isRefresh) {
        if (isRefresh) {
            pageIndex = 1;
        }
        mCompositeDisposable.add(
                repository.search(pageIndex)
                        .doOnSubscribe(disposable -> {
                            if (isRefresh) {
                                search.setValue(new ListLoadmoreReponse<SearchResponse>().loading());
                            }
                        })
                        .subscribe(
                                response -> {
                                    pageIndex++;
                                    search.setValue(new ListLoadmoreReponse<SearchResponse>().success(response.getData(), isRefresh,
                                            pageIndex <= response.getTotalPage()));
                                },
                                throwable -> {
                                    search.setValue(new ListLoadmoreReponse<SearchResponse>().error(throwable));
                                }
                        )
        );
    }
}
