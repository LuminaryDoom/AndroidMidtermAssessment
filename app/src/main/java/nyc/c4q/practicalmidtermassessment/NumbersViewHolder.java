package nyc.c4q.practicalmidtermassessment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by c4q on 12/6/17.
 */

public class NumbersViewHolder extends RecyclerView.ViewHolder {

   private TextView numberText;
    private Context context;

    public NumbersViewHolder(View itemView) {
        super(itemView);
        numberText = itemView.findViewById(R.id.mumbertext);

    }

    public void bind(Numbers numbers){
        String numberValue = String.valueOf(numbers.getNumbers());
        numberText.setText(numberValue);
        numberText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiplyFragment multiplyFragment  = new MultiplyFragment();
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("RecyclerNumber" , numberText.getText().toString());
                multiplyFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main_container , multiplyFragment);
                fragmentTransaction.addToBackStack("next");
                fragmentTransaction.commit();
            }
        });
    }
}
