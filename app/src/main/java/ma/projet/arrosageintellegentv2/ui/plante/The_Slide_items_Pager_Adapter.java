package ma.projet.arrosageintellegentv2.ui.plante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ma.projet.arrosageintellegentv2.R;
import ma.projet.arrosageintellegentv2.beans.Plante;

public class The_Slide_items_Pager_Adapter extends PagerAdapter {

    private Context Mcontext;
    private List<Plante> theSlideItemsModelClassList;

    

    public The_Slide_items_Pager_Adapter(Context Mcontext) {
        this.theSlideItemsModelClassList = new ArrayList<Plante>();
        this.Mcontext = Mcontext;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.the_items_layout,null);

        ImageView featured_image = sliderLayout.findViewById(R.id.my_featured_image);
        TextView caption_title = sliderLayout.findViewById(R.id.my_caption_title);


        Glide.with(Mcontext).load(theSlideItemsModelClassList.get(position).getImage()).into(featured_image);
        caption_title.setText(theSlideItemsModelClassList.get(position).getLibelle());
        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

     @Override
    public int getCount() {
       return theSlideItemsModelClassList.size();
    }

    public void setObjects(List<Plante> plantes) {
        this.theSlideItemsModelClassList=plantes;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
