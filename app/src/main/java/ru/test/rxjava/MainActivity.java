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

    //private EditText edText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Integer> observable = Observable.just(1, 2, 4);

        //edText = findViewById(R.id.edText);

        observable.subscribe(integer -> Log.i(TAG, String.valueOf(integer)),
                throwable -> Log.i(TAG, "Error!"),
                () -> Log.i(TAG, "Completed!"));
    }
}