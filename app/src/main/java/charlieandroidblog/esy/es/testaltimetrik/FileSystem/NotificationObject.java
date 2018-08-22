package charlieandroidblog.esy.es.testaltimetrik.FileSystem;

import java.io.Serializable;

public class NotificationObject implements Serializable {

    String notificationType;
    String notificationDetails;

    public NotificationObject(String notificationType, String notificationDetails) {
        this.notificationType = notificationType;
        this.notificationDetails = notificationDetails;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getNotificationDetails() {
        return notificationDetails;
    }
}
