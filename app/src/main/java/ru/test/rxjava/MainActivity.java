package ru.test.rxjava;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static android.os.AsyncTask.execute;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RxJava
        Observable.just(1, 2, 4, 8, 16, 32, 64)
                .filter(integer -> integer >= 13)
                .map(String::valueOf)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value -> Log.i(TAG, value));


        //For
        Handler HANDLER = new Handler();

        execute(() -> {
            int[] items = new int[]{1, 2, 4, 8, 16, 32, 64};
            for (int value : items) {
                if (value >= 13) {
                    String s = String.valueOf(value);
                    HANDLER.post(() -> Log.i(TAG, s));
                }
            }
        });
    }
}