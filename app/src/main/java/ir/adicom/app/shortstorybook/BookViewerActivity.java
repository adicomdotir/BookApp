package ir.adicom.app.shortstorybook;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class BookViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_viewer);

        Bundle bundle = getIntent().getExtras();
        int index = bundle.getInt("INDEX");

        ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.abs_layout, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT,
                Gravity.RIGHT);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.mytext);
        textviewTitle.setText(Global.title[index]);
        abar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        abar.setCustomView(viewActionBar, params);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.abs_layout);

        // TextView textView = (TextView) findViewById(R.id.textView2);
        // textView.setText(Global.descriptions[index]);
        JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.activity_main_jtv);
        txt.setText(Global.descriptions[index]);
    }
}
