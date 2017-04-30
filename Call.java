package sloooowpokers.firefighters;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Call extends Activity {

    private WebView mWeb;


    final Context context = this;
    private Button button;

    private class WebViewer extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading (WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        mWeb=(WebView)findViewById(R.id.webView);

        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.loadUrl("https://bigdaddy1.github.io/");
        mWeb.setWebViewClient(new WebViewer());

        button = (Button) findViewById(R.id.callbutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @SuppressWarnings("MissingPermission")
            @Override
            public void onClick(View arg0)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:911"));
                startActivity(callIntent);

            }

        });

    }

    @Override
    public void onBackPressed() {
        if (mWeb.canGoBack()) {
            mWeb.goBack();}
        else {
            super.onBackPressed();
        }
    }
}