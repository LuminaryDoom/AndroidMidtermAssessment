package nyc.c4q.practicalmidtermassessment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by c4q on 12/6/17.
 */

public class NumbersAdapter extends RecyclerView.Adapter<NumbersViewHolder> {

    private List<Numbers> numbersList;

    public NumbersAdapter(List<Numbers> numbersList) {
        this.numbersList = numbersList;
    }

    @Override
    public NumbersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.numbers_itemview, parent, false);
        return new NumbersViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(NumbersViewHolder holder, int position) {
        Numbers numbers = numbersList.get(position);
        holder.bind(numbers);
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }
}
