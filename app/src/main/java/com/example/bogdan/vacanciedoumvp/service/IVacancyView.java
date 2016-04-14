package com.example.bogdan.vacanciedoumvp.service;

import com.example.bogdan.vacanciedoumvp.model.Vacancy;

import java.util.List;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public interface IVacancyView {
    void onCompleted();

    void onError(String message);

    void onVacancies(List<Vacancy> vacancies);

    Observable<List<Vacancy>> getVacancies();
}
