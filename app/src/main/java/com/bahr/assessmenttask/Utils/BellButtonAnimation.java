package com.bahr.assessmenttask.Utils;

import android.graphics.drawable.Animatable;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class BellButtonAnimation {



    public static void onClickBellButton(boolean fabFlag,FrameLayout fab1,FrameLayout fab2,FrameLayout fab3,FrameLayout fab4,
                                  Animation anim1,Animation anim2,Animation anim3,Animation anim4,Animation hideanim1){

        if(!fabFlag) {
            showActionMenu(fab1,3,0.0,true,anim1);
            showActionMenu(fab2,1.1,1.2,true,anim2);
            showActionMenu(fab3,1.1,1.2,false,anim3);
            showActionMenu(fab4,3,0.0,false,anim4);

        }else{
            hideActionMenu(fab1,3,0.0,true,hideanim1);
            hideActionMenu(fab2,1.1,1.2,true,hideanim1);
            hideActionMenu(fab3,1.1,1.2,false,hideanim1);
            hideActionMenu(fab4,3,0.0,false,hideanim1);
        }
    }

    public static void showActionMenu(FrameLayout fab1, double x , double y, boolean flag, Animation show_fab_1){

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) fab1.getLayoutParams();
        if(flag) {
            layoutParams.rightMargin += (int) (fab1.getWidth() * x);
            layoutParams.bottomMargin += (int) (fab1.getWidth() * y);
            fab1.setLayoutParams(layoutParams);
        }else{
            layoutParams.leftMargin += (int) (fab1.getWidth() * x);
            layoutParams.bottomMargin += (int) (fab1.getWidth() * y);
            fab1.setLayoutParams(layoutParams);
        }
        fab1.startAnimation(show_fab_1);
        fab1.setClickable(true);
    }

    public static void hideActionMenu(FrameLayout fab1,double x , double y,boolean flag,Animation hide_fab_1){
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) fab1.getLayoutParams();
        if (flag) {
            layoutParams.rightMargin -= (int) (fab1.getWidth() * x);
            layoutParams.bottomMargin -= (int) (fab1.getWidth() * y);
            fab1.setLayoutParams(layoutParams);
        }else{
            layoutParams.leftMargin -= (int) (fab1.getWidth() * x);
            layoutParams.bottomMargin -= (int) (fab1.getWidth() * y);
            fab1.setLayoutParams(layoutParams);

        }
        fab1.startAnimation(hide_fab_1);
        fab1.setClickable(false);
    }

}
