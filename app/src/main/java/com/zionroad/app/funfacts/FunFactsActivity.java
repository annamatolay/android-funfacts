package com.zionroad.app.funfacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {
    // Define keys for activity state storing
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    // TAG needed for logging
    private final String TAG = ">>>" + this.getClass().getSimpleName() + ">>>";
    // Declare View variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    // Assign default values this fields
    // So, if the user rotate the screen without touching, then the app work correctly
    private String mFact = FactBook.getDefaultFact();
    private Integer mColor = ColorWheel.getDefaultColor();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // This call, when the activity want to save its own progress
        super.onSaveInstanceState(outState);
        // Put the fields data with their keys to the instance state
        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // This call, when the activity want to load its own progress
        super.onRestoreInstanceState(savedInstanceState);
        // Get the fields data from the instance state (based the defined keys)
        // (second argument will be the default return value (and it's optional))
        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        // Update the screen with the earned fact, background and text color
        updateScreen();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the widgets from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        // Add a listener to the button, what called, when the user tap on the screen
        mShowFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the random values from their class
                mFact = FactBook.getFact();
                mColor = ColorWheel.getColors();
                // After that, update the screen with them
                updateScreen();
            }
        });

        // Create a toast with target, message and time (as argument)
        Toast toast = Toast.makeText(FunFactsActivity.this, "Activity created!", Toast.LENGTH_SHORT);
        // Set the toast place (it isn't necessary, because toasts have default place), then show it
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
        toast.show();

        // Logging info
        Log.i(TAG, "Activity starting!");
    }

    private void updateScreen() {
        // Set the fields values for the widgets
        mFactTextView.setText(mFact);
        mRelativeLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);
    }
}
