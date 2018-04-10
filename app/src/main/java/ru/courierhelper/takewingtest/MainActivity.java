package ru.courierhelper.takewingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);

        DataPoint[] dataPoints = new DataPoint[1000];

        float j = 0;
        for (int i=0; i<1000; i++){
            if (i % 15 == 0) {
                dataPoints[i] = new DataPoint(j, i/2 - 30);
            } else if (i % 30 == 0) {
                dataPoints[i] = new DataPoint(j, i*2 - 30);
            } else {
                dataPoints[i] = new DataPoint(j, j);
            }
            j+= 0.1;
        }

        GraphView graphView = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);

        graphView.addSeries(series);

        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScalableY(true);
        graphView.getViewport().setScrollableY(true);

        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                textView.setText(dataPoint.toString());
            }
        });


    }
}
