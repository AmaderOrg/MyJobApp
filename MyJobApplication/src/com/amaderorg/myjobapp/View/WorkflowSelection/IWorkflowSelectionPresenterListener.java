package com.amaderorg.myjobapp.View.WorkflowSelection;

import android.content.Intent;

/**
 * Listener listening to the workflow selection presenter.
 */
public interface IWorkflowSelectionPresenterListener {
    /**
     * Starts the supplied intent.
     *
     * @param intent Intent.
     */
    void startIntent(Intent intent);
}
