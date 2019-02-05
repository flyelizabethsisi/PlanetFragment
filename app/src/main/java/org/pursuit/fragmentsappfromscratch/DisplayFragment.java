package org.pursuit.fragmentsappfromscratch;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.fragmentsappfromscratch.view.PlanetViewHolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    private FragmentInterface fragmentInterface;
    public static final String NAME_KEY = "name_key";
    public static final String NUMBER_KEY = "number_key";
    public static final String IMAGE_KEY = "image_key";


    public static DisplayFragment newInstance(String nameString, String numberString, String urlString) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, nameString);
        args.putString(NUMBER_KEY, numberString);
        args.putString(IMAGE_KEY, urlString);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_display, container, false);
        TextView nameTextView = rootView.findViewById(R.id.display_name_textview);
        TextView numberTextView = rootView.findViewById(R.id.display_number_textview);
        ImageView imageView = rootView.findViewById(R.id.display_imageview);


            nameTextView.setText(getArguments().getString(NAME_KEY));
            numberTextView.setText(String.valueOf(getArguments().getString(NUMBER_KEY)));
            Picasso.get()
                    .load(getArguments().getString(IMAGE_KEY))
                    .into(imageView);


        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
