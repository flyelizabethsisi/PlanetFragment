package org.pursuit.fragmentsappfromscratch.network;

import org.pursuit.fragmentsappfromscratch.model.PlanetWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("JDVila/storybook/master/planets.json")
    Call<PlanetWrapper> getPlanets();
}
