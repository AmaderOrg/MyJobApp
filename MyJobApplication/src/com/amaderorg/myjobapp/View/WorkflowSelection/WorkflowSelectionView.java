package com.amaderorg.myjobapp.View.WorkflowSelection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amaderorg.myjobapp.R;

/**
 * Workflow selection view.
 */
public class WorkflowSelectionView extends RelativeLayout {
    /**
     * Context.
     */
    private Context mContext;

    /**
     * Constructor.
     *
     * @param context Context.
     */
    public WorkflowSelectionView(Context context) {
        super(context);
        mContext = context;
    }

    /**
     * Constructor.
     *
     * @param context Context.
     * @param attrs Attributes.
     */
    public WorkflowSelectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor.
     *
     * @param context Context.
     * @param attrs Attributes
     * @param defStyleAttr Definition style attributes.
     */
    public WorkflowSelectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Constructor.
     *
     * @param context Context.
     * @param attrs Attributes.
     * @param defStyleAttr Definition style attributes.
     * @param defStyleRes Definition style resources.
     */
    public WorkflowSelectionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Returns the view.
     *
     * @return The view that it inflates.
     */
    public View getView() {
        View view = inflate(mContext, R.layout.workflow_selection, this);
        return view;
    }
}
