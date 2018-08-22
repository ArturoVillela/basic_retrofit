package charlieandroidblog.esy.es.testaltimetrik.Rest;

import java.io.Serializable;

public class BeanResponseObject implements Serializable{

    String notification;
    String notificationDetails;
    int id;

    public BeanResponseObject(String notification, String notificationDetails, int id) {
        this.notification = notification;
        this.notificationDetails = notificationDetails;
        this.id = id;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getNotificationDetails() {
        return notificationDetails;
    }

    public void setNotificationDetails(String notificationDetails) {
        this.notificationDetails = notificationDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
