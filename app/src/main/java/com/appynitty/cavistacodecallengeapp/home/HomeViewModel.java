package com.appynitty.cavistacodecallengeapp.home;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appynitty.cavistacodecallengeapp.MainActivity;
import com.appynitty.cavistacodecallengeapp.common.CommonConstant;
import com.appynitty.cavistacodecallengeapp.common.FragmentSupportBaseObservable;
import com.appynitty.cavistacodecallengeapp.common.UtilSnackbar;
import com.appynitty.cavistacodecallengeapp.common.generic.GenericAdapter;
import com.appynitty.cavistacodecallengeapp.home.controller.HomeController;
import com.appynitty.cavistacodecallengeapp.home.model.HomeModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import timber.log.Timber;


public class HomeViewModel extends FragmentSupportBaseObservable {

    public ObservableBoolean isProgress;
    public ObservableBoolean isSearch;

    public ObservableBoolean isSearchShow;

    private ObservableList<HomeModel> observableSearchList;
    public ObservableList<Disposable> compositeDisposable;
    private HomeController controller;

    private static final String TAG = "HomeViewModel";
    public HomeModel model;

    public GenericAdapter<HomeModel, HomeItemViewModel> genericHomeAdapter;


    private GenericAdapter.OnItemClickListner listnerSearch = o -> {
        if (o instanceof HomeModel) {
            Timber.d(":  DashBoardControllerrdSearchModel%s", new Gson().toJson(o));
            ((MainActivity) getFragment().requireContext()).callNextFragment((HomeModel) o);

        }
    };


    public HomeViewModel(Fragment fragment) {
        super(fragment);
        model = new HomeModel();
        compositeDisposable = new ObservableArrayList<>();
        isProgress = new ObservableBoolean(false);
        isSearchShow = new ObservableBoolean(true);
        isSearch = new ObservableBoolean(false);

        controller = new HomeController();
//
        observableSearchList = new ObservableArrayList<>();
        getSearchImage();
        generateRvSearchContent();



    }


    public void getSearchImage() {
        isProgress.set(true);
        Timber.d("getSearchImage: ");
        Observable<ResponseBody> observable =
                CommonConstant.getController(getFragment().requireContext()).getImageSearch();
        Disposable disposable = observable.flatMap((Function<ResponseBody, Observable<List<HomeModel>>>)
                responseBody -> {
                    String res = null;
                    if (responseBody != null && !TextUtils.isEmpty(responseBody.toString())) {
                        try {
                            res = responseBody.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Timber.d(e);

                        }
                    }
                    return Observable.just(controller.getSearchImageModel(res));
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessHomeModel, this::showError);
        compositeDisposable.add(disposable);


    }


    private void showError(Throwable throwable) {
        isSearchShow.set(false);
        isProgress.set(false);
        UtilSnackbar.showSnakbarTypeTwo(getFragment().getView(), throwable.getMessage());

    }

    private void onSuccessHomeModel(List<HomeModel> dashboardSearchModel) {
        Timber.d("onSuccessDashBoardModel Size: %s", dashboardSearchModel.size());
        isProgress.set(false);
        isSearchShow.set(false);
        observableSearchList.addAll(dashboardSearchModel);

        Timber.d("onSuccessDashBoardModel: %s", new Gson().toJson(observableSearchList));
        Log.d(TAG, "onSuccessHomeModel: "+new Gson().toJson(observableSearchList));
        Log.d(TAG, "onSuccessHomeModel Size: "+observableSearchList.size());

    }


    @BindingAdapter(value = {"customShapeGridView"}, requireAll = false)
    public static void servicesSearchRecyclerview(RecyclerView recyclerView, GenericAdapter adapter) {
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setAdapter(adapter);

    }

    private void generateRvSearchContent() {
        HomeItemViewModel itemModel = new HomeItemViewModel(getFragment().getContext());
        itemModel.setListener(listnerSearch);
        genericHomeAdapter = new GenericAdapter<>(observableSearchList, itemModel);
    }


}
