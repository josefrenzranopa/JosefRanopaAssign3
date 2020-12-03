package josef.ranopa.n01312587;
//Josef Renz Ranopa N01312587
import android.content.ContentResolver;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
    int brightness;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ra_set, container, false);
        switchCompat = (SwitchCompat) view.findViewById(R.id.josswitch);

        seekBar = (SeekBar) view.findViewById(R.id.josseekBar);
        textP = (TextView) view.findViewById(R.id.josbrightnesstv);
        ContentResolver resolver = getActivity().getContentResolver();
        Window window = getActivity().getWindow();

        seekBar.setMax(255);
        seekBar.setKeyProgressIncrement(1);

        try
        {
            //Get the current system brightness
            brightness = Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS);
        }
        catch (Settings.SettingNotFoundException e)
        {
            //Throw an error case it couldn't be retrieved
            Log.e("Error", "Cannot access system brightness");
            e.printStackTrace();
        }

        seekBar.setProgress(brightness);

        seekBar.setProgress(brightness);

        //Register OnSeekBarChangeListener, so it can actually change values
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                //Set the system brightness using the brightness variable value
                Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
                //Get the current window attributes
                ViewGroup.LayoutParams layoutpars = window.getAttributes();
                //Set the brightness of this window
                ((WindowManager.LayoutParams) layoutpars).screenBrightness = brightness / (float)255;
                //Apply attribute changes to this window
                window.setAttributes((WindowManager.LayoutParams) layoutpars);
            }

            public void onStartTrackingTouch(SeekBar seekBar)
            {
                //Nothing handled here
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //Set the minimal brightness level
                //if seek bar is 20 or any value below
                if(progress<=20)
                {
                    //Set the brightness to 20
                    brightness=20;
                }
                else //brightness is greater than 20
                {
                    //Set brightness variable based on the progress bar
                    brightness = progress;
                }
                //Calculate the brightness percentage
                float perc = (brightness /(float)255)*100;
                //Set the brightness percentage
                textP.setText((int)perc +" %");
            }
        });


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
                    case R.id.josdefault:
                        getActivity().getWindow().getDecorView().setBackgroundColor(Color.WHITE);
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