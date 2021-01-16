package hr.ferit.orwima_lv7_pr2_tm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpViewPager();
    }

    private void setUpViewPager() {
        List<Fragment> fragmentList = new ArrayList();
        fragmentList.add(SlideFragment.newInstance("This is fragment #1"));
        fragmentList.add(SlideFragment.newInstance("This is fragment #2"));
        //fragmentList.add(SlideFragment.newInstance("This is fragment #3"));
        //fragmentList.add(new MessageFragment());
        fragmentList.add(SlideFragment.newInstance("This is fragment #4"));
        fragmentList.add(SlideFragment.newInstance("This is fragment #5"));
        SlidePagerAdapter adapter = new SlidePagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViews() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
    }
}