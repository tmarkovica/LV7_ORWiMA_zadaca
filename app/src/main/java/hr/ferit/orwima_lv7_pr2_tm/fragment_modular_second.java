package hr.ferit.orwima_lv7_pr2_tm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_modular_second#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_modular_second extends Fragment {

    private Button buttonAddPerson;
    private EditText editTextAddPerson;

    private ButtonClickListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modular_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonAddPerson = view.findViewById(R.id.buttonAddPerson);
        editTextAddPerson = view.findViewById(R.id.editTextAddPerson);
    }
}