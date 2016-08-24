package ir.adicom.app.shortstorybook;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by adicom on 8/24/16.
 */
public class MyArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] names;


    static class ViewHolder {
        public TextView text;
        public CheckBox checkBox;
        public LinearLayout linearLayout;
    }

    public MyArrayAdapter(Activity context, String[] names) {
        super(context, R.layout.custom_layout, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.custom_layout, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.linearLayout = (LinearLayout) rowView.findViewById(R.id.layout);
            viewHolder.text = (TextView) rowView.findViewById(R.id.textView2);
            viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookViewerActivity.class);
                    intent.putExtra("INDEX", position);
                    context.startActivity(intent);
                }
            });
            viewHolder.checkBox = (CheckBox) rowView.findViewById(R.id.checkBox);
            rowView.setTag(viewHolder);
        }



        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = names[position];
        holder.text.setText(s);
        return rowView;
    }
}
