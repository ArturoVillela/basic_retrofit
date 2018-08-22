package charlieandroidblog.esy.es.testaltimetrik.FileSystem;

import android.content.Context;

import charlieandroidblog.esy.es.testaltimetrik.Utilities.Utility;

public interface IFileSystem {

    boolean isThereARequestInProgress();

    boolean setUserRequestStatus(Utility.USER_STATUS user_status, String details);

    NotificationObject getCurrentNotificationInSystem();

    void clearStatus();

}
