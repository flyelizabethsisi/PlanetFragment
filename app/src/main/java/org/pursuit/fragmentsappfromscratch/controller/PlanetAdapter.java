package org.pursuit.fragmentsappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentsappfromscratch.R;
import org.pursuit.fragmentsappfromscratch.model.Planet;
import org.pursuit.fragmentsappfromscratch.view.PlanetViewHolder;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {

    private List<Planet> planetList;

    public PlanetAdapter(List<Planet> planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new PlanetViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        holder.onBind(planetList.get(position));
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }
}
