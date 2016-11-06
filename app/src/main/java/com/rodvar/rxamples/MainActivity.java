package com.rodvar.rxamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rxJavaHelloWorld();
        this.rxJavaMapExample();
    }

    private void rxJavaHelloWorld() {
        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));
    }

    private void rxJavaMapExample() {
        
    }
}
