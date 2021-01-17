package hr.ferit.orwima_lv7_pr2_tm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_modular#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_modular extends Fragment {

    private FragmentManager mFragmentManager;
    private boolean mSwitched = false;

    private fragment_modular_first mModular_first;
    private fragment_modular_second mModular_second;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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



    // for RecyclerView
    private RecyclerView recyclerView;
    private List<String> dataList;
    private CustomAdapter customAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

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

    private NameClickListener nameClickListener;

    public fragment_modular(NameClickListener nameClickListener) {
        setupNames();
        this.nameClickListener = nameClickListener;
        this.customAdapter = new CustomAdapter(dataList,  this.nameClickListener);
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}