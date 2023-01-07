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

import ma.projet.arrosageintellegentv2.adapters.ZoneAdapter;
import ma.projet.arrosageintellegentv2.beans.Parcelle;
import ma.projet.arrosageintellegentv2.ui.espacevert.EspacevertViewModel;

public class ZoneActivity extends AppCompatActivity {

    private static final String TAG = "ZoneActivity";
    private long espace_id;
    private ListView zonelist;
   private  List<Parcelle>zone=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);
        zonelist=findViewById(R.id.zonelist);
        Intent i = getIntent();

        espace_id =  i.getLongExtra("espace_id", -1);

        List<Parcelle> zones = EspacevertViewModel.getZonesByEspaceId(espace_id);
        int xmlFile = R.layout.iteam_zone;
        ZoneAdapter adapter = new ZoneAdapter(ZoneActivity.this, xmlFile, zones);
        zonelist.setAdapter(adapter);
        zonelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              OpenZonesActivity(espace_id,zones.get(position).getId());
              //  OpenZonesActivity(zone.);
            }

    });
    }

    private void OpenZonesActivity(long espace_id,long zone_id) {
        Log.i(TAG, "OpenZonesActivity: id = " + zone_id);
        Intent intent = new Intent(this, DetailsZoneActivity.class);
        intent.putExtra("espace_id",espace_id);
        intent.putExtra("zone_id",zone_id);
        startActivity(intent);
    }


}