package com.amaderorg.myjobapp.View.WorkflowSelection;

import android.view.View;

/**
 * Workflow selection view interface.
 */
public interface IWorkflowSelectionView {
    /**
     * Sets the workflow selection listener.
     *
     * @param listener Workflow selection listener.
     */
    void setWorkflowSelectionListener(IWorkflowSelectionListener listener);

    /**
     * Returns the view.
     *
     * @return The view that it inflates.
     */
    View getView();
}
