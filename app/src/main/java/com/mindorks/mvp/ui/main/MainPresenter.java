/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.mindorks.mvp.ui.main;

import android.app.Service;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mindorks.mvp.data.DataManager;
import com.mindorks.mvp.model.DosenResponse;
import com.mindorks.mvp.network.ApiClient;
import com.mindorks.mvp.network.ApiHelper;
import com.mindorks.mvp.ui.base.BasePresenter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by gaura on 23-08-2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public String getEmailId() {
        return getDataManager().getEmailId();
    }

    @Override
    public void setUserLoggedOut() {
        getDataManager().clear();
        getMvpView().openSplashActivity();
    }

    @Override
    public void getDosenData() {
        ApiHelper service = ApiClient.createService(ApiHelper.class);

        Call<String> call = service.getDosenData();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                byte[] data = Base64.decode(response.body(), Base64.DEFAULT);
                try {
                    String text = new String(data, "UTF-8");
                    //String text2 = new String(data, StandardCharsets.UTF_8);
                    Log.d(TAG, "onResponse: "+text);
                    Gson gson = new Gson();
                    text = "{\n" +
                            "  \"dosen\":" + text + "}";
                    DosenResponse dosenResponse = gson.fromJson(text, DosenResponse.class);
                    Log.d(TAG, "onResponse: "+dosenResponse.getDosen().get(0).getNama());
                    Log.d(TAG, "onResponse: "+dosenResponse.getDosen().size());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

}
