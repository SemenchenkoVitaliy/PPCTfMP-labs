package com.example.vitaliy.ppctfmp4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String DATA_SOURCE = "com.example.vitaliy.ppctfmolab4.DATA_SOURCE";
    public static String DATA_TYPE = "com.example.vitaliy.ppctfmolab4.DATA_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MediaData> list = new ArrayList<MediaData>();
        list.add(new MediaData( "Cats", R.raw.video, "video"));
        list.add(new MediaData( "Across the line", R.raw.audio, "audio"));

        CustomAdapter adapter = new CustomAdapter(list, this);

        ListView lView = findViewById(R.id.listView);
        lView.setAdapter(adapter);
    }

    class MediaData {
        String name;
        int id;
        String type;

        MediaData(String name, int id, String type){
            this.name = name;
            this.id = id;
            this.type = type;
        }
    }


    class CustomAdapter extends BaseAdapter{

        ArrayList<MediaData> list;
        Context context;

        CustomAdapter(ArrayList<MediaData> list, Context context){
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.custom_layout, null);
            }

            final MediaData mData = list.get(position);

            TextView listItemText = (TextView)view.findViewById(R.id.textViewName);
            TextView listItemTypeText = (TextView)view.findViewById(R.id.textViewType);
            listItemText.setText(mData.name);
            listItemTypeText.setText(mData.type);

            Button bMediaPlay = (Button)view.findViewById(R.id.buttonMediaPlay);

            bMediaPlay.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent;
                    switch (mData.type){
                        case "audio":
                            intent = new Intent(context, AudioActivity.class);
                            intent.putExtra(DATA_SOURCE, mData.id);
                            startActivity(intent);
                            break;
                        case "video":
                            intent = new Intent(context, VideoActivity.class);
                            intent.putExtra(DATA_SOURCE, mData.id);
                            startActivity(intent);
                            break;
                        default:
                            Toast.makeText(context, "Incorrect type", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return view;
        }
    }
}
