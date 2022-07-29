package sg.edu.rp.c346.id21021397.mymovies;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView tvTest;
    EditText etID, etTitle, etGenre, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    Movie data;
    Spinner spRating;
    String Rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvTest = findViewById(R.id.tvTestMain);
        etID = findViewById(R.id.etID);
        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spRating = findViewById(R.id.spRatingMain);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);



        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");

        etID.setFocusable(false);
        etID.setText(String.valueOf(data.getId()));
        etTitle.setText(data.getName());
        etGenre.setText(data.getGenre());
        etYear.setText(String.valueOf(data.getYearReleased()));
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

                }
            });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setName(etTitle.getText().toString());
                data.setGenre(etGenre.getText().toString());
                data.setYearReleased(Integer.parseInt(etYear.getText().toString()));
                data.setRating(Rating);
                dbh.updateMovie(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(data.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}