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
import ma.projet.arrosageintellegentv2.beans.Grandeur;

public class GrandeurAdapter  extends BaseAdapter {
    private List<Grandeur> objects;
    private LayoutInflater inflater;

    public GrandeurAdapter(Activity activity, List<Grandeur> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public GrandeurAdapter(Activity activity, int xmlFile, List<Grandeur> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Grandeur> getObjects() {
        return objects;
    }


    public GrandeurAdapter(StatisticActivity activity) {
        this.objects = new ArrayList<Grandeur>();
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
            convertView = inflater.inflate(R.layout.iteam_grandeur, null);


        TextView idG = convertView.findViewById(R.id.idG);
        TextView idGvaleur = convertView.findViewById(R.id.idGvaleur);
        TextView idGtype = convertView.findViewById(R.id.idGtype);
        TextView idGdate = convertView.findViewById(R.id.idGdate);

        idG.setText(objects.get(position).getId()+"");

        idGvaleur.setText( objects.get(position).getValeur()+"");
        idGtype.setText(objects.get(position).getType());
        idGdate.setText(objects.get(position).getDate());
        return convertView;
    }

    public void setObjects(List<Grandeur> arrosages) {
        this.objects=arrosages;
        Log.i("Adapter", this.objects.toString());
    }
}
