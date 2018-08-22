package charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity.ISelection;
import charlieandroidblog.esy.es.testaltimetrik.R;

public class FragmentAgencyForm extends Fragment {

    View viewContainerButtons;

    ISelection.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_form_submit, container, false);
        this.viewContainerButtons = view;



        viewContainerButtons.findViewById(R.id.btn_submit_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et = viewContainerButtons.findViewById(R.id.et_code);
                String code = et.getText().toString();
                presenter.btnSubmitCodePressed(code);
            }
        });

        viewContainerButtons.findViewById(R.id.btn_cancel_submit_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.btnCancelSubmitCodePressed();
            }
        });


        return view;
    }

    public void setPresenterCallback(ISelection.Presenter presenter){
        this.presenter = presenter;
    }


    public Button getButtonSendAgencyCode(){
        return this.viewContainerButtons.findViewById(R.id.btn_submit_code);
    }

    public Button getButtonCancel(){
        return this.viewContainerButtons.findViewById(R.id.btn_cancel_submit_code);
    }

    public String getTextCode(){
        TextView tv = this.viewContainerButtons.findViewById(R.id.et_code)  ;
        return tv.getText().toString();
    }


    public void showLoader(){
        this.viewContainerButtons.findViewById(R.id.fl_loader).setVisibility(View.VISIBLE);
        this.viewContainerButtons.findViewById(R.id.rl_container_submit_code).setVisibility(View.INVISIBLE);
    }
    public void hideLoader(){
        this.viewContainerButtons.findViewById(R.id.fl_loader).setVisibility(View.INVISIBLE);
        this.viewContainerButtons.findViewById(R.id.rl_container_submit_code).setVisibility(View.VISIBLE);
    }

    public void showErrorMsg(){
        Toast.makeText(this.getActivity(),"Error sending code",Toast.LENGTH_SHORT).show();
    }
}
