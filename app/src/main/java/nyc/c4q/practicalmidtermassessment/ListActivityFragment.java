package nyc.c4q.practicalmidtermassessment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListActivityFragment extends Fragment {

    private View rootview;
    private TextView textView;

    public ListActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_list_activity, container, false);

        Intent intent = getActivity().getIntent();

        String email = intent.getStringExtra("UserEmail");

        textView = rootview.findViewById(R.id.user_email);
        textView.setText(email);

        RecyclerView recyclerView = (RecyclerView) rootview.findViewById(R.id.fragment_recycler_view);

        List<Numbers> numbersList = new ArrayList<>();
        numbersList.add(new Numbers(0));
        numbersList.add(new Numbers(1));
        numbersList.add(new Numbers(2));
        numbersList.add(new Numbers(3));
        numbersList.add(new Numbers(4));
        numbersList.add(new Numbers(5));
        numbersList.add(new Numbers(6));
        numbersList.add(new Numbers(7));
        numbersList.add(new Numbers(8));
        numbersList.add(new Numbers(9));
        numbersList.add(new Numbers(10));

        NumbersAdapter numbersAdapter = new NumbersAdapter(numbersList);

        recyclerView.setAdapter(numbersAdapter);

        return rootview;
    }

}
