package com.bahr.assessmenttask;

import android.os.Bundle;

import com.bahr.assessmenttask.Utils.BellButtonAnimation;
import com.bahr.assessmenttask.adapters.AttractionAdapter;
import com.bahr.assessmenttask.adapters.EventsAdapter;
import com.bahr.assessmenttask.adapters.HotSpotsAdapter;
import com.bahr.assessmenttask.databinding.ActivityMainBinding;
import com.bahr.assessmenttask.model.Data;
import com.bahr.assessmenttask.model.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainRepository.ListenToChangeConnection {

    private MainViewModel mainViewModel;
    private HotSpotsAdapter hotSpotsAdapter;
    private EventsAdapter eventsAdapter;
    private AttractionAdapter attractionAdapter;

    private RelativeLayout progress;
    private RelativeLayout noConnection;


    private boolean fabFlag=false;

    Animation show_fab_1 ;
    Animation show_fab_2 ;
    Animation show_fab_3 ;
    Animation show_fab_4 ;
    Animation hide_fab_1 ;
    FrameLayout fab1 ;
    FrameLayout fab2 ;
    FrameLayout fab3 ;
    FrameLayout fab4 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progress = activityMainBinding.content.progress;
        noConnection = activityMainBinding.content.noConnection;


        // bind hotSpotsRecycle
        RecyclerView recyclerView = activityMainBinding.content.hotSpotsRecycle;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // bind EventsRecycle
        RecyclerView eventRecyclerView = activityMainBinding.content.eventsRecycle;
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        eventRecyclerView.setLayoutManager(layoutManager1);
        eventRecyclerView.setHasFixedSize(true);

        // bind AttractionRecycle
        RecyclerView attractionRecyclerView = activityMainBinding.content.attractionRecycle;
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        attractionRecyclerView.setLayoutManager(layoutManager2);
        attractionRecyclerView.setHasFixedSize(true);





        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        hotSpotsAdapter = new HotSpotsAdapter();
        recyclerView.setAdapter(hotSpotsAdapter);

        eventsAdapter = new EventsAdapter();
        eventRecyclerView.setAdapter(eventsAdapter);

        attractionAdapter = new AttractionAdapter();
        attractionRecyclerView.setAdapter(attractionAdapter);

        progress.setVisibility(View.VISIBLE);
        mainViewModel.getData(this).observe(this, new Observer<Data>() {
            @Override
            public void onChanged(@Nullable Data data) {

                hotSpotsAdapter.setHotSpotList((data.getData().getHotSpots()));
                eventsAdapter.setEventsList((data.getData().getEvents()));
                attractionAdapter.setAttractionList((data.getData().getAttractions()));


            }
        });



         show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
         show_fab_2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_show);
         show_fab_3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_show);
         show_fab_4 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab4_show);

         hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);




        FloatingActionButton fab = findViewById(R.id.fab);
         fab1 = findViewById(R.id.fab_1);
         fab2 = findViewById(R.id.fab_2);
         fab3 = findViewById(R.id.fab_3);
         fab4 = findViewById(R.id.fab_4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fabFlag) {
                    BellButtonAnimation.onClickBellButton(fabFlag,fab1,fab2,fab3,fab4,show_fab_1,show_fab_2
                            ,show_fab_3,show_fab_4,hide_fab_1);
                    fabFlag=!fabFlag;
                }else{
                    BellButtonAnimation.onClickBellButton(fabFlag,fab1,fab2,fab3,fab4,show_fab_1,show_fab_2
                            ,show_fab_3,show_fab_4,hide_fab_1);
                    fabFlag=!fabFlag;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void resultConnection(int status) {
        progress.setVisibility(View.GONE);
         if(status==Constants.Fail){
            noConnection.setVisibility(View.VISIBLE);
        }
    }
}
