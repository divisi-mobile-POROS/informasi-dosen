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
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mindorks.mvp.data.DataManager;
import com.mindorks.mvp.model.DosenResponse;
import com.mindorks.mvp.network.ApiClient;
import com.mindorks.mvp.network.ApiHelper;
import com.mindorks.mvp.ui.base.BasePresenter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by gaura on 23-08-2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    ArrayAdapter<String> adapter;


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
    public void getDosenData(final MainAdapter mainAdapter, final RecyclerView recyclerView, final AutoCompleteTextView autoCompleteTextView, final Context context) {
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


                    String[] namaDosen = new String[dosenResponse.getDosen().size()];

                    for (int i = 0; i < dosenResponse.getDosen().size(); i++) {
                        namaDosen[i] = dosenResponse.getDosen().get(i).getNama();
                    }
                    mainAdapter.addItem(dosenResponse);
                    recyclerView.setAdapter(mainAdapter);
                    String[] COUNTRIES = new String[] {
                            "Belgium", "France", "Italy", "Germany", "Spain"
                    };


                    adapter  = new ArrayAdapter<String>(context,
                            android.R.layout.simple_dropdown_item_1line, namaDosen);
                    autoCompleteTextView.setAdapter(adapter);
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
