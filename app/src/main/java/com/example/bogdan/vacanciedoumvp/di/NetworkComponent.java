package com.example.bogdan.vacanciedoumvp.di;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    Retrofit retrofit();
}
