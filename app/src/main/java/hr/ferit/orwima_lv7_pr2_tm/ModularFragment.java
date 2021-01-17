package hr.ferit.orwima_lv7_pr2_tm;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

public class ModularFragment extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private boolean mSwitched = false;

    private fragment_modular_first mModular_first;
    private fragment_modular_second mModular_second;

    public ModularFragment() {
        mFragmentManager = getSupportFragmentManager();
        //setUpViews();
        setUpFragments();
    }

    private void setUpFragments() {
        mModular_first = new fragment_modular_first();
       /* mModular_second = new fragment_modular_second();

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.firstFragment, mModular_first);
        fragmentTransaction.add(R.id.secondFragment, mModular_second);
        fragmentTransaction.commit();*/
    }

    private void setUpViews() {
        findViewById(R.id.btSwitch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragments();
            }
        });
    }

    private void switchFragments() {
        mSwitched = !mSwitched;
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mSwitched) {
            fragmentTransaction.replace(R.id.firstFragment, mModular_first);
            fragmentTransaction.replace(R.id.secondFragment, mModular_second);
        }
        else {
            fragmentTransaction.replace(R.id.firstFragment, mModular_first);
            fragmentTransaction.replace(R.id.secondFragment, mModular_second);
        }
        fragmentTransaction.commit();
    }

}
