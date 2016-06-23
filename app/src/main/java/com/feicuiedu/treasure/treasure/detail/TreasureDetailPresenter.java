package com.feicuiedu.treasure.treasure.detail;

import com.feicuiedu.treasure.net.NetClient;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/6/23 0023.
 */
public class TreasureDetailPresenter extends MvpNullObjectBasePresenter<TreasureDetailView> {

    private Call<List<TreasureDetailResult>> call;

    public void getTreasureDetail(TreasureDetail treasureDetail){
        if(call != null)call.cancel();
        call = NetClient.getInstance().getTreasureApi().getTreasureDetail(treasureDetail);
        call.enqueue(callback);
    }

    @Override public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if(call != null)call.cancel();
    }

    private Callback<List<TreasureDetailResult>> callback = new Callback<List<TreasureDetailResult>>() {
        @Override public void onResponse(Call<List<TreasureDetailResult>> call, Response<List<TreasureDetailResult>> response) {
            if(response != null && response.isSuccessful()){
                TreasureDetailResult result = response.body().get(0);
                if (result == null) {
                    getView().showMessage("unknown error");
                    return;
                }
                getView().setData(result);
            }
        }

        @Override public void onFailure(Call<List<TreasureDetailResult>> call, Throwable t) {
            getView().showMessage(t.getMessage());
        }
    };


}
