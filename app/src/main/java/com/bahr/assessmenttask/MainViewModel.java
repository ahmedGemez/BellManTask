package com.bahr.assessmenttask;

import android.app.Application;

import com.bahr.assessmenttask.model.Data;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {
  private MainRepository mainRepository;

  MainRepository.ListenToChangeConnection listenToChangeConnection;

  public MainViewModel(@NonNull Application application) {
    super(application);
    mainRepository = new MainRepository();
  }

  public LiveData<Data> getData(MainRepository.ListenToChangeConnection listenToChangeConnection ) {
    this.listenToChangeConnection = listenToChangeConnection;
    return mainRepository.getMutableLiveData(listenToChangeConnection);
  }
}
