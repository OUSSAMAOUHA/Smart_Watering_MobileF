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
import ma.projet.arrosageintellegentv2.beans.Boitier;
import ma.projet.arrosageintellegentv2.beans.Installation;

public class InstallationsAdapter extends BaseAdapter {
    private List<Installation> objects;
    private LayoutInflater inflater;

    public InstallationsAdapter(Activity activity, List<Installation> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public InstallationsAdapter(Activity activity, int xmlFile, List<Installation> objects) {
        this.objects = objects;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public List<Installation> getObjects() {
        return objects;
    }


    public InstallationsAdapter(StatisticActivity activity) {
        this.objects = new ArrayList<Installation>();
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
            convertView = inflater.inflate(R.layout.iteam_installation, null);


        TextView idI = convertView.findViewById(R.id.idI);
        TextView idIdateDebut = convertView.findViewById(R.id.idIdateDebut);
        TextView idIdateFin = convertView.findViewById(R.id.idIdateFin);
        TextView idIboitier = convertView.findViewById(R.id.idIboitier);
        TextView idItype = convertView.findViewById(R.id.idItype);
        TextView idIcode = convertView.findViewById(R.id.idIcode);
         idI.setText(objects.get(position).getId()+"");
        idIdateDebut.setText( "DateDebut :" +objects.get(position).getDateDebut());
        idIdateFin.setText("DateDebut :"+ objects.get(position).getDateFin());
        Boitier b = objects.get(position).getBoitier();
       idIboitier.setText( "Id :"+b.getRef());
        idItype.setText("Type :"+ b.getType());
        idIcode.setText("Code :" +b.getCode());

       Log.i("sabri",objects.get(position).getDateDebut());
        ImageView id__photo = convertView.findViewById(R.id.id__photo);
        Glide
                .with(convertView)
                .load(b.getImage())
                .centerCrop()
                .apply(new RequestOptions().override(200, 200))
                .into(id__photo);
        return convertView;
    }

    public void setObjects(List<Installation> installations) {
        this.objects=installations;
        Log.i("Adapter", this.objects.toString());
    }
}

