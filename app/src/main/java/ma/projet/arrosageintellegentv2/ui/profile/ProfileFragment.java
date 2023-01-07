package ma.projet.arrosageintellegentv2.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;

import java.util.List;

import ma.projet.arrosageintellegentv2.R;
import ma.projet.arrosageintellegentv2.beans.AppUser;
import ma.projet.arrosageintellegentv2.beans.EspaceVert;
import ma.projet.arrosageintellegentv2.networking.ApiClient;
import ma.projet.arrosageintellegentv2.networking.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    SharedPreferences sp;
    SharedPreferences sp1;
    TextView txt_id, txt_name, txt_role, txt_address, txt_phone, txt_email;
    ImageView img;
    MutableLiveData<List<AppUser>> muser = new MutableLiveData<>();

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    private static final String TAG = "MainActivityViewModel";

    int value;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MY_SHARED_PREF", getActivity().MODE_PRIVATE);

        value = sharedPreferences.getInt("user_id", 0);

        this.init();
       sp= this.getActivity().getSharedPreferences("profiledata", Context.MODE_PRIVATE);
        txt_name = (TextView)view.findViewById(R.id.usernameP);
        txt_role = (TextView)view.findViewById(R.id.roleP);
        txt_address =(TextView)view.findViewById(R.id.addressP);
        txt_phone = (TextView)view.findViewById(R.id.numberP);
        txt_email = view.findViewById(R.id.emailP);
        img = view.findViewById(R.id.profileP);
        String name = sp.getString("name","");
        String role = sp.getString("role","");
        String address = sp.getString("address","");
        String phone = sp.getString("phone","");
        String email = sp.getString("email", "");
        String image = sp.getString("image", "");
        txt_email.setText(email);
        txt_name.setText(name);
        txt_role.setText(role);
        txt_address.setText(address);
        txt_phone.setText(phone);

        Glide.with(getActivity())
                .asBitmap()
                .load(image)
                .centerCrop()
                .into(img);

        return view;
    }

    private void init() {

        ApiInterface client = ApiClient.getClient().create(ApiInterface.class);
        Call<AppUser> calltargetResponse = client.getUser(String.valueOf(value));

        calltargetResponse.enqueue(new Callback<AppUser>() {

            @Override
            public void onResponse(Call<AppUser> call, Response<AppUser> response) {
                AppUser UserResponse = response.body();
                Log.i("sabri", String.valueOf(UserResponse));
                int id = (int) response.body().getId();
                String name = response.body().getUsername();
                String address = response.body().getAddress();
                String phone = response.body().getPhone();
                String role = response.body().getRole();
                String  password = response.body().getPassword();
                String email = response.body().getEmail();
                String image = response.body().getImage();
                List<EspaceVert> espacesVerts = (List<EspaceVert>) response.body().getEspaceVertResponse();


                SharedPreferences.Editor editor = sp.edit();
                editor.putString("id", String.valueOf(id));
                editor.putString("name", name);
                editor.putString("address", address);
                editor.putString("phone", phone);
                editor.putString("role", role);
                editor.putString("password", password);
                editor.putString("email", email);

                editor.putString("image", image);
                editor.commit();
            }

            @Override
            public void onFailure(Call<AppUser> call, Throwable t) {
Log.i("dzzzzzzz",t.toString())   ;         }
        });


    }
}