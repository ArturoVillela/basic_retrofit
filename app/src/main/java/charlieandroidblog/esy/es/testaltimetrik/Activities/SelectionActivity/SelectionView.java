package charlieandroidblog.esy.es.testaltimetrik.Activities.SelectionActivity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

import charlieandroidblog.esy.es.testaltimetrik.R;

public class SelectionView implements ISelection.View, Serializable {

    SelectionActivity context;

    public SelectionView(SelectionActivity context) {
        this.context = context;

    }

    @Override
    public String getCodeForAgency() {
        return null;
    }

    @Override
    public Button getSubmitCodeButton() {
        return context.findViewById(R.id.btn_submit_code);
    }

    @Override
    public Button getCancelAgencySelection() {
        return context.findViewById(R.id.btn_cancel_submit_code);
    }

    @Override
    public void showWorkingInBackgroundAnimation() {

    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNavigationPanel() {
        context.findViewById(R.id.ll_navigation_buttons).setVisibility(View.VISIBLE);
        context.findViewById(R.id.rl_container_submit_code).setVisibility(View.INVISIBLE);
    }

    @Override
    public void showCodeFormSubmitPanel() {
        context.findViewById(R.id.ll_navigation_buttons).setVisibility(View.INVISIBLE);
        context.findViewById(R.id.rl_container_submit_code).setVisibility(View.VISIBLE);
    }

    @Override
    public Button getUserButton() {
        return context.findViewById(R.id.btn_navigate_to_user);
    }

    @Override
    public Button getAgencyButton() {
        return context.findViewById(R.id.btn_nagivate_to_agency);
    }

    @Override
    public void terminateView() {

    }


}
