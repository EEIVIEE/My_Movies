package sg.edu.rp.c346.id21021397.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etGenre, etYear;
    Button btnInsert, btnShow;
    Spinner spRating;
    String Rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spRating = findViewById(R.id.spRating);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShow = findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = etTitle.getText().toString();
                String Genre = etGenre.getText().toString();
                int Year = 0;
                if(etYear.getText().toString().isEmpty()){

                } else {
                    Year = Integer.parseInt(etYear.getText().toString());
                }

                spRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                Rating = "G";
                                break;
                            case 1:
                                Rating = "PG";
                                break;
                            case 2:
                                Rating = "PG13";
                                break;
                            case 3:
                                Rating = "NC16";
                                break;
                            case 4:
                                Rating = "M18";
                                break;
                            case 5:
                                Rating = "R21";
                                break;
                            default:
                                Rating = "";
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                if (Title.isEmpty() || Genre.isEmpty() || Year > 2022 || Year < 1960){
                    Toast.makeText(MainActivity.this, "Insert unsuccessful",
                            Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dbh = new DBHelper(MainActivity.this);
                    long inserted_id = dbh.insertMovie(Title, Genre, Year, Rating);

                    if (inserted_id != -1) {
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,
                        DisplayMovies.class);
                startActivity(i);
            }
        });
    }
}