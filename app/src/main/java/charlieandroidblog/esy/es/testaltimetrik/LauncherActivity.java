package charlieandroidblog.esy.es.testaltimetrik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.SelectionActivity;


/**
 * Will show basic information as an image, maybe a simple continue button, may be an automatic launcher...
 */
public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        initSelectionActivity();
    }

    //TODO define what is should show and what it should do.
    private void initSelectionActivity() {
        startActivity(new Intent(LauncherActivity.this, SelectionActivity.class));
    }
}
