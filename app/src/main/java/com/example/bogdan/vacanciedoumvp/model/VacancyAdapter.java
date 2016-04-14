package com.example.bogdan.vacanciedoumvp.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bogdan.vacanciedoumvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public class VacancyAdapter extends RecyclerView.Adapter<VacancyAdapter.Holder> {
    private final LayoutInflater mLayoutInflater;
    private List<Vacancy> mVacancies;
    private OnVacancyClickListener mListener;

    public VacancyAdapter(LayoutInflater layoutInflater, OnVacancyClickListener listener) {
        mLayoutInflater = layoutInflater;
        mListener = listener;
        mVacancies = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mLayoutInflater.inflate(R.layout.row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Vacancy vacancy = mVacancies.get(position);

        holder.mTitle.setText(vacancy.getTitle());
        holder.mCity.setText(vacancy.getCity());
        holder.mSalary.setText(vacancy.getSalary());
        holder.mDescription.setText(vacancy.getDescription());

    }

    @Override
    public int getItemCount() {
        return mVacancies.size();
    }

    public void addVacancies(List<Vacancy> vacancies) {

        mVacancies.addAll(vacancies);
        notifyDataSetChanged();
    }

    public Vacancy getSelectedVacancy(int position) {
        return mVacancies.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitle;
        private TextView mCity;
        private TextView mSalary;
        private TextView mDescription;


        public Holder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.title);
            mCity = (TextView) itemView.findViewById(R.id.city);
            mSalary = (TextView) itemView.findViewById(R.id.salary);
            mDescription = (TextView) itemView.findViewById(R.id.description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onCLick(getLayoutPosition());
        }
    }

    public interface OnVacancyClickListener {
        void onCLick(int position);
    }
}
