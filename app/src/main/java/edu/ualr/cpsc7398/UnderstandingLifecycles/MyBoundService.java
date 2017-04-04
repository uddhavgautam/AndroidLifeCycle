package edu.ualr.cpsc7398.UnderstandingLifecycles;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;


public class MyBoundService extends Service {
    private String TAG = "MyBoundService";
    public MyBoundService() {
    }

    @Override
    public void onCreate() {
    //add the log line
        Log.i(TAG, "##############");
        int count = 0;
        for (StackTraceElement stackTraceElement:  Thread.currentThread().getStackTrace()) {
            count++;
            Log.i(TAG, "\""+Thread.currentThread().getStackTrace()[2].getMethodName()+"\" "+count+" "+stackTraceElement.getMethodName());
        }; //end of log line

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //add the log line
        Log.i(TAG, "##############");
        int count = 0;
        for (StackTraceElement stackTraceElement:  Thread.currentThread().getStackTrace()) {
            count++;
            Log.i(TAG, "\""+Thread.currentThread().getStackTrace()[2].getMethodName()+"\" "+count+" "+stackTraceElement.getMethodName());
        }; //end of log line



//        Log.i(TAG, "##############");
//        int count1 = 0;
//        for (Method method:  this.getClass().getMethods()) { //gets all the public methods including inherited
//            count1++;
//            count++;
//            Log.i(TAG, count1+" "+method);
//        }; //end of log line

        //you don't see onStart() called by above code snippet


        int a =  super.onStartCommand(intent, flags, startId); //this calls onStart() method, so you don't need to write in this class

        //after you call the super.onStartCommand, you update your state (snapshot)


        Log.i(TAG, "##############");
        int count1 = 0;
        for (Method method:  this.getClass().getMethods()) { //gets all the public methods including inherited
            count1++;
            count++;
            Log.i(TAG, count1+" "+method);
        }; //end of log line

        //you can now see, onStart() of this MyBoundService is called
        return a;
    }

    @Override
    public IBinder onBind(Intent intent) {
        //add the log line
        Log.i(TAG, "##############");
        int count = 0;
        for (StackTraceElement stackTraceElement:  Thread.currentThread().getStackTrace()) {
            count++;
            Log.i(TAG, "\""+Thread.currentThread().getStackTrace()[2].getMethodName()+"\" "+count+" "+stackTraceElement.getMethodName());
        }; //end of log line





        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
