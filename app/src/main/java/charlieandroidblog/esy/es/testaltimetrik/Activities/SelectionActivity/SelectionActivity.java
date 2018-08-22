package charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.Serializable;

import charlieandroidblog.esy.es.testaltimetrik.R;

public class SelectionActivity extends AppCompatActivity implements Serializable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_use_app);
        initMVP();

    }

    //TODO inject this classes using Dagger2
    private void initMVP() {
        SelectionView view = new SelectionView(this);
        SelectionPresenter presenter = new SelectionPresenter(this, view);
    }


}
