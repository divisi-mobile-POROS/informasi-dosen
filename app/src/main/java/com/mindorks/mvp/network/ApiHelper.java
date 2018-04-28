package com.mindorks.mvp.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nyamuk on 4/28/18.
 */

public interface ApiHelper {

    //get data dosen
    @GET("get_civitas/dosen/")
    Call<String> getDosenData();
}
