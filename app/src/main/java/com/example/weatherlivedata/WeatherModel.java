package com.example.weatherlivedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class WeatherModel {
    private final MutableLiveData<String> weatherLiveData = new MutableLiveData<>();
    private final List<String> weatherStates = Arrays.asList("sol", "nubes", "lluvia", "viento");
    private final Random random = new Random();

    public WeatherModel() {
        emitWeatherUpdates();
    }

    private void emitWeatherUpdates() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String randomWeather = weatherStates.get(random.nextInt(weatherStates.size()));
                weatherLiveData.postValue(randomWeather);
            }
        }, 0, 2000); //Para que se actualice cada 2 segundos
    }

    public LiveData<String> getWeatherLiveData() {
        return weatherLiveData;
    }


}
