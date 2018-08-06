package sg.edu.rp.q.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {

    Button btnFragVacci;
    TextView tvVacci;
    SharedPreferences mypref;


    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vacciView =  inflater.inflate(R.layout.fragment_vaccination, container, false);
        btnFragVacci = vacciView.findViewById(R.id.btnFragVacci);
        tvVacci = vacciView.findViewById(R.id.tvVacci);
        final LinearLayout passVacci = (LinearLayout) inflater.inflate(R.layout.passvacci, null);
        final EditText etVacci = (EditText) passVacci
                .findViewById(R.id.etVacci);

        mypref = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        btnFragVacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Please Enter")
                        .setView(passVacci)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                tvVacci.setText(etVacci.getText().toString());
                                SharedPreferences.Editor editor = mypref.edit();
                                editor.putString("vacci", etVacci.getText().toString());
                                editor.commit();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        String vacci = mypref.getString("vacci", "");
        tvVacci.setText(vacci);
        return vacciView;
    }

}
