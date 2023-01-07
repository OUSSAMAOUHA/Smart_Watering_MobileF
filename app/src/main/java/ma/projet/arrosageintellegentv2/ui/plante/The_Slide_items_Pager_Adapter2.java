package ma.projet.arrosageintellegentv2.ui.plante;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ma.projet.arrosageintellegentv2.R;
import ma.projet.arrosageintellegentv2.beans.EspaceVert;
import ma.projet.arrosageintellegentv2.beans.Plante;
import ma.projet.arrosageintellegentv2.beans.TypePlante;

public class The_Slide_items_Pager_Adapter2 extends PagerAdapter {

    private Context Mcontext;
    private List<TypePlante> theSlideItemsModelClassList;



    public The_Slide_items_Pager_Adapter2(Context Mcontext) {
        this.theSlideItemsModelClassList = new ArrayList<TypePlante>();
        this.Mcontext = Mcontext;

    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View sliderLayout2 = inflater.inflate(R.layout.the_items_layout2,null);



        TextView caption_title1 = sliderLayout2.findViewById(R.id.my_caption_title1);
        TextView caption_title4 = sliderLayout2.findViewById(R.id.my_caption_title4);
        TextView caption_title3 = sliderLayout2.findViewById(R.id.my_caption_title3);
        TextView caption_title2 = sliderLayout2.findViewById(R.id.my_caption_title2);
        TextView caption_title5 = sliderLayout2.findViewById(R.id.my_caption_title5);



        ;


        caption_title1.setText(theSlideItemsModelClassList.get(position).getName());
        caption_title4.setText(String.valueOf(theSlideItemsModelClassList.get(position).getHumiditeMax()));
        caption_title5.setText(String.valueOf(theSlideItemsModelClassList.get(position).getHumiditeMin()));
        caption_title3.setText(String.valueOf(theSlideItemsModelClassList.get(position).getTemperature()));
        caption_title2.setText(String.valueOf(theSlideItemsModelClassList.get(position).getLuminosite()));




        container.addView(sliderLayout2);
        return sliderLayout2;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return theSlideItemsModelClassList.size();

    }

    public void setObjects(List<TypePlante> typePlantes ) {
        this.theSlideItemsModelClassList=typePlantes;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
