package charlieandroidblog.esy.es.testaltimetrik.Activities.User;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class UserView implements IUser.View {

    AppCompatActivity context;

    public UserView(AppCompatActivity context) {
        this.context = context;
    }

    @Override
    public Button getEvacuationConfirmedBtn() {
        return null;
    }

    @Override
    public Button getHelpedNeededForEvacuationBtn() {
        return null;
    }

    @Override
    public Button getBecomeAVolunteerBtn() {
        return null;
    }
}
