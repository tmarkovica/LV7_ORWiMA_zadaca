package hr.ferit.orwima_lv7_pr2_tm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MessageFragmet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragmet extends Fragment {

    private TextView mMessageTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_fragmet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMessageTextView = view.findViewById(R.id.tvMessage);
    }

    public void displayMessage(String message) {
        mMessageTextView.setText(!message.trim().isEmpty() ? message : "...");
    }
}