package josef.ranopa.n01312587;

import android.content.ContentResolver;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class RaSet extends Fragment  {

    Switch aSwitch;
    SwitchCompat switchCompat;
    RadioGroup radioGroup;
    Button changebutton;
    RadioButton radioButton;
    SeekBar seekBar;
    TextView textP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ra_set, container, false);
        switchCompat = (SwitchCompat) view.findViewById(R.id.josswitch);

        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        textP = (TextView) view.findViewById(R.id.josbrightnesstv);
        ContentResolver resolver = getActivity().getContentResolver();
        Window window = getActivity().getWindow();

        seekBar.setMax(255);
        seekBar.setKeyProgressIncrement(1);


        radioGroup = (RadioGroup) view.findViewById(R.id.josradioGroup);
        changebutton = (Button) view.findViewById(R.id.joschange);


        changebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int radioId=radioGroup.getCheckedRadioButtonId();
                 radioButton=view.findViewById(radioId);
                switch (radioId){
                    case R.id.josyellow:
                        getActivity().getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                        break;
                    case R.id.josmagenta:
                        getActivity().getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
                        break;
                    default:
                }
            }
        });

        return view;


    }
}

 /*   @Override
    public void onClick(View v) {
        orange = (RadioButton) v.findViewById(R.id.josorange);
        brown = (RadioButton) v.findViewById(R.id.josbrown);
        backtodefault = (RadioButton) v.findViewById(R.id.josdefault);

        if (orange.isClickable()) {
            Fragment newFragment = new joseforange();
            newFragment.show(getFragmentManager(), "DatePicker");
        }
        if (brown.isChecked()) {
            DialogFragment newFragment = new josefdatefrag();
        }
        if (backtodefault.isChecked()) {
            DialogFragment newFragment = new josefdatefrag();
        }
    } */