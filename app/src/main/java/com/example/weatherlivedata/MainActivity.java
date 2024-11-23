package com.example.weatherlivedata;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private WeatherViewModel weatherViewModel;
    private ImageView imagenViewWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenViewWeather = findViewById(R.id.ImagenWeather);
        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);

        //Para ver los cambios en el liveData del ViewModel
        weatherViewModel.getWeatherImageLiveData().observe(this, imageResId -> {
            //Para actualizar las imágenes en la vista
            imagenViewWeather.setImageResource(imageResId);
        });
    }

}