package zinutech.joint.crowmaster.ot.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;

import zinutech.joint.crowmaster.ot.R;

/**
 * Created by root on 5/5/15.
 */
public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        final RadioButton maleRB = (RadioButton)findViewById(R.id.male_rb);
        final RadioButton femaleRB = (RadioButton)findViewById(R.id.female_rb);
        maleRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    femaleRB.setChecked(false);
            }
        });

        femaleRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    maleRB.setChecked(false);
            }
        });

    }
}
