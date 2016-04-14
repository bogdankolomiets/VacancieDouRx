package com.example.bogdan.vacanciedoumvp.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.bogdan.vacanciedoumvp.R;
import com.example.bogdan.vacanciedoumvp.application.VacancyApplication;
import com.example.bogdan.vacanciedoumvp.base.VacancyPresenter;
import com.example.bogdan.vacanciedoumvp.model.Vacancy;
import com.example.bogdan.vacanciedoumvp.model.VacancyAdapter;
import com.example.bogdan.vacanciedoumvp.service.IVacancyView;
import com.example.bogdan.vacanciedoumvp.service.VacancyService;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public class MainActivity extends AppCompatActivity implements IVacancyView, VacancyAdapter.OnVacancyClickListener {
    @Inject
    VacancyService mService;

    private VacancyPresenter mVacancyPresenter;
    private VacancyAdapter mAdapter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        resolveDependency();

        ButterKnife.bind(MainActivity.this);

        configViews();

        mVacancyPresenter = new VacancyPresenter(MainActivity.this);
        mVacancyPresenter.onCreate();
    }

    private void resolveDependency() {
        ((VacancyApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    private void configViews() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new VacancyAdapter(getLayoutInflater(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVacancyPresenter.onResume();
        mVacancyPresenter.fetchFlowers();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle("Downloading List");
        mProgressDialog.setMessage("Please wait");
        mProgressDialog.show();
    }

    @Override
    public void onCompleted() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mProgressDialog.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onVacancies(List<Vacancy> vacancies) {
        mAdapter.addVacancies(vacancies);
    }

    @Override
    public Observable<List<Vacancy>> getVacancies() {
        return mService.getVacancies("epam-systems");
    }

    @Override
    public void onCLick(int position) {
        Vacancy selectedVacancy = mAdapter.getSelectedVacancy(position);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedVacancy.getLink()));
        startActivity(intent);
    }
}
