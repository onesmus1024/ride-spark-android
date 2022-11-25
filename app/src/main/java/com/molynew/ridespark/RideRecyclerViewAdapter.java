package com.molynew.ridespark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RideRecyclerViewAdapter extends RecyclerView.Adapter<RideRecyclerViewAdapter.ViewHolder> {

    List<Ride> rides;
    Context context;

    public RideRecyclerViewAdapter(List<Ride> rides, Context context) {
        this.rides = rides;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_ride_activity,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        Glide.with(context).load(products.get(position).getImageUrl()).into(holder.iv_product_image);
        holder.status.setText(rides.get(position).getStatus());
        holder.meetingPoint.setText(rides.get(position).getMeetingPoint());
        holder.destination.setText(rides.get(position).getDestination());
        holder.route.setText(rides.get(position).getRoute());
        holder.time.setText(rides.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return rides.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView status;
        TextView route;
        TextView destination;
        TextView meetingPoint;
        TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            status =itemView.findViewById(R.id.status);
            route = itemView.findViewById(R.id.route);
            destination = itemView.findViewById(R.id.destination_value);
            meetingPoint = itemView.findViewById(R.id.meet_value);
            time = itemView.findViewById(R.id.time_value);
        }
    }
}
