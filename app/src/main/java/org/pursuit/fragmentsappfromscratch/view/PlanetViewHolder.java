package org.pursuit.fragmentsappfromscratch.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.fragmentsappfromscratch.DisplayActivity;
import org.pursuit.fragmentsappfromscratch.R;
import org.pursuit.fragmentsappfromscratch.model.Planet;

public class PlanetViewHolder extends RecyclerView.ViewHolder {

    private TextView planetNameTextView;

    public static final String NAME_KEY = "name_key";
    public static final String NUMBER_KEY = "number_key";
    public static final String IMAGE_KEY = "image_key";

    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);
        planetNameTextView = itemView.findViewById(R.id.planet_name_textview);
    }

    public void onBind (final Planet planet) {
        planetNameTextView.setText(planet.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DisplayActivity.class);
                intent.putExtra(NAME_KEY, planet.getName());
                intent.putExtra(NUMBER_KEY, planet.getNumber());
                intent.putExtra(IMAGE_KEY, planet.getImage());
                itemView.getContext().startActivity(intent);

            }
        });
    }
}
