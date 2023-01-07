package ma.projet.arrosageintellegentv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailPlantageActivity extends AppCompatActivity {
    private long espace_id;
    private long zone_id;
    private ImageView id___image;
    private TextView id___libelle;
    private TextView id___racine;
    private TextView id___type;
    private TextView id___idf;
    private static final String TAG = "DetailPlantageActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_plantage);
        Intent i = getIntent();
        espace_id = i.getLongExtra("espace_id", -1);
        zone_id = i.getLongExtra("zone_id", -1);
        Log.i(TAG, String.valueOf(espace_id));
        Log.i(TAG, String.valueOf(zone_id));
        id___idf = findViewById(R.id.id___idf);
        id___libelle = findViewById(R.id.id___libelle);
        id___racine = findViewById(R.id.id___racine);
        id___type = findViewById(R.id.id___type);
        id___image = findViewById(R.id.id___image);
      //List<Plantage> plantages =  EspacevertViewModel.getZoneDetails(espace_id, zone_id).getPlantages();

      //Log.i(TAG, EspacevertViewModel.getZoneDetails(espace_id, zone_id).toString());
       /*  id___idf.setText(plantages.get(0).getPlante().getId()+"");
       id___libelle.setText(plantages.get(0).getPlante().getLibelle());
        id___racine.setText(plantages.get(0).getPlante().getRacine());
        id___type.setText(plantages.get(0).getPlante().getType()+"");*/
        /*Glide.with(this)
                .load(plantages.get(0).getPlante().getImage()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.ic_launcher_background)  // any image in case of error
                .override(200, 200) // resizing
                .centerCrop()
                .into(id___image);
      */
    }
}