package app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyAppcation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
