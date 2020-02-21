package com.bahr.assessmenttask.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.bahr.assessmenttask.R;
import com.bahr.assessmenttask.databinding.ItemHotspotsBinding;
import com.bahr.assessmenttask.model.HotSpot;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class HotSpotsAdapter extends RecyclerView.Adapter<HotSpotsAdapter.HotSpotViewHolder> {

  private List<HotSpot> hotSpots;

  @NonNull
  @Override
  public HotSpotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    ItemHotspotsBinding itemHotspotsBinding =
        DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
            R.layout.item_hotspots, viewGroup, false);
    return new HotSpotViewHolder(itemHotspotsBinding);
  }

  @Override
  public void onBindViewHolder(@NonNull HotSpotViewHolder hotSpotViewHolder, int i) {
    HotSpot hotSpot = hotSpots.get(i);
    hotSpotViewHolder.itemHotspotsBinding.setHotSpots(hotSpot);
  }

  @Override
  public int getItemCount() {
    if (hotSpots != null) {

      return hotSpots.size();
    } else {
      return 0;
    }
  }

  public void setHotSpotList(List<HotSpot> hotSpotList) {
    this.hotSpots = hotSpotList;
    notifyDataSetChanged();
  }

  class HotSpotViewHolder extends RecyclerView.ViewHolder {

    private ItemHotspotsBinding itemHotspotsBinding;

    public HotSpotViewHolder(@NonNull ItemHotspotsBinding itemHotspotsBinding) {
      super(itemHotspotsBinding.getRoot());

      this.itemHotspotsBinding = itemHotspotsBinding;
    }
  }
}
