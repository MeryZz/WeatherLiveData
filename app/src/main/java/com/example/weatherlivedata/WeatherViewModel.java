package com.example.weatherlivedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class WeatherViewModel extends ViewModel {

    private final WeatherModel weatherModel = new WeatherModel();

    public LiveData<Integer> getWeatherImageLiveData() {
        return Transformations.map(weatherModel.getWeatherLiveData(), weather -> {
            switch (weather) {
                case "sol":
                    return R.drawable.sol;
                case "nubes":
                    return R.drawable.nubes;
                case "lluvia":
                    return R.drawable.lluvia;
                case "viento":
                    return R.drawable.viento;
                default:
                    return R.drawable.cielo;
            }
        });
    }



}
