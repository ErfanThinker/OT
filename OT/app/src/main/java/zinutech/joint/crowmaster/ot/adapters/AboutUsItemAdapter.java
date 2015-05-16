package zinutech.joint.crowmaster.ot.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import zinutech.joint.crowmaster.ot.R;
import zinutech.joint.crowmaster.ot.entities.CastEnt;

/**
 * Created by root on 4/24/15.
 */
public class AboutUsItemAdapter extends BaseAdapter {

    private ArrayList<CastEnt> castList;
    final Activity mHostingActivity;

    public AboutUsItemAdapter(Activity a,ArrayList<CastEnt> cl){
        this.castList=cl;
        this.mHostingActivity=a;
    }
    @Override
    public int getCount() {
        return castList.size();
    }

    @Override
    public Object getItem(int i) {
        return castList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderItem viewHolder;
        if(view == null){
            view = ((LayoutInflater)mHostingActivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.about_us_item,null);
            viewHolder = new ViewHolderItem();
            viewHolder.arg1 = (TextView) view.findViewById(R.id.arg1);
            viewHolder.arg2= (TextView) view.findViewById(R.id.arg2);
            viewHolder.arg3= (TextView) view.findViewById(R.id.arg3);
            viewHolder.arg4= (TextView) view.findViewById(R.id.arg4);
            viewHolder.left_icon= (CircleImageView) view.findViewById(R.id.left_profile_image);
            view.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolderItem) view.getTag();
        }

        CastEnt ce=castList.get(i);
        viewHolder.arg1.setText(ce.getArg1());
        viewHolder.arg2.setText(ce.getArg2());
        viewHolder.arg3.setText(ce.getArg3());
        viewHolder.arg4.setText(ce.getArg4());
        viewHolder.left_icon.setVisibility(View.VISIBLE);
        Picasso.with(mHostingActivity).load(ce.getImage()).resize(96,96).into(viewHolder.left_icon);


        return view;

    }


    static class ViewHolderItem {
        TextView arg1 ;
        TextView arg2 ;
        TextView arg3 ;
        TextView arg4 ;
        CircleImageView left_icon ;
    }

}
