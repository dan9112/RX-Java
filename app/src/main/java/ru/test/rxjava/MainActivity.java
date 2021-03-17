package ru.test.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

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
                .subscribe(value -> Log.i(TAG, value));

        //For
        int[] items = new int[]{1, 2, 4, 8, 16, 32, 64};
        for (int value : items) {
            if (value >= 13) {
                String s = String.valueOf(value);
                Log.i(TAG, s);
            }
        }
    }
}