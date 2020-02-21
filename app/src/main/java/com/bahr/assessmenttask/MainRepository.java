package com.bahr.assessmenttask;



import android.util.Log;

import com.bahr.assessmenttask.model.Data;
import com.bahr.assessmenttask.network.DataService;
import com.bahr.assessmenttask.network.RetrofitClient;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
  private static final String TAG = "EmployeeRepository";
  private MutableLiveData<Data> mutableLiveData = new MutableLiveData<>();
  ListenToChangeConnection listenToChangeConnection;



  public MainRepository() {
  }

  public MutableLiveData<Data> getMutableLiveData(final ListenToChangeConnection listenToChangeConnection) {

    this.listenToChangeConnection = listenToChangeConnection;

    final DataService dataService = RetrofitClient.getService();


    Call<Data> call = dataService.getData();
    call.enqueue(new Callback<Data>() {
      @Override
      public void onResponse(Call<Data> call, Response<Data> response) {
        Data data = response.body();
        if(data!=null && data.getMessage().equals("success")) {
          listenToChangeConnection.resultConnection(Constants.SUCCESS);
          mutableLiveData.setValue(data);
        }else {
          listenToChangeConnection.resultConnection(Constants.Fail);
        }

      }
      @Override
      public void onFailure(Call<Data> call, Throwable t) {
        listenToChangeConnection.resultConnection(Constants.Fail);
        Log.d("onFailure",t.getMessage());
      }
    });

    return mutableLiveData;
  }



  interface ListenToChangeConnection{


    public void resultConnection(int status);

  }

}
