package ma.projet.arrosageintellegentv2.ui.plante;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ma.projet.arrosageintellegentv2.beans.Plante;
import ma.projet.arrosageintellegentv2.beans.Parcelle;
import ma.projet.arrosageintellegentv2.beans.TypePlante;
import ma.projet.arrosageintellegentv2.networking.ApiClient;
import ma.projet.arrosageintellegentv2.networking.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanteViewModel extends AndroidViewModel {

    static MutableLiveData<List<Plante>> mPlante = new MutableLiveData<>();
    static MutableLiveData<List<TypePlante>> mTypePlante = new MutableLiveData<>();


    private static final String TAG = "PlanteViewModel";

    public PlanteViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Plante>> getEspace() {
        return mPlante;
    }
    public LiveData<List<TypePlante>> getTypePlante() {
        return mTypePlante;
    }



    void init() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Plante>> call = apiInterface.getplante();
        call.enqueue(new Callback<List<Plante>>() {
            @Override
            public void onResponse(Call call, Response response) {
                //Log.d(TAG, "onResponse: " + response);
                mPlante.setValue((List<Plante>) response.body());
                Log.d(TAG, "getValeu(à: " + mPlante.getValue());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

        Call<List<TypePlante>> call2 = apiInterface.getTypePlante();
        call2.enqueue(new Callback<List<TypePlante>>() {
            @Override
            public void onResponse(Call call, Response response) {
                //Log.d(TAG, "onResponse: " + response);
                mTypePlante.setValue((List<TypePlante>) response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }






}
