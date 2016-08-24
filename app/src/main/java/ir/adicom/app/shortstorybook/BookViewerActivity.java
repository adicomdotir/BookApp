package ir.adicom.app.shortstorybook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BookViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_viewer);

        // TextView textView = (TextView) findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        int index = bundle.getInt("INDEX");
        // textView.setText(Global.descriptions[index]);
        JustifiedTextView txt = (JustifiedTextView) findViewById(R.id.activity_main_jtv);
        txt.setText(Global.descriptions[index]);
    }
}
