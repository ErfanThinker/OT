package zinutech.joint.crowmaster.ot.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import zinutech.joint.crowmaster.ot.R;


public class MainActivity extends Activity {
    ImageButton info;
    ImageButton about;
    ImageButton signIn;
    ImageButton signOut;
    TableLayout rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new LoadBackgroundAsync().execute();
        info = (ImageButton) findViewById(R.id.info);
        about = (ImageButton) findViewById(R.id.about);
        signIn = (ImageButton) findViewById(R.id.sign_in);
        signOut = (ImageButton) findViewById(R.id.sign_out);

        rootView = (TableLayout) findViewById(R.id.main_root);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AboutUsActivity.class));
            }
        });
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignInActivity.class));
            }
        });


    }

    private class LoadBackgroundAsync extends AsyncTask<Void,Void,Drawable>{
        Point size;
        Context mContext;

        private Drawable resize(Drawable image) {
            Bitmap b = ((BitmapDrawable)image).getBitmap();
            Bitmap bitmapResized = Bitmap.createScaledBitmap(b, size.x, size.y, false);
            return new BitmapDrawable(getResources(), bitmapResized);
        }
        @Override
        protected Drawable doInBackground(Void... voids) {
            Drawable mDrawable = mContext.getResources().getDrawable(R.drawable.main_back);
            mDrawable = resize(mDrawable);
            return mDrawable;
        }

        @Override
        protected void onPostExecute(Drawable mDrawable) {
            super.onPostExecute(mDrawable);
            rootView.setBackgroundDrawable(mDrawable);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Display display = getWindowManager().getDefaultDisplay();
            size = new Point();
            display.getSize(size);
            mContext = getApplicationContext();
        }


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
