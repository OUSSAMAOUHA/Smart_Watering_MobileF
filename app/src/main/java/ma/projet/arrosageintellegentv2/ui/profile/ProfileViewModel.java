package ma.projet.arrosageintellegentv2.ui.profile;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ma.projet.arrosageintellegentv2.beans.AppUser;
import ma.projet.arrosageintellegentv2.networking.ApiClient;
import ma.projet.arrosageintellegentv2.networking.ApiInterface;
import ma.projet.arrosageintellegentv2.utils.Crendentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends ViewModel {
    MutableLiveData<List<AppUser>> muser = new MutableLiveData<>();
    private static final String TAG = "MainActivityViewModel";
    public ProfileViewModel(@NonNull Application application) {
       super();
    }

    public LiveData<List<AppUser>> getProducts() {
        return muser;
    }



}