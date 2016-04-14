package com.example.bogdan.vacanciedoumvp.application;

import android.app.Application;

import com.example.bogdan.vacanciedoumvp.di.ApiComponent;
import com.example.bogdan.vacanciedoumvp.di.DaggerApiComponent;
import com.example.bogdan.vacanciedoumvp.di.DaggerNetworkComponent;
import com.example.bogdan.vacanciedoumvp.di.NetworkComponent;
import com.example.bogdan.vacanciedoumvp.di.NetworkModule;
import com.example.bogdan.vacanciedoumvp.model.Constants;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public class VacancyApplication extends Application {
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();

    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constants.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
