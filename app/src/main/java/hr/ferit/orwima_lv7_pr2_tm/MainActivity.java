package hr.ferit.orwima_lv7_pr2_tm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements ButtonClickListener, NameClickListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private InputFragment mInputFragment;
    private MessageFragmet mMessageFragment;

    private fragment_modular mfragment_modular;

    private fragment_modular_first first;
    private fragment_modular_second second;

    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mFragmentManager = getSupportFragmentManager();

        // ---------------------------

        createFragments();
        initViews();
        setUpViewPager();
        //setUpFragments();
    }

    private void createFragments() {
        mMessageFragment = new MessageFragmet();
        mInputFragment = new InputFragment();

        // novi fragmenti
        mfragment_modular = new fragment_modular();
        first = new fragment_modular_first();
        first.createCustomAdapter(this);
        second = new fragment_modular_second();
    }

    public void setUpFragments() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.firstFragment, mMessageFragment);
        fragmentTransaction.add(R.id.secondFragment, mInputFragment);
        fragmentTransaction.commit();
    }

    private void setUpViewPager() {
        List<Fragment> fragmentList = new ArrayList<Fragment>();


        fragmentList.add(mInputFragment);
        fragmentList.add(mMessageFragment);

        fragmentList.add(SlideFragment.newInstance("This is fragment #1"));

        //
        fragmentList.add(mfragment_modular);
        fragmentList.add(first);
        fragmentList.add(second);
        //

        SlidePagerAdapter adapter = new SlidePagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViews() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
    }

    @Override
    public void onButtonClicked(String message) {
        mMessageFragment.displayMessage(message);
        mViewPager.setCurrentItem(1);
    }

    @Override
    public void onNameClick(int position) {

    }
}