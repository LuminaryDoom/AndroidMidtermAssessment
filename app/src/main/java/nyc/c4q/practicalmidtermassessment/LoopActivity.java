package nyc.c4q.practicalmidtermassessment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

    TextView centerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);

        centerText = findViewById(R.id.tv_01);


    }


    private class AsyncTaskRunnable extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer[] integers) {

            int counter = 0;

            do {

                publishProgress(integers[0]);
                counter++;
            } while (counter < 10000);

            return integers[10000];
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {

            super.onProgressUpdate(progress);
            centerText.setText("Loops completed: " + progress);
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            centerText.setText("Loops completed:" + result);
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }

    }


}

