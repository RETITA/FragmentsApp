package com.example.retita.myfragmentsapp.Controllers.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.retita.myfragmentsapp.Controllers.Fragments.DetailsFragment;
import com.example.retita.myfragmentsapp.R;

public class DetailsActivity extends AppCompatActivity {

    // 1 - Declare detail fragment

    private DetailsFragment detailFragment;
    // 1 - Create static variable to identify Intent

    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // 2 - Configure and show home fragment
        this.configureAndShowDetailFragment();
    }

    @Override

    public void onResume() {

        super.onResume();

        // 3 - Call update method here because we are sure that DetailFragment is visible

        this.updateDetailFragmentTextViewWithIntentTag();

    }

    // 2 - Update DetailFragment with tag passed from Intent

    private void updateDetailFragmentTextViewWithIntentTag(){

        // Get button's tag from intent

        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);

        // Update DetailFragment's TextView

        detailFragment.updateTextView(buttonTag);

    }

    private void configureAndShowDetailFragment(){

        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container

        detailFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);


        if (detailFragment == null) {

            // B - Create new main fragment

            detailFragment = new DetailsFragment();

            // C - Add it to FrameLayout container

            getSupportFragmentManager().beginTransaction()

                    .add(R.id.frame_layout_detail, detailFragment)

                    .commit();

        }

    }
}
