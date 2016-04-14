package com.example.bogdan.vacanciedoumvp.base;

import com.example.bogdan.vacanciedoumvp.model.Vacancy;
import com.example.bogdan.vacanciedoumvp.service.IVacancyView;

import java.util.List;

import rx.Observer;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public class VacancyPresenter extends BasePrenter implements Observer<List<Vacancy>> {

    private IVacancyView mVacancyView;

    public VacancyPresenter(IVacancyView vacancyView) {
        mVacancyView = vacancyView;
    }


    @Override
    public void onCompleted() {
        mVacancyView.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mVacancyView.onError(e.getMessage());
    }

    @Override
    public void onNext(List<Vacancy> vacancies) {
        mVacancyView.onVacancies(vacancies);
    }

    public void fetchFlowers() {
        unSubscribeAll();
        subscribe(mVacancyView.getVacancies(), this);
    }
}
