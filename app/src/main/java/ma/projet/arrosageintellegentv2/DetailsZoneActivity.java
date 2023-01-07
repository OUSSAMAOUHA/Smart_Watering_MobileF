package ma.projet.arrosageintellegentv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import ma.projet.arrosageintellegentv2.beans.Parcelle;
import ma.projet.arrosageintellegentv2.ui.espacevert.EspacevertViewModel;

public class DetailsZoneActivity extends AppCompatActivity {
    private static final String TAG = "DetailsZoneActivity";
    private long espace_id;
    private long zone_id;
    private ImageView id__photo;
    private TextView id__libelle;
    private TextView id__superficie;
    private TextView id__type;
    private TextView id__idf;
    private Button btn_arrosages, btn_installations, btn_grandeurs, btn_plantages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_zone);
        Intent i = getIntent();
        espace_id = i.getLongExtra("espace_id", -1);
        zone_id = i.getLongExtra("zone_id", -1);
        Log.i(TAG, String.valueOf(espace_id));
        Log.i(TAG, String.valueOf(zone_id));
        id__idf = findViewById(R.id.id__idf);
        id__libelle = findViewById(R.id.id__libelle);
        id__superficie = findViewById(R.id.id__superficie);
        id__type = findViewById(R.id.id__type);
        id__photo = findViewById(R.id.id__photo);


        btn_plantages=findViewById(R.id.btn_plantages);
        btn_plantages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsZoneActivity.this, PlantageActivity.class);
                intent.putExtra("espace_id",espace_id);
                intent.putExtra("zone_id",zone_id);
                startActivity(intent);
            }
        });



        Parcelle zones = EspacevertViewModel.getZoneDetails(espace_id, zone_id);

        Log.i(TAG, zones.toString());
        Log.i(TAG, zones.getLibelle());
        id__libelle.setText("Libelle   :"+zones.getLibelle());
        id__superficie.setText("Superficie :"+zones.getSuperficie() );
        Glide.with(this)
                .load(zones.getImage()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.ic_launcher_background)  // any image in case of error
                .override(200, 200) // resizing
                .centerCrop()
                .into(id__photo);
        ///
    }


    }
