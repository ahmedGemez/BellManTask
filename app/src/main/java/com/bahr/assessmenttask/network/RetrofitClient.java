package com.bahr.assessmenttask.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  private static Retrofit retrofit;
  private static final String BASE_URL = "http://bellman-bd.restart-technology.com/api/";

  public static DataService getService() {
    if (retrofit == null) {
      retrofit = new Retrofit
          .Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }

    return retrofit.create(DataService.class);
  }
}