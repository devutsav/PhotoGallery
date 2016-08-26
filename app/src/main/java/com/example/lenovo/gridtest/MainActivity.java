package com.example.lenovo.gridtest;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView g;
    int images[] = {R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c5, R.drawable.c7, R.drawable.c6, R.drawable.c9, R.drawable.c8, R.drawable.c4, R.drawable.c2};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        g = (GridView) findViewById(R.id.gridview);
        Adapter ad = new Adapter(this, images);
        g.setAdapter(ad);

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View convertView, int position, long id) {
                Toast.makeText(getApplicationContext(), "Image no: " +position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class Adapter extends BaseAdapter
    {
        private Context mContext;
        int a[];

        public Adapter(Context c, int[] a)
        {
            mContext = c;
            this.a = a;
        }

        public int getCount() {
            return a.length;
        }
        public long getItemId(int b){
            return 0;
        }
        public Object getItem(int position)
        {
            return a[position];
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
            i.setImageResource(a[position]);
            i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            i.setLayoutParams(new GridView.LayoutParams(115, 115));
            return i;

        }
    }
}