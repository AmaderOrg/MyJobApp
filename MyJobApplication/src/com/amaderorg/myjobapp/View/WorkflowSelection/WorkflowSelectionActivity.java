package com.amaderorg.myjobapp.View.WorkflowSelection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.amaderorg.myjobapp.Presenter.WorkflowSelection.WorkflowSelectionPresenter;
import com.amaderorg.myjobapp.R;
import com.amaderorg.myjobapp.View.Contacts.ManageContactsActivity;
import com.amaderorg.myjobapp.View.MassEmail.MassEmailActivity;
import com.amaderorg.myjobapp.View.Templates.ManageTemplatesActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Workflow selection activity.
 */
public class WorkflowSelectionActivity extends Activity implements IWorkflowSelectionPresenterListener {
    /**
     * View
     */
    private View mView;
    /**
     * Workflow selection presenter.
     */
    private WorkflowSelectionPresenter mPresenter;
    /**
     * Map between action and activity.
     */
    private Map<String, Class> mMapActionAndActivity = new HashMap<>();

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(android.net.Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p/>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IWorkflowSelectionView workflowSelectionView = new WorkflowSelectionView(getApplicationContext());
        populateMap();
        mPresenter = new WorkflowSelectionPresenter(this, workflowSelectionView, this, mMapActionAndActivity);
        mView = workflowSelectionView.getView();
        setContentView(mView);
    }

    /**
     * This populates the map between action and their corresponding activities.
     */
    private void populateMap() {
        mMapActionAndActivity.put(getString(R.string.manage_templates), ManageTemplatesActivity.class);
        mMapActionAndActivity.put(getString(R.string.send_email), MassEmailActivity.class);
        mMapActionAndActivity.put(getString(R.string.manage_contacts), ManageContactsActivity.class);
    }

    /**
     * Starts the supplied intent.
     *
     * @param intent Intent.
     */
    @Override
    public void startIntent(Intent intent) {
        if (intent != null) {
            startActivity(intent);
        } else {
            System.out.println("Not sure which activity to start.");
        }
    }
}
