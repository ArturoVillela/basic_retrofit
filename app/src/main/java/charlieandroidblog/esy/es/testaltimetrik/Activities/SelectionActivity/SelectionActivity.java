package charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import charlieandroidblog.esy.es.testaltimetrik.Activities.Agency.AgencyActivity;
import charlieandroidblog.esy.es.testaltimetrik.Activities.User.UserActivity;
import charlieandroidblog.esy.es.testaltimetrik.R;

public class SelectionActivity extends AppCompatActivity {

    @BindView(R.id.btn_user)
    Button btnUser;

    @BindView(R.id.btn_agency)
    Button btnAgency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_use_app);
        ButterKnife.bind(this);
        init();
    }

    /**
     * if there is a pending call, it goes to the manager
     */
    private void init() {
        if (!statusInProgress()){
            initSelection();
        }else{
            startStatusRequestActivity();
        }
    }

    //TODO validate with current filesystem if there is a petition in place..
    private void startStatusRequestActivity() {

    }

    /**
     * help app user to mark wether they are an agancy or a user.
     */
    private void initSelection() {
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(intent);
            }
        });
        btnAgency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgencyActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Read filesystem to see if there is a call pending to be resolved
     * @return true if there is a request pending, false otherwise.
     */
    private boolean statusInProgress() {
        return false;
    }
}
