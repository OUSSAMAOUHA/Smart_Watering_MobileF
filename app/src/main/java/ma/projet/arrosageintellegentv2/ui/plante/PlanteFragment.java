package ma.projet.arrosageintellegentv2.ui.plante;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import ma.projet.arrosageintellegentv2.R;
import ma.projet.arrosageintellegentv2.StatisticActivity;
import ma.projet.arrosageintellegentv2.ZoneActivity;
import ma.projet.arrosageintellegentv2.adapters.PlanteAdapter;
import ma.projet.arrosageintellegentv2.beans.Plante;
import ma.projet.arrosageintellegentv2.beans.TypePlante;
import ma.projet.arrosageintellegentv2.databinding.FragmentPlanteBinding;
import ma.projet.arrosageintellegentv2.ui.plante.PlanteViewModel;

public class PlanteFragment extends Fragment {

    private static final String TAG = "PlanteFragment";
    private FragmentPlanteBinding binding;
    private ListView list;
    private List<Plante> listItems;
    private List<TypePlante> listTypeItems;
    private ViewPager page;
    private ViewPager page2;
    private TabLayout tabLayout;
    private TabLayout tabLayout2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_plante, container, false);


        page = root.findViewById(R.id.my_pager) ;
        tabLayout = root.findViewById(R.id.my_tablayout);

        page2 = root.findViewById(R.id.my_pager2) ;
        tabLayout2 = root.findViewById(R.id.my_tablayout2);


        binding = FragmentPlanteBinding.inflate(inflater, container, false);

        // instantiate ViewModel

        // reception initial les données
        listItems = new ArrayList<Plante>();
        listTypeItems = new ArrayList<TypePlante>();

        PlanteViewModel pvm = new ViewModelProvider(this).get(PlanteViewModel.class);
        pvm.init();


        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(getActivity());
        The_Slide_items_Pager_Adapter2 item2 = new The_Slide_items_Pager_Adapter2(getActivity());
        page.setAdapter(itemsPager_adapter);
        page2.setAdapter(item2);

        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);
        timer.scheduleAtFixedRate(new The_slide_timer2(),2000,3000);

        tabLayout.setupWithViewPager(page,true);
        tabLayout2.setupWithViewPager(page2,true);

        // set Observer of the DataLive (which is products)
        pvm.getEspace().observe(getActivity(), new Observer<List<Plante>>(){

            @Override
            public void onChanged(List<Plante> plantes) {
                Log.i(TAG, "onchanged in observer is called!");
                listItems = plantes;
                itemsPager_adapter.setObjects(plantes);
                itemsPager_adapter.notifyDataSetChanged();

            }
        });

        pvm.getTypePlante().observe(getActivity(), new Observer<List<TypePlante>>(){

            @Override
            public void onChanged(List<TypePlante> plantes) {
                Log.i(TAG, "onchanged in observer is called!");
                item2.setObjects(plantes);
                item2.notifyDataSetChanged();

            }
        });

        return root;
    }


    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem() < listItems.size()-1) {
                        page.setCurrentItem(page.getCurrentItem()+1);
                    }
                    else
                        page.setCurrentItem(0);
                }
            });
        }
    }
    public class The_slide_timer2 extends TimerTask {
        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page2.getCurrentItem() < listTypeItems.size()-1) {
                        page2.setCurrentItem(page2.getCurrentItem()+1);
                    }
                    else
                        page2.setCurrentItem(0);
                }
            });
        }
    }

}