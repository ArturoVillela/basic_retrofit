package charlieandroidblog.esy.es.testaltimetrik.Activities.User;

import android.content.Context;


//TODO finish retrofit calls with corresponding notification value.
public class UserPresenter implements IUser.Presenter {

    IUser.View view;
    Context context;

    public UserPresenter(IUser.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void evacuationConfirmedRetrofit() {

    }

    @Override
    public void requestHelpRetrofit() {

    }

    @Override
    public void becomeAVolunteerRetrofit() {

    }
}
