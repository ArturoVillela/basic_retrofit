package charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import charlieandroidblog.esy.es.testaltimetrik.Activities.Agency.AgencyActivity;
import charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.fragments.FragmentAgencyForm;
import charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.fragments.FragmentUserBtns;
import charlieandroidblog.esy.es.testaltimetrik.Activities.Status.StatusActivity;
import charlieandroidblog.esy.es.testaltimetrik.Activities.User.UserActivity;
import charlieandroidblog.esy.es.testaltimetrik.FileSystem.NotificationObject;
import charlieandroidblog.esy.es.testaltimetrik.FileSystem.RequestStatus;
import charlieandroidblog.esy.es.testaltimetrik.R;
import charlieandroidblog.esy.es.testaltimetrik.Rest.BeanResponseObject;
import charlieandroidblog.esy.es.testaltimetrik.Rest.IEndPointAPI;
import charlieandroidblog.esy.es.testaltimetrik.Rest.RestAdapterAPI;
import charlieandroidblog.esy.es.testaltimetrik.Rest.RetrofitConstants;
import charlieandroidblog.esy.es.testaltimetrik.Utilities.Utility;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectionPresenter implements ISelection.Presenter {

    private final String TAG = SelectionPresenter.class.getSimpleName();

    ISelection.View view;
    AppCompatActivity context;

    public SelectionPresenter(AppCompatActivity context, ISelection.View view) {
        this.context = context;
        this.view = view;

        startCheckingStatus();
    }

    /**
     * should create a bundle object for passing the Notification Object
     */
    @Override
    public void startCheckingStatus() {
        //we access our filesystem.
        RequestStatus status = new RequestStatus(context.getApplicationContext());

        if (status.isThereARequestInProgress()) {
            NotificationObject notificationObject = status.getCurrentNotificationInSystem();
            launchStatusActivity(notificationObject);
            this.terminatePresenter();
        } else {
            Log.d(TAG, "startCheckingStatus: load navigation buttons fragment.. ");
            loadNavigationButtons();
            //initNavigationButtons();
        }

    }

    @Override
    public boolean statusInProgress() {
        return false;
    }

    @Override
    public void launchStatusActivity(NotificationObject notificationObject) {
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Utility.NOTIFICATION_OBJECT, notificationObject);
//
//        Intent intent = new Intent(context, StatusActivity.class);
//        intent.putExtras(bundle);
//
//        context.startActivity(intent);
    }

    private void loadNavigationButtons() {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentUserBtns fragmentUserBtns = new FragmentUserBtns();

        fragmentUserBtns.setPresenterCallback(this);


        fragmentTransaction.replace(R.id.framelayout_container, fragmentUserBtns);
        fragmentTransaction.commit();

    }

    private void navigateToAgency() {
        Log.d(TAG, "navigateToAgency: navegamos hacia la activity de usuario");
    }

    private void loadAgencyForm(){
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentAgencyForm fragmentAgencyForm = new FragmentAgencyForm();
        fragmentAgencyForm.setPresenterCallback(this);

        fragmentTransaction.replace(R.id.framelayout_container, fragmentAgencyForm);
        fragmentTransaction.commit();
    }

    private void checkForValidCodeRetrofit(String code){

        //TODO we should send the notification in a service, in case the activity gets destroy..
        Log.d(TAG, "checkForValidCodeRetrofit:  aki hacemos la validacion con retrofit for code:"+code);


        Map<String, String> data = new HashMap<>();
        data.put("code", code);

        logInterceptor();

        IEndPointAPI endPointApi =  new RestAdapterAPI().makeRetrofitCall();

        //si no hay parametros en url utilizar ==> Call<BeanResponseObject> notificationResponse = endPointApi.getResponseForNotificationMade();

        Call<BeanResponseObject> notificationResponse = endPointApi.getResponseForNotificationMade(data);

        notificationResponse.enqueue(new Callback<BeanResponseObject>() {
            @Override
            public void onResponse(Call<BeanResponseObject> call, Response<BeanResponseObject> response) {
                //TODO save our response in our local FileSystem, then advance to Notification Activity, we should create and pass a notification obj

                if (response.body() == null) {
                    errorOnCodeSubmition();
                    return;
                }
                Log.d(TAG, "onResponse: response:"+response.body().toString());
                BeanResponseObject bean = response.body();
                launchNotificationAcvitity(bean);

            }

            @Override
            public void onFailure(Call<BeanResponseObject> call, Throwable t) {
                //TODO define what to do in case the communication failed...
                Log.d(TAG, "onFailure:  not defined a real service for it");
                //view.showMsg("failed to communicate to the server.");
                errorOnCodeSubmition();
            }
        });
    }

    private void logInterceptor(){
        HttpLoggingInterceptor logg = new HttpLoggingInterceptor();
        logg.setLevel(HttpLoggingInterceptor.Level.BODY);

    }

    private void errorOnCodeSubmition(){
        FragmentAgencyForm fragment = (FragmentAgencyForm) context.getSupportFragmentManager().getFragments().get(0);
        fragment.hideLoader();
        fragment.showErrorMsg();
    }

    @Override
    public void terminatePresenter() {
        view.terminateView();
        this.view = null;
        this.context = null;

    }

    @Override
    public void bntUserPressed() {
        Log.d(TAG, "bntUserPressed: ");
        context.startActivity(new Intent(context,UserActivity.class));
    }

    @Override
    public void btnAgencyPressed() {
        Log.d(TAG, "btnAgencyPressed: ");
        loadAgencyForm();
    }

    @Override
    public void btnSubmitCodePressed(String code) {
        Log.d(TAG, "btnSubmitCodePressed: code: <<"+code+">>");

        FragmentAgencyForm fragment = (FragmentAgencyForm) context.getSupportFragmentManager().getFragments().get(0);

        if (fragment!=null){
            Log.d(TAG, "btnSubmitCodePressed: we got the fragment..");
            fragment.showLoader();
            checkForValidCodeRetrofit(code);
        }
    }

    @Override
    public void btnCancelSubmitCodePressed() {
        Log.d(TAG, "btnCancelSubmitCodePressed: ");
        loadNavigationButtons();
    }

    private void launchUserActivity() {
        context.startActivity(new Intent(context, UserActivity.class));
        //terminatePresenter();
    }

    private void launchAgencyActivity() {
        context.startActivity(new Intent(context, AgencyActivity.class));
        //terminatePresenter();
    }

    private void launchNotificationAcvitity(BeanResponseObject object){
        Intent i = new Intent(context,StatusActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("key",object);
        i.putExtras(bundle);

        context.startActivity(i);
    }
}
