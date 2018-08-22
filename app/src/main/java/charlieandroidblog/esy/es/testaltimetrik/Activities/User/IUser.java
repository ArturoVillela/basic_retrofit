package charlieandroidblog.esy.es.testaltimetrik.Activities.User;

import android.widget.Button;

public interface IUser {

    interface Presenter{

        void evacuationConfirmedRetrofit();

        void requestHelpRetrofit();

        void becomeAVolunteerRetrofit();

    }

    interface View{

        Button getEvacuationConfirmedBtn();

        Button getHelpedNeededForEvacuationBtn();

        Button getBecomeAVolunteerBtn();
    }
}
