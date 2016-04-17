package com.amaderorg.myjobapp.View.WorkflowSelection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amaderorg.myjobapp.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Workflow selection view.
 */
public class WorkflowSelectionView extends RelativeLayout implements IWorkflowSelectionView {
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
            if (mWorkflowSelectionListener != null) {
                mWorkflowSelectionListener.onWorkflowSelect(mMapIdAndActionString.get(v.getId()));
            } else {
                System.out.println("No one to notify that a workflow is selected.");
            }
        }
    };

    /**
     * Constructor.
     *
     * @param context Context.
     */
    public WorkflowSelectionView(Context context) {
        super(context);
        mContext = context;
        mMapIdAndActionString.put(R.id.manage_templates, getResources().getString(R.string.manage_templates));
        mMapIdAndActionString.put(R.id.send_email, getResources().getString(R.string.send_email));
        mMapIdAndActionString.put(R.id.manage_contacts, getResources().getString(R.string.manage_contacts));
    }

    /**
     * Constructor.
     *
     * @param context Context.
     * @param attrs   Attributes.
     */
    public WorkflowSelectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor.
     *
     * @param context      Context.
     * @param attrs        Attributes
     * @param defStyleAttr Definition style attributes.
     */
    public WorkflowSelectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Constructor.
     *
     * @param context      Context.
     * @param attrs        Attributes.
     * @param defStyleAttr Definition style attributes.
     * @param defStyleRes  Definition style resources.
     */
    public WorkflowSelectionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Sets the workflow selection listener.
     *
     * @param listener Workflow selection listener.
     */
    @Override
    public void setWorkflowSelectionListener(IWorkflowSelectionListener listener) {
        mWorkflowSelectionListener = listener;
    }

    /**
     * Returns the view.
     *
     * @return The view that it inflates.
     */
    @Override
    public View getView() {
        View view = inflate(mContext, R.layout.workflow_selection, this);
        // Set up listeners
        view.findViewById(R.id.manage_templates).setOnClickListener(mOnClickListener);
        view.findViewById(R.id.send_email).setOnClickListener(mOnClickListener);
        view.findViewById(R.id.manage_contacts).setOnClickListener(mOnClickListener);
        return view;
    }
}