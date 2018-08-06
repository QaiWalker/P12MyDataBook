package sg.edu.rp.q.p12_mydatabook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> ids;
    private ArrayList<String> names;
    public MenuItemAdapter(Context context, ArrayList<Integer> ids, ArrayList<String> names){
        this.context = context;
        this.ids = ids;
        this.names = names;
    }
    @Override
    public int getCount(){
        return names.size();
    }
    @Override
    public Object getItem(int position){
        return names.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = View.inflate(context, R.layout.row, null);
        }
        ImageView ivInstrument = convertView.findViewById(R.id.ivMenu);
        TextView tvInstrument = convertView.findViewById(R.id.tvMenu);
        ivInstrument.setImageResource(ids.get(position));
        tvInstrument.setText(names.get(position));
        return convertView;
    }
}
