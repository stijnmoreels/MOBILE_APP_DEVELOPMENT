package be.howest.nmct.bmicalculatorandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Stijn on 19/02/2015.
 */
public class BMICalculatorFragment extends Fragment {
    private EditText your_mass;
    private EditText your_height;
    private TextView your_category;
    private TextView your_bmi;
    private Button calculate_button;
    private ImageView image;
    private BMIInfo bmi;

    private List<Integer> images = new ArrayList<Integer>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fillList();
        View v = inflater.inflate(R.layout.fragment_bmi, container, false);
        your_mass = (EditText)v.findViewById(R.id.your_mass);
        your_height = (EditText)v.findViewById(R.id.your_height);
        your_bmi = (TextView)v.findViewById(R.id.your_bmi);
        your_category = (TextView)v.findViewById(R.id.your_category);
        calculate_button = (Button)v.findViewById(R.id.calculate_button);
        image = (ImageView)v.findViewById(R.id.image);

        calculate_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showInfo();
            }
        });
        return v;
    }

    private void fillList() {
        images.add(R.drawable.silhouette_1);
        images.add(R.drawable.silhouette_2);
        images.add(R.drawable.silhouette_3);
        images.add(R.drawable.silhouette_4);
        images.add(R.drawable.silhouette_5);
        images.add(R.drawable.silhouette_6);
        images.add(R.drawable.silhouette_7);
        images.add(R.drawable.silhouette_8);
    }

    private void showInfo(){
        bmi = new BMIInfo();
        bmi.setMass(Integer.parseInt(your_mass.getText().toString()));
        bmi.setHeight(Float.parseFloat(your_height.getText().toString()));
        bmi.recalculate();
        your_bmi.setText(bmi.getBmiIndex() + "");
        your_category.setText(bmi.GetCategory().toString());
        image.setImageResource(getResourceId(bmi.GetCategory()));
    }

    private int getResourceId(BMIInfo.Category category) {
        for (int i = 0; i < BMIInfo.Category.values().length; i++)
            if (BMIInfo.Category.values()[i].equals(category))
                return images.get(i);
        return images.get(0);
    }
}
