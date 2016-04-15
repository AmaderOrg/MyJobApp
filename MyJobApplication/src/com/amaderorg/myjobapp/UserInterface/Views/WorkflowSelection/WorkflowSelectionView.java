package com.amaderorg.myjobapp.UserInterface.Views.WorkflowSelection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amaderorg.myjobapp.R;
import com.amaderorg.myjobapp.Presenter.WorkflowSelection.IWorkflowSelectionListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Workflow selection view.
 */
public class WorkflowSelectionView extends RelativeLayout {
    /**
     * Context.
     */
    private Context mContext;
    /**
     * Map of action and id.
     */
    private Map<Integer, String> mMapIdAndActionString = new HashMap<>();
    /**
     * Workflow action selection listener.
     */
    private IWorkflowSelectionListener mWorkflowSelectionListener;
    /**
     * Button on click listener.
     */
    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            mWorkflowSelectionListener.onWorkflowSelect(mMapIdAndActionString.get(v.getId()));
        }
    };

    /**
     * Constructor.
     *
     * @param context Context.
     */
    public WorkflowSelectionView(Context context, IWorkflowSelectionListener listener) {
        super(context);
        mContext = context;
        mMapIdAndActionString.put(R.id.manage_templates, getResources().getString(R.string.manage_templates));
        mMapIdAndActionString.put(R.id.send_email, getResources().getString(R.string.send_email));
        mMapIdAndActionString.put(R.id.manage_contacts, getResources().getString(R.string.manage_contacts));
        mWorkflowSelectionListener = listener;
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
        // Set up listeners
        view.findViewById(R.id.manage_templates).setOnClickListener(mOnClickListener);
        view.findViewById(R.id.send_email).setOnClickListener(mOnClickListener);
        view.findViewById(R.id.manage_contacts).setOnClickListener(mOnClickListener);
        return view;
    }
}
