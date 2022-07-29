package sg.edu.rp.c346.id21021397.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvGenre = rowView.findViewById(R.id.tvGenre);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        ImageView ivRate = rowView.findViewById(R.id.imageViewRating);


        // Obtain the Android Version information based on the position
        Movie currentMovie = movieList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentMovie.getName());
        tvGenre.setText(String.valueOf(currentMovie.getGenre()));
        tvYear.setText(currentMovie.toString());
        if(currentMovie.getRating().equals("G")  ){
            ivRate.setImageResource(R.drawable.rating_g);
        } else if(currentMovie.getRating().equals("PG") ){
            ivRate.setImageResource(R.drawable.rating_pg);
        } else if(currentMovie.getRating().equals("PG13")){
            ivRate.setImageResource(R.drawable.rating_pg13);
        } else if(currentMovie.getRating().equals("NC16")){
            ivRate.setImageResource(R.drawable.rating_nc16);
        } else if(currentMovie.getRating().equals("M18")){
            ivRate.setImageResource(R.drawable.rating_m18);
        } else if(currentMovie.getRating().equals("R21")){
            ivRate.setImageResource(R.drawable.rating_r21);
        }




        return rowView;
    }

}
