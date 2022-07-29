package sg.edu.rp.c346.id21021397.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayMovies extends AppCompatActivity {

    Button btnPG;
    ArrayList<Movie> alMovie;
    ListView lvMovie;
    //ArrayAdapter aaSong;
    CustomAdapter caSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);

        btnPG = findViewById(R.id.btnPG);
        lvMovie= findViewById(R.id.lvMovie);
        alMovie = new ArrayList<>();
        //aaSong = new ArrayAdapter<Song>(this,
        //android.R.layout.simple_list_item_1, alSong);
        caSong = new CustomAdapter(this, R.layout.row, alMovie);
        lvMovie.setAdapter(caSong);

        DBHelper dbh = new DBHelper(DisplayMovies.this);
        alMovie.clear();
        alMovie.addAll(dbh.getAllMovies());
        caSong.notifyDataSetChanged();

        btnPG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(DisplayMovies.this);
                alMovie.clear();
                // al.addAll(dbh.getAllNotes());
                String filterText = "PG";
                alMovie.addAll(dbh.getPGMovies(filterText));

                caSong.notifyDataSetChanged();
            }
        });

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Movie data = alMovie.get(position);
                Intent i = new Intent(DisplayMovies.this,
                        EditActivity.class);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(DisplayMovies.this);
        alMovie.clear();
        alMovie.addAll(dbh.getAllMovies());
        caSong.notifyDataSetChanged();
    }
}
