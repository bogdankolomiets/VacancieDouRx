package com.example.bogdan.vacanciedoumvp.service;

import com.example.bogdan.vacanciedoumvp.model.Vacancy;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public interface VacancyService {

    @GET("companies/{company}/vacancies/export/")
    Observable<List<Vacancy>> getVacancies(@Path("company") String company);
}
