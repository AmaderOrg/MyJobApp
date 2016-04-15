package com.amaderorg.myjobapp.UserInterface.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.amaderorg.myjobapp.UserInterface.Activities.WorkflowSelection.WorkflowSelectionActivity;

public class LaunchActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, WorkflowSelectionActivity.class);
        startActivity(intent);
    }
}
