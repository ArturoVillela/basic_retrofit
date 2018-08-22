package charlieandroidblog.esy.es.testaltimetrik.Activities.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import charlieandroidblog.esy.es.testaltimetrik.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //initMVP();
    }

    private void initMVP() {
        IUser.View view = new UserView(this);
        IUser.Presenter presenter = new UserPresenter(view,this);
    }
}
