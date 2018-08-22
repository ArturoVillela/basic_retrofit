package charlieandroidblog.esy.es.testaltimetrik.FileSystem;

import android.content.Context;
import android.content.SharedPreferences;

import charlieandroidblog.esy.es.testaltimetrik.Utilities.Utility;

public class RequestStatus implements IFileSystem{

    private final String SHARED_PREF = "TEST_ALTIMETRIK";

    private Context context;

    private final String notificationType = "NOT_TYPE";
    private final String notificationDetails = "NOT_DETAILS";


    public RequestStatus(Context context) {
        this.context = context;
    }

    @Override
    public boolean isThereARequestInProgress() {
        SharedPreferences sp = getSharedPreferences();
        String notType = sp.getString(notificationType, "");
        if (notType.length()>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean setUserRequestStatus(Utility.USER_STATUS user_status, String notificationDetails) {
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(notificationType, user_status.toString());
        editor.putString(notificationDetails, notificationDetails);
        editor.commit();
        return false;
    }

    /**
     * Should alwasy call isThereARequestInProgress() before calling getCurrentNotificationInSystem()
     * @return NotificationObject
     */
    @Override
    public NotificationObject getCurrentNotificationInSystem() {
        if (isThereARequestInProgress()){
            SharedPreferences sp = getSharedPreferences();
            String notType = sp.getString(notificationType, "");
            String notDetails = sp.getString(notificationDetails, "");
            NotificationObject notificationObject = new NotificationObject(notType,notDetails);
            return notificationObject;
        }
        return null;
    }

    @Override
    public void clearStatus() {
        SharedPreferences sp = getSharedPreferences();
        sp.edit().clear().commit();
    }

    private SharedPreferences getSharedPreferences(){
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREF, context.getApplicationContext().MODE_PRIVATE);
        return sp;
    }

}
