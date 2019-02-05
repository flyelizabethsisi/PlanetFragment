package org.pursuit.fragmentsappfromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.fragmentsappfromscratch.view.PlanetViewHolder;

public class DisplayActivity extends AppCompatActivity implements FragmentInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        Intent intent = getIntent();
        String nameString = intent.getStringExtra(PlanetViewHolder.NAME_KEY);
        String numberString = String.valueOf(intent.getIntExtra(PlanetViewHolder.NUMBER_KEY, 0));
        String imageString = intent.getStringExtra(PlanetViewHolder.IMAGE_KEY);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, DisplayFragment.newInstance(nameString, numberString, imageString))
                .addToBackStack(null)
                .commit();
    }
}
