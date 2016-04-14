package com.example.bogdan.vacanciedoumvp.di;

import com.example.bogdan.vacanciedoumvp.view.MainActivity;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
@CustomScope
@Component(modules = ApiModel.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
