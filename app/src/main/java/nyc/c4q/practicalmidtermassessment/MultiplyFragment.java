package nyc.c4q.practicalmidtermassessment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MultiplyFragment extends Fragment {

    private View rootView;

    private TextView multiplyText;


    public MultiplyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_multiply, container, false);

        multiplyText = rootView.findViewById(R.id.multipliednumber);

        Bundle bundle = getArguments();

        String getNumber = bundle.getString("RecyclerNumber");

        int process = Integer.parseInt(getNumber) * 10;

        multiplyText.setText(String.valueOf(process));


        return rootView;
    }

}
