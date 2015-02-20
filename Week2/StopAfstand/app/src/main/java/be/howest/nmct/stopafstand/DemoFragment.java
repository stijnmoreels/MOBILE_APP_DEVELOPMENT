package be.howest.nmct.stopafstand;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Stijn on 19/02/2015.
 */
public class DemoFragment extends Fragment {
    private Button ok_button;
    private EditText editText;
    private TextView outputText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);
        ok_button = (Button)v.findViewById(R.id.ok_button);
        editText = (EditText)v.findViewById(R.id.editText);
        outputText = (TextView)v.findViewById(R.id.outputText);

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toonInfo();
            }
        });
        return v;
    }

    private void toonInfo() {
        String naam = editText.getText().toString();
        outputText.setText("Correct antwoord");
    }
}
