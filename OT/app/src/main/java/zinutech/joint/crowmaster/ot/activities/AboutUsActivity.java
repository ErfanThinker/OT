package zinutech.joint.crowmaster.ot.activities;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import zinutech.joint.crowmaster.ot.R;
import zinutech.joint.crowmaster.ot.adapters.AboutUsItemAdapter;
import zinutech.joint.crowmaster.ot.entities.CastEnt;

/**
 * Created by root on 4/23/15.
 */
public class AboutUsActivity extends Activity {
    ListView mList;
    /*LinearLayoutManager llm;
    DefaultItemAnimator da=new DefaultItemAnimator();*/
    AboutUsItemAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_activity);
        mList= (ListView) findViewById(R.id.cast_list);
        //mList.setHasFixedSize(true);

        /*llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setSmoothScrollbarEnabled(true);
        mList.setLayoutManager(llm);
        mList.setItemAnimator(da);*/

        TypedArray mIcons = getResources().obtainTypedArray(R.array.about_us_icons);
        String []arg1s = getResources().getStringArray(R.array.about_us_arg1);
        String []arg2s = getResources().getStringArray(R.array.about_us_arg2);
        String []arg3s = getResources().getStringArray(R.array.about_us_arg3);
        String []arg4s = getResources().getStringArray(R.array.about_us_arg4);
        ArrayList<CastEnt> cl = new ArrayList<CastEnt>();
        for (int i = 0 ; i < mIcons.length() ; i++){
            cl.add(new CastEnt(mIcons.getResourceId(i,-1),arg1s[i],arg2s[i],arg3s[i],arg4s[i]));
        }
        mAdapter = new AboutUsItemAdapter(this,cl);
        mList.setAdapter(mAdapter);
    }
}
