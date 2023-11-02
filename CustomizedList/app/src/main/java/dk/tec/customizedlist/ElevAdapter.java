package dk.tec.customizedlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ElevAdapter extends BaseAdapter
{
    private final ArrayList<Elev> elever;
    private final MainActivity main;
    public ElevAdapter(MainActivity mainActivity, ArrayList<Elev> elever)
    {
        this.elever = elever;
        this.main = mainActivity;
        //this.elever.add(new Elev());
        //this.elever = new ArrayList<Elev>();
    }

    @Override
    public int getCount() {
        return elever.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(main);
        View v = inflater.inflate(R.layout.list_item,null);

        Elev e = elever.get(position);

        ImageView imgElev = v.findViewById(R.id.imgElev);
        imgElev.setImageResource(e.getPictureId());
        TextView txtName = v.findViewById(R.id.txtName);
        txtName.setText(e.getName());
        TextView txtDescr = v.findViewById(R.id.txtDescription);
        txtDescr.setText(e.getDescription());
////////////////////////////////////////////////////////////////////////
        Button btnDelete = v.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                elever.remove(position);
                notifyDataSetChanged();
            }
        });
        return v;
    }
}
