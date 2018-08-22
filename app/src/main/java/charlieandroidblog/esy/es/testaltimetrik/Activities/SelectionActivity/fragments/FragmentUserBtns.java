package charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.ISelection;
import charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.SelectionPresenter;
import charlieandroidblog.esy.es.testaltimetrik.R;

public class FragmentUserBtns extends Fragment {

    private final String TAG = FragmentAgencyForm.class.getSimpleName();

    ISelection.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_select_user_type, container, false);

        view.findViewById(R.id.btn_navigate_to_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.bntUserPressed();
            }
        });

        view.findViewById(R.id.btn_nagivate_to_agency).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.btnAgencyPressed();
            }
        });

        return view;
    }

    public void setPresenterCallback(ISelection.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
        //this.layout = null;
    }

}
