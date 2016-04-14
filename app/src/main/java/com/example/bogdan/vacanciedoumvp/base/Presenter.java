package com.example.bogdan.vacanciedoumvp.base;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 13.04.2016
 */
public interface Presenter {

    void onCreate();
    void onPause();
    void onResume();
    void onDestroy();
}
