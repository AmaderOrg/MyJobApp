package com.amaderorg.myjobapp.Presenter.WorkflowSelection;

import android.content.Context;
import android.content.Intent;
import com.amaderorg.myjobapp.Model.Constants.Constants;
import com.amaderorg.myjobapp.R;
import com.amaderorg.myjobapp.View.Contacts.ManageContactsActivity;
import com.amaderorg.myjobapp.View.MassEmail.MassEmailActivity;
import com.amaderorg.myjobapp.View.Templates.ManageTemplatesActivity;
import com.amaderorg.myjobapp.View.WorkflowSelection.IWorkflowSelectionListener;
import com.amaderorg.myjobapp.View.WorkflowSelection.IWorkflowSelectionPresenterListener;
import com.amaderorg.myjobapp.View.WorkflowSelection.IWorkflowSelectionView;

import java.util.HashMap;
import java.util.Map;

/**
 * Workflow Selection Presenter. The presenter knows what activities to navigate to and notifies the same to the
 * WorkflowSelectionActivity.
 */
public class WorkflowSelectionPresenter implements IWorkflowSelectionListener {
    /**
     * Workflow selection view.
     */
    private IWorkflowSelectionView mView;

    /**
     * Workflow selection presenter listener.
     */
    private IWorkflowSelectionPresenterListener mWorkflowSelectionPresenterListener;

    /**
     * Context.
     */
    private Context mContext;

    /**
     * Map between action and activity.
     */
    private Map<String, Class> mMapActionAndActivity = new HashMap<>();

    /**
     * Constructor.
     *
     * @param context Context.
     * @param view    Workflow selection view that this presenter will have logic for.
     */
    public WorkflowSelectionPresenter(Context context, IWorkflowSelectionView view, IWorkflowSelectionPresenterListener listener) {
        mContext = context;
        mView = view;
        mWorkflowSelectionPresenterListener = listener;
        if (mView != null) {
            mView.setWorkflowSelectionListener(this);
        }
        populateMap();
    }

    /**
     * This populates the map between action and their corresponding activities.
     */
    private void populateMap() {
        mMapActionAndActivity.put(mContext.getString(R.string.manage_templates), ManageTemplatesActivity.class);
        mMapActionAndActivity.put(mContext.getString(R.string.send_email), MassEmailActivity.class);
        mMapActionAndActivity.put(mContext.getString(R.string.manage_contacts), ManageContactsActivity.class);
    }

    /**
     * This method chooses the activity to navigate to based on the action.
     *
     * @param action Action to be performed.
     */
    private void chooseActivity(String action) {
        Intent intent = new Intent(mContext, mMapActionAndActivity.get(action));
        intent.putExtra(Constants.ACTION_NAME, action);
        if (mWorkflowSelectionPresenterListener != null) {
            mWorkflowSelectionPresenterListener.startIntent(intent);
        }
    }

    /**
     * On workflow selection.
     *
     * @param action Name of the action to be performed on workflow select.
     */
    @Override
    public void onWorkflowSelect(String action) {
        System.out.println("Action: " + action);
        chooseActivity(action);
    }
}