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
import ma.projet.arrosageintellegentv2.beans.Arrosage;

public class ArosageAdapter extends BaseAdapter {
    private List<Arrosage> objects;
    private LayoutInflater inflater;

    public ArosageAdapter(Activity activity, List<Arrosage> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public ArosageAdapter(Activity activity, int xmlFile, List<Arrosage> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Arrosage> getObjects() {
        return objects;
    }


    public ArosageAdapter(StatisticActivity activity) {
        this.objects = new ArrayList<Arrosage>();
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
            convertView = inflater.inflate(R.layout.iteam_arossage, null);


        TextView idA = convertView.findViewById(R.id.idA);
        TextView idAdate = convertView.findViewById(R.id.idAdate);
        TextView idAlitresEau = convertView.findViewById(R.id.idAlitresEau);

        idA.setText(objects.get(position).getId()+"");
       idAdate.setText( objects.get(position).getDate());
      idAlitresEau.setText(objects.get(position).getLitresEau()+"");

        return convertView;
    }

    public void setObjects(List<Arrosage> arrosages) {
        this.objects=arrosages;
        Log.i("Adapter", this.objects.toString());
    }
}

