package com.example.bogdan.vacanciedoumvp.di;

import com.example.bogdan.vacanciedoumvp.service.VacancyService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
@Module
public class ApiModel {

    @Provides
    @CustomScope
    VacancyService provideVacancyService(Retrofit retrofit) {
        return retrofit.create(VacancyService.class);
    }
}
