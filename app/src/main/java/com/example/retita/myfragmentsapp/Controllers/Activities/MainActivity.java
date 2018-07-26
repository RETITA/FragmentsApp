package com.example.retita.myfragmentsapp.Controllers.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.retita.myfragmentsapp.Controllers.Fragments.DetailsFragment;
import com.example.retita.myfragmentsapp.Controllers.Fragments.MainFragment;
import com.example.retita.myfragmentsapp.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener{

    // 1 - Declare main fragment

    private MainFragment mainFragment;
    // 1 - Declare detail fragment

    private DetailsFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2 - Configure and show home fragment

        this.configureAndShowMainFragment();
        // 2 - Configure and show detail fragment

        this.configureAndShowDetailFragment();
    }


    private void configureAndShowMainFragment(){

        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);


        if (mainFragment == null) {

            // B - Create new main fragment

            mainFragment = new MainFragment();

            // C - Add it to FrameLayout container

            getSupportFragmentManager().beginTransaction()

                    .add(R.id.frame_layout_main, mainFragment)

                    .commit();

        }

    }

    private void configureAndShowDetailFragment(){

        detailFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);


        //A - We only add DetailFragment in Tablet mode (If found frame_layout_detail)

        if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {

            detailFragment = new DetailsFragment();

            getSupportFragmentManager().beginTransaction()

                    .add(R.id.frame_layout_detail, detailFragment)

                    .commit();

        }

    }

    @Override

    public void onButtonClicked(View view) {

        Log.e(getClass().getSimpleName(),"Button clicked !");
        // 3 - Check if detail fragment is not created or if not visible

        // 1 - Retrieve button tag

        int buttonTag = Integer.parseInt(view.getTag().toString());



        // 2 - Check if DetailFragment is visible (Tablet)

        if (detailFragment != null && detailFragment.isVisible()) {

            // 2.1 - TABLET : Update directly TextView

            detailFragment.updateTextView(buttonTag);

        } else {

            // 2.2 - SMARTPHONE : Pass tag to the new intent that will show DetailActivity (and so DetailFragment)

            Intent i = new Intent(this, DetailsActivity.class);

            i.putExtra(DetailsActivity.EXTRA_BUTTON_TAG, buttonTag);

            startActivity(i);

        }

    }
}
