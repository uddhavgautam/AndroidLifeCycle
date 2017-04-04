package edu.ualr.cpsc7398.UnderstandingLifecycles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) { //this is the entry point
        //add the log line
        Log.i(TAG, "##############");
        int count = 0;
        for (StackTraceElement stackTraceElement:  Thread.currentThread().getStackTrace()) {
            count++;
            Log.i(TAG, "\""+Thread.currentThread().getStackTrace()[2].getMethodName()+"\" "+count+" "+stackTraceElement.getMethodName());
        }; //end of log line

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MyBoundService.class);
        startService(intent);


        //to see all the methods (including super methods) at this time, you call use the java reflection as below
//        Log.i(TAG, "##############");
//        int count1 = 0;
//        for (Method method:  this.getClass().getMethods()) {
//            count1++;
//            count++;
//            Log.i(TAG, count1+" "+method);
//        }; //end of log line

        //At another time, after you add some other methods or android using GC removes some methods, you see your changed state (Bundle Snapshot) of your class
        //Because your bundle (i.e, the state of your class/activity) is the function of time.
    }


}
