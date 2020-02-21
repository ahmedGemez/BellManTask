package com.bahr.assessmenttask.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bahr.assessmenttask.R;
import com.bahr.assessmenttask.databinding.ItemAttractionBinding;
import com.bahr.assessmenttask.databinding.ItemEventBinding;
import com.bahr.assessmenttask.model.Attraction;
import com.bahr.assessmenttask.model.Event;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

  private List<Attraction> attractions;

  @NonNull
  @Override
  public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    ItemAttractionBinding itemAttractionBinding =
        DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
            R.layout.item_attraction, viewGroup, false);
    return new AttractionViewHolder(itemAttractionBinding);
  }

  @Override
  public void onBindViewHolder(@NonNull AttractionViewHolder attractionViewHolder, int i) {
    Attraction attraction = attractions.get(i);
    attractionViewHolder.itemAttractionBinding.setAttraction(attraction);
  }

  @Override
  public int getItemCount() {
    if (attractions != null) {

      return attractions.size();
    } else {
      return 0;
    }
  }

  public void setAttractionList(List<Attraction> attractions) {
    this.attractions = attractions;
    notifyDataSetChanged();
  }

  class AttractionViewHolder extends RecyclerView.ViewHolder {

    private ItemAttractionBinding itemAttractionBinding;

    public AttractionViewHolder(@NonNull ItemAttractionBinding itemAttractionBinding) {
      super(itemAttractionBinding.getRoot());

      this.itemAttractionBinding = itemAttractionBinding;
    }
  }
}
