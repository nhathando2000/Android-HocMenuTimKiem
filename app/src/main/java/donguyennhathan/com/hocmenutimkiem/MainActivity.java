package donguyennhathan.com.hocmenutimkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


import donguyennhathan.com.hocmenutimkiem.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addVocabulary();
    }

    private void addVocabulary() {
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(getResources().getStringArray(R.array.arrVocabulary));
        binding.lvVocabulary.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_main_option, menu);

        final MenuItem mnSearch = menu.findItem(R.id.mnSearch);
        SearchView searchView = (SearchView) mnSearch.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
