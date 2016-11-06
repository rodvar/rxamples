package com.rodvar.rxamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.rxJavaHelloWorld();

        this.rxJavaMapExample();
        this.rxJavaScanExample();
        this.rxJavaWindowExample();
    }

    private void rxJavaHelloWorld() {
        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));
    }

    /**
     * Main rx transformation function
     */
    private void rxJavaMapExample() {
        Observable.just("Hello, world!")
                .map(s -> s.replaceAll("o", " @ "))
                .subscribe(s -> System.out.println(s));
    }

    /**
     * Scans elements emited by the caller observable folding the previous result with the next item.
     * First item is left as it is.
     */
    private void rxJavaScanExample() {
        Observable.from(new Integer[]{0, 3, 5, 62, 4, 3, -77})
                .scan( (i1,i2) -> i1 +i2)
                .subscribe(i -> System.out.println(i));
    }

    /**
     *
     */
    private void rxJavaWindowExample() {
        Observable.from(new Integer[]{0, 3, 5, 62, 4, 3, -77})
                .scan( (i1,i2) -> i1 +i2)
                .window(1000l, TimeUnit.MILLISECONDS, 3)
                .map(i -> String.format("%s emmited: %s", System.currentTimeMillis(), i.toString()))
                .subscribe(s -> System.out.println(s));
    }
}
