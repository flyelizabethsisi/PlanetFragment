package org.pursuit.fragmentsappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.fragmentsappfromscratch.controller.PlanetAdapter;
import org.pursuit.fragmentsappfromscratch.model.Planet;
import org.pursuit.fragmentsappfromscratch.model.PlanetWrapper;
import org.pursuit.fragmentsappfromscratch.network.APIService;
import org.pursuit.fragmentsappfromscratch.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        final Retrofit retrofit = RetrofitSingleton.getInstance();
        APIService apiService = retrofit.create(APIService.class);
        Call<PlanetWrapper> resultsCall = apiService.getPlanets();
        resultsCall.enqueue(new Callback<PlanetWrapper>() {
            @Override
            public void onResponse(Call<PlanetWrapper> call, Response<PlanetWrapper> response) {
                Log.d("EvelynActivity", response.body().getPlanets().get(0).getName());
                List<Planet> planetList = response.body().getPlanets();
                adapter = new PlanetAdapter(planetList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(linearLayoutManager);


            }

            @Override
            public void onFailure(Call<PlanetWrapper> call, Throwable t) {
                Log.d("epicfail", "onFailure: " + t.toString());
            }
        });

    }
}
