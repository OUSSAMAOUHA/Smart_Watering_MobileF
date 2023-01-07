package ma.projet.arrosageintellegentv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ma.projet.arrosageintellegentv2.adapters.PlantageAdapter;
import ma.projet.arrosageintellegentv2.beans.Plantage;
import ma.projet.arrosageintellegentv2.ui.espacevert.EspacevertViewModel;

public class PlantageActivity  extends AppCompatActivity {
    private static final String TAG = "PlantageActivity";
    private long espace_id;
    private long zone_id;
    private ListView plantageList;
    private List<Plantage> plantages=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantage);
        plantageList=findViewById(R.id.plantageList);

        Intent i = getIntent();
        espace_id =  i.getLongExtra("espace_id", -1);
        zone_id = i.getLongExtra("zone_id", -1);
        Log.i("dzdzdz", String.valueOf(espace_id));
        Log.i("dzdzdz", String.valueOf(zone_id));
        List<Plantage> plantages = EspacevertViewModel.getZoneDetails(espace_id, zone_id).getPlantages();
        int xmlFile = R.layout.iteam_grandeur;
        PlantageAdapter adapter = new PlantageAdapter(PlantageActivity.this, xmlFile, plantages);
        plantageList.setAdapter(adapter);
        plantageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               OpenZonesActivity(espace_id,plantages.get(position).getId());
                //  OpenZonesActivity(zone.);
            }

        });
    }
    private void OpenZonesActivity(long espace_id,long zone_id) {
        Log.i(TAG, "OpenZonesActivity: id = " + zone_id);
        Intent intent = new Intent(this, DetailPlantageActivity.class);
        intent.putExtra("espace_id",espace_id);
        intent.putExtra("zone_id",zone_id);
        startActivity(intent);

    }

}