package charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity;

import android.widget.Button;

import charlieandroidblog.esy.es.testaltimetrik.FileSystem.NotificationObject;

public interface ISelection {

    interface Presenter{

        void startCheckingStatus();

        boolean statusInProgress();

        void launchStatusActivity(NotificationObject notificationObject);

        void terminatePresenter();

        //used as callbacks
        void bntUserPressed();

        //used as callbacks
        void btnAgencyPressed();

        //used as callbacks
        void btnSubmitCodePressed(String code);

        void btnCancelSubmitCodePressed();
    }

    interface View{

        void showNavigationPanel();

        void showCodeFormSubmitPanel();

        Button getUserButton();

        Button getAgencyButton();

        String getCodeForAgency();

        Button getSubmitCodeButton();

        Button getCancelAgencySelection();

        void showWorkingInBackgroundAnimation();

        void showMsg(String msg);

        void terminateView();
    }

}
