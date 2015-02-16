package com.fada21.android.recyclerviewplayground;

import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int boxCount;
    private int boxSize;
    private int boxSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boxCount = getResources().getInteger(R.integer.box_count);
        boxSize = (int) getResources().getDimension(R.dimen.box_size);
        boxSpace = (int) getResources().getDimension(R.dimen.box_space);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.boxes);
        int spans = calculateSpans();
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(spans * getItemWIdth(), ViewGroup.LayoutParams.MATCH_PARENT));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spans);
        recyclerView.setLayoutManager(gridLayoutManager);
        ColorSqauresAdapter adapter = new ColorSqauresAdapter(generateList(boxCount));
        recyclerView.setAdapter(adapter);
    }

    private int calculateSpans() {
        Display display = getWindowManager().getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        int itemWidth = getItemWIdth();
        int spans = p.x / itemWidth;
        return spans;
    }

    private int getItemWIdth() {
        return boxSize + 2 * boxSpace;
    }

    private List<Integer> generateList(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(getRandomColor());
        }
        return list;
    }

    private int getRandomColor() {
        Random random = new Random();
        int rawRandomColor = random.nextInt();
        int color = rawRandomColor | 0xff000000;
        return color;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
