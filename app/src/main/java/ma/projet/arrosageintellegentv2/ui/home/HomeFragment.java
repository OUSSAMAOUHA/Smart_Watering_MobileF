package ma.projet.arrosageintellegentv2.ui.home;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

import ma.projet.arrosageintellegentv2.R;
import ma.projet.arrosageintellegentv2.beans.EspaceVert;
import ma.projet.arrosageintellegentv2.databinding.FragmentHomeBinding;
import ma.projet.arrosageintellegentv2.ui.espacevert.EspacevertViewModel;

public class HomeFragment extends Fragment {
    // Create the object of TextView and PieChart class
    TextView tvR, tvPython, tvCPP, tvJava;
    PieChart pieChart;
    List<EspaceVert> spaces;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ////////////////////////
        tvR = root.findViewById(R.id.tvR);
        tvPython = root.findViewById(R.id.tvPython);
        tvCPP = root.findViewById(R.id.tvCPP);
        tvJava = root.findViewById(R.id.tvJava);
        pieChart = root.findViewById(R.id.piechart);

        spaces = new ArrayList<EspaceVert>();

        EspacevertViewModel mEspacevertViewModel = new ViewModelProvider(this).get(EspacevertViewModel.class);

        // reception initial les données
        mEspacevertViewModel.init();

        mEspacevertViewModel.getEspace().observe(getActivity(), new Observer<List<EspaceVert>>(){

            @Override
            public void onChanged(List<EspaceVert> espaceVerts) {
                spaces = espaceVerts;
            }
        });

        // Creating a method setData()
        // to set the text in text view and pie chart
        setData();




        //////////////////////////

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setData()
    {

        // Set the percentage of language used
        tvR.setText(Integer.toString(7));
        tvPython.setText(Integer.toString(4));
        tvCPP.setText(Integer.toString(2));
        tvJava.setText(Integer.toString(1));

        spaces.forEach(e -> {
            pieChart.addPieSlice(
                    new PieModel(
                            e.getLibelle(),
                            e.getZones().size(),
                            Color.parseColor("#FFA726")));
        });


        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Ferme1",
                        Integer.parseInt(tvR.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Ferme2",
                        Integer.parseInt(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Ferme3",
                        Integer.parseInt(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Ferme4",
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#29B6F6")));

        // To animate the pie chart
        pieChart.startAnimation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}