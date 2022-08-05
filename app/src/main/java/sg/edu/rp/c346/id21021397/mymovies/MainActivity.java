package sg.edu.rp.c346.id21021397.mymovies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTest;
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
        spRating = findViewById(R.id.spRatingMain);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShow = findViewById(R.id.btnDelete);
        tvTest = findViewById(R.id.tvTestMain);
        spRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Rating = "G";
                        tvTest.setText(Rating);
                        break;
                    case 1:
                        Rating = "PG";
                        tvTest.setText(Rating);
                        break;
                    case 2:
                        Rating = "PG13";
                        tvTest.setText(Rating);
                        break;
                    case 3:
                        Rating = "NC16";
                        tvTest.setText(Rating);
                        break;
                    case 4:
                        Rating = "M18";
                        tvTest.setText(Rating);
                        break;
                    case 5:
                        Rating = "R21";
                        tvTest.setText(Rating);
                        break;
                    default:
                        Rating = "";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvTest.setText("trash");
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = etTitle.getText().toString();
                String Genre = etGenre.getText().toString();

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Notice");
                myBuilder.setMessage("Title: " + Title + "\n Genre: " + Genre + "\n Year: " + etYear.getText().toString() + "\n Rating: " + Rating);
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("DO NOT INSERT", null);

                myBuilder.setNegativeButton("INSERT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int Year = 0;
                        if(etYear.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this, "Enter a Valid Year", Toast.LENGTH_LONG).show();
                        } else {
                            Year = Integer.parseInt(etYear.getText().toString());
                        }
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

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


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