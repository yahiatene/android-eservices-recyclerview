package android.eservices.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements GameActionInterface{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Toolbar toolbar;
    private CoordinatorLayout coordinatorLayout;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = findViewById(R.id.coordinator_layout);
        setupRecyclerView();


    }

    private void setupRecyclerView() {
        //TODO Bind recyclerview and set its adapter.
        recyclerView = (RecyclerView) findViewById(R.id.my_recyclerview);

        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);


        // specify an adapter (see also next example)
        myAdapter = new MyAdapter(DataGenerator.generateData(), this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.notifyDataSetChanged();

        //Use data generator to get data to display.
    }

    public void displaySnackBar(String message) {
        //TODO write a method that displays a snackbar in the coordinator layout with the "message" parameter as content.

        CoordinatorLayout coord = findViewById(R.id.coordinator_layout);

        Snackbar.make(coord,message,Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onGameInfoClicked(String gameTitle) {
        displaySnackBar(gameTitle);
    }

    @Override
    public void onGameClicked(String gameTitle) {
        displaySnackBar(gameTitle);
    }

    //TODO create callback methods for item click
    //Use ressource strings to get the text to display

}
