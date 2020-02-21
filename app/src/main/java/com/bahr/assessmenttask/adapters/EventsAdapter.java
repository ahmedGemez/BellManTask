package com.bahr.assessmenttask.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bahr.assessmenttask.R;
import com.bahr.assessmenttask.databinding.ItemEventBinding;
import com.bahr.assessmenttask.databinding.ItemHotspotsBinding;
import com.bahr.assessmenttask.model.Event;
import com.bahr.assessmenttask.model.HotSpot;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

  private List<Event> events;

  @NonNull
  @Override
  public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    ItemEventBinding itemEventBinding =
        DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
            R.layout.item_event, viewGroup, false);
    return new EventsViewHolder(itemEventBinding);
  }

  @Override
  public void onBindViewHolder(@NonNull EventsViewHolder eventsViewHolder, int i) {
    Event event = events.get(i);
    eventsViewHolder.itemEventBinding.setEvents(event);
  }

  @Override
  public int getItemCount() {
    if (events != null) {

      return events.size();
    } else {
      return 0;
    }
  }

  public void setEventsList(List<Event> events) {
    this.events = events;
    notifyDataSetChanged();
  }

  class EventsViewHolder extends RecyclerView.ViewHolder {

    private ItemEventBinding itemEventBinding;

    public EventsViewHolder(@NonNull ItemEventBinding itemEventBinding) {
      super(itemEventBinding.getRoot());

      this.itemEventBinding = itemEventBinding;
    }
  }
}
