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
public class AnniversaryFragment extends Fragment {

    TextView tvAnni;
    Button btnAnniEdit;
    SharedPreferences mypref;


    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View anniView =  inflater.inflate(R.layout.fragment_anniversary, container, false);
        btnAnniEdit = anniView.findViewById(R.id.btnAnniEdit);
        tvAnni = anniView.findViewById(R.id.tvAnni);

        final LinearLayout passAnni = (LinearLayout) inflater.inflate(R.layout.passanni, null);
        final EditText etAnni = (EditText) passAnni
                .findViewById(R.id.etAnni);

        mypref = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        btnAnniEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Please Enter")
                        .setView(passAnni)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                tvAnni.setText(etAnni.getText().toString());
                                SharedPreferences.Editor editor = mypref.edit();
                                editor.putString("anni", etAnni.getText().toString());
                                editor.commit();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        String anni = mypref.getString("anni", "");
        tvAnni.setText(anni);
        return anniView;
    }

}
