package com.bahr.assessmenttask.network;


import com.bahr.assessmenttask.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
  @GET("home")
  Call<Data> getData();
}
