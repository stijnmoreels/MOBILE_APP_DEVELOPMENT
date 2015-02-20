package be.howest.nmct.stopafstandandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Stijn on 19/02/2015.
 */
public class StopAfstandFragment extends Fragment {
    private EditText speed;
    private EditText response_time;
    private RadioButton droog_wegdek;
    private Button calculate_button;
    private TextView your_stop_distance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stop_afstand, container, false);
        speed = (EditText)v.findViewById(R.id.input_speed);
        response_time = (EditText)v.findViewById(R.id.response_time);
        droog_wegdek = (RadioButton)v.findViewById(R.id.droog_wegdek);
        calculate_button = (Button)v.findViewById(R.id.calculate_button);
        your_stop_distance = (TextView)v.findViewById(R.id.your_stop_distance);

        calculate_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showInfo();
            }
        });
        return v;
    }

    private void showInfo() {
        StopAfstandInfo info = new StopAfstandInfo();
        info.setSnelheid(Integer.parseInt(speed.getText().toString()));
        info.setReactietijd(Float.parseFloat(response_time.getText().toString()));
        StopAfstandInfo.Wegtype type = droog_wegdek.isChecked() ? StopAfstandInfo.Wegtype.WEGDEK_DROOG : StopAfstandInfo.Wegtype.WEGDEK_NAT;
        info.setWegtype(type);
        your_stop_distance.setText(info.getStopafstand() + " meter");

        Toast.makeText(getActivity(), info.getStopafstand() + "meter", Toast.LENGTH_SHORT).show();
    }
}
