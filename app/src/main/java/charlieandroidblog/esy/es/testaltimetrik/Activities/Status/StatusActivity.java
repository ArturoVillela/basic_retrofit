package charlieandroidblog.esy.es.testaltimetrik.Activities.Status;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import charlieandroidblog.esy.es.testaltimetrik.FileSystem.NotificationObject;
import charlieandroidblog.esy.es.testaltimetrik.R;
import charlieandroidblog.esy.es.testaltimetrik.Rest.BeanResponseObject;

public class StatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        BeanResponseObject beanResponseObject = (BeanResponseObject)this.getIntent().getSerializableExtra("key");

        TextView tvNot = findViewById(R.id.tv_notification);
        TextView tvNotDetails = findViewById(R.id.tv_details);

        tvNot.setText(beanResponseObject.getNotification());
        tvNotDetails.setText(beanResponseObject.getNotificationDetails());


    }
}
