package daniyaramangeldy.weathermap;

import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.concurrent.Executor;


public class LocationService extends IntentService {

    private FusedLocationProviderClient mFusedLocationClient;
    private Context context;

    public static final String ACTION_LOCATION = "action_location";
    public static final String EXTRA_MESSAGE = "extra_message";
    private static final String TAG = "LocationService";
    public static final String ACTION_ADDITION = "action_addition";
    public static final String EXTRA_MSG_1 = "EXTRA_MSG1";
    public static final String EXTRA_MSG_2 = "EXTRA_MSG2";


    public LocationService() {
        super("LocationService");
    }


    public static void startActionLocation(Context context) {
        Intent intent = new Intent(context, LocationService.class);
        intent.setAction(ACTION_LOCATION);
        intent.putExtra(EXTRA_MESSAGE, "Privet");
        context.startService(intent);
    }

    public static void startActionAddition(Context context, int first, int second) {
        Intent intent = new Intent(context, LocationService.class);
        intent.setAction(ACTION_ADDITION);
        intent.putExtra(EXTRA_MSG_1, first);
        intent.putExtra(EXTRA_MSG_2, second);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            switch (action) {
                case ACTION_LOCATION:
//                    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                        // TODO: Consider calling
//                        //    ActivityCompat#requestPermissions
//                        // here to request the missing permissions, and then overriding
//                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                        //                                          int[] grantResults)
//                        // to handle the case where the user grants the permission. See the documentation
//                        // for ActivityCompat#requestPermissions for more details.
//                        return;
//                    }
//                    Task<Location> locationTask = mFusedLocationClient.getLastLocation()
//                            .addOnSuccessListener(MapsActivity, new OnSuccessListener<Location>() {
//                                @Override
//                                public void onSuccess(Location location) {
//                                    // Got last known location. In some rare situations this can be null.
//                                    if (location != null) {
//                                        // ...
//                                    }
//                                }
//                            });

                    break;
                case ACTION_ADDITION:
                    int numberOne = intent.getIntExtra(EXTRA_MSG_1, 0);
                    int numberTwo = intent.getIntExtra(EXTRA_MSG_2, 0);
                    int d = Log.d(TAG, "onHandleIntent: "+add2Numbers(numberOne, numberTwo));
                    break;

            }
        }
    }

    private int add2Numbers(int first,int second){
        return first+second;
    }
}
