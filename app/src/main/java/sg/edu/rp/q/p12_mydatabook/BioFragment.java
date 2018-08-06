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
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    Button btnEdit;
    TextView tvBlood;
    SharedPreferences mypref;


    public BioFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View bioView = inflater.inflate(R.layout.fragment_bio, container, false);
        btnEdit = bioView.findViewById(R.id.btnEdit);
        tvBlood = bioView.findViewById(R.id.tvBlood);
        final LinearLayout passBio = (LinearLayout) inflater.inflate(R.layout.passbio, null);
        final EditText etPassphrase = (EditText) passBio
                .findViewById(R.id.editTextPassPhrase);

        mypref= this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Please Enter")
                        .setView(passBio)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                tvBlood.setText(etPassphrase.getText().toString());
                                SharedPreferences.Editor editor = mypref.edit();
                                editor.putString("bio", etPassphrase.getText().toString());
                                editor.commit();

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        String bio = mypref.getString("bio", "");
        tvBlood.setText(bio);
        return bioView;

    }


}
