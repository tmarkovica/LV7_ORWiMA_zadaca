package hr.ferit.orwima_lv7_pr2_tm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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

    private InputFragment mInputFragment = new InputFragment();
    private MessageFragmet mMessageFragment = new MessageFragmet();

    private ModularFragment mModularFragment;
    private fragment_modular mfragment_modular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mModularFragment = new ModularFragment();

        mfragment_modular = new fragment_modular(this);
        setRecyclerView();

        initViews();
        setUpViewPager();
    }

    private List<String> dataList;
    private void setupNames() {
        dataList = new ArrayList<>();
        dataList.add("Robin");
        dataList.add("David");
        dataList.add("Filip");
        dataList.add("Petar");
        dataList.add("Laura");
        dataList.add("Mihaela");
        dataList.add("Ana");
        dataList.add("Vlatka");
        dataList.add("Robin2");
        dataList.add("David2");
        dataList.add("Filip2");
        dataList.add("Petar2");
        dataList.add("Laura2");
        dataList.add("Mihaela2");
        dataList.add("Ana2");
        dataList.add("Vlatka2");
    }

    private void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        setupNames();
        CustomAdapter customAdapter = new CustomAdapter(dataList, this);
        //recyclerView.setAdapter(customAdapter);
        //mfragment_modular.setRecyclerView(recyclerView);
    }


    private void setUpViewPager() {
        List<Fragment> fragmentList = new ArrayList<Fragment>();


        fragmentList.add(mInputFragment);
        fragmentList.add(mMessageFragment);

        fragmentList.add(SlideFragment.newInstance("This is fragment #1"));

        fragmentList.add(SlideFragment.newInstance("This is fragment #2"));

        fragmentList.add(SlideFragment.newInstance("This is fragment #3"));

        fragmentList.add(mfragment_modular);


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