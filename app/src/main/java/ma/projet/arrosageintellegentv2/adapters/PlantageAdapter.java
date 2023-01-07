package ma.projet.arrosageintellegentv2.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ma.projet.arrosageintellegentv2.R;
import ma.projet.arrosageintellegentv2.StatisticActivity;
import ma.projet.arrosageintellegentv2.beans.Plantage;

public class PlantageAdapter extends BaseAdapter {
    private List<Plantage> objects;
    private LayoutInflater inflater;

    public PlantageAdapter(Activity activity, List<Plantage> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public PlantageAdapter(Activity activity, int xmlFile, List<Plantage> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Plantage> getObjects() {
        return objects;
    }


    public PlantageAdapter(StatisticActivity activity) {
        this.objects = new ArrayList<Plantage>();
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
            convertView = inflater.inflate(R.layout.iteamplantage, null);


        TextView idP = convertView.findViewById(R.id.idP);
        TextView idPnombre = convertView.findViewById(R.id.idPnombre);
        TextView idPplante = convertView.findViewById(R.id.idPplante);
        TextView idPDate = convertView.findViewById(R.id.idPDate);

        idP.setText(objects.get(position).getId()+"");
        idPnombre.setText( objects.get(position).getNombre()+"");
        idPplante.setText(objects.get(position).getPlante()+"");
        idPDate.setText(objects.get(position).getDate());
        return convertView;
    }

    public void setObjects(List<Plantage> plantages) {
        this.objects=plantages;
        Log.i("Adapter", this.objects.toString());
    }
}