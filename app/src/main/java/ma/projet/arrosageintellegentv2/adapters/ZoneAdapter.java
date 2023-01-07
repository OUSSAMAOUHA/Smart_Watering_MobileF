package ma.projet.arrosageintellegentv2.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import ma.projet.arrosageintellegentv2.R;
import ma.projet.arrosageintellegentv2.StatisticActivity;
import ma.projet.arrosageintellegentv2.beans.Parcelle;

public class ZoneAdapter extends BaseAdapter {
    private List<Parcelle> objects;
    private LayoutInflater inflater;

    public ZoneAdapter(Activity activity, List<Parcelle> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public ZoneAdapter(Activity activity, int xmlFile, List<Parcelle> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Parcelle> getObjects() {
        return objects;
    }


    public ZoneAdapter(StatisticActivity activity) {
        this.objects = new ArrayList<Parcelle>();
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.iteam_zone, null);


        TextView id = convertView.findViewById(R.id.id);
        TextView libelle = convertView.findViewById(R.id.libelle);
        id.setText(objects.get(position).getId()+"");
        libelle.setText(objects.get(position).getLibelle());
        ImageView photo = convertView.findViewById(R.id.photo);
        Glide
                .with(convertView)
                .load(objects.get(position).getImage())
                .centerCrop()
                .apply(new RequestOptions().override(90, 90))
                .into(photo);
        return convertView;
    }

    public void setObjects(List<Parcelle> zones) {

        this.objects=zones;
        Log.i("Adapter", this.objects.toString());
    }
}
