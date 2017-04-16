package cv.yyh.com.myblockcanarytest;

import android.app.Application;
import android.content.Context;

import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;

/**
 * Created by Administrator on 2017/4/16 0016.
 */

public class MyApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }

    public static Context getAppContext() {
        return sContext;
    }

}
