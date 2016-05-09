package com.amaderorg.myjobapp.Presenter.WorkflowSelection;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.test.ApplicationTestCase;
import com.amaderorg.myjobapp.Model.Constants.Constants;
import com.amaderorg.myjobapp.View.Contacts.ManageContactsActivity;
import com.amaderorg.myjobapp.View.MassEmail.MassEmailActivity;
import com.amaderorg.myjobapp.View.Templates.ManageTemplatesActivity;
import com.amaderorg.myjobapp.View.WorkflowSelection.WorkflowSelectionActivity;
import com.amaderorg.myjobapp.View.WorkflowSelection.WorkflowSelectionView;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Unit Test for the Workflow Selection Presenter.
 */
public class WorkflowSelectionPresenterTest extends ApplicationTestCase<Application> {
    /**
     * Context.
     */
    private Context mContext;
    /**
     * Workflow selection view instance.
     */
    private WorkflowSelectionView mWorkflowSelectionView;
    /**
     * Workflow selection activity instance.
     */
    private WorkflowSelectionActivity mWorkflowSelectionPresenterListener;
    /**
     * Map between the action and its corresponding activity.
     */
    private Map<String, Class> mMapActionAndActivity = new HashMap<>();
    /**
     * The workflow selection presenter instance.
     */
    private WorkflowSelectionPresenter mWorkflowSelectionPresenter;
    /**
     * The argument captor.
     */
    private ArgumentCaptor<Intent> mIntentCaptor = ArgumentCaptor.forClass(Intent.class);
    /**
     * Action strings.
     */
    private static final String MANAGE_TEMPLATES = "Manage Templates";
    private static final String SEND_EMAIL = "Send Email";
    private static final String MANAGE_CONTACTS = "Manage Contacts";
    /**
     * The array that stores all the action strings.
     */
    private static final String[] ACTION_STRINGS = new String[3];

    /**
     * Constructor
     *
     * @param applicationClass Application class.
     */
    public WorkflowSelectionPresenterTest(Class<Application> applicationClass) {
        super(applicationClass);
    }

    /**
     * Constructor.
     */
    public WorkflowSelectionPresenterTest() {
        super(Application.class);
    }

    /**
     * This will do the work to instantiate the Application under test.  After this, your test
     * code must also start and stop the Application.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mContext = getContext();
        mWorkflowSelectionView = mock(WorkflowSelectionView.class);
        mWorkflowSelectionPresenterListener = mock(WorkflowSelectionActivity.class);
        populateCollections();
        mWorkflowSelectionPresenter = new WorkflowSelectionPresenter(mContext, mWorkflowSelectionView,
                mWorkflowSelectionPresenterListener, mMapActionAndActivity);
    }


    /**
     * Unit tests the onWorkFlowSelect() method of the presenter.
     */
    public void testOnWorkflowSelect() {
        for (String ACTION_STRING : ACTION_STRINGS) {
            testForAction(ACTION_STRING);
        }
    }

    /**
     * Tests the method invocation for the specified action.
     *
     * @param actionString Action string.
     */
    private void testForAction(final String actionString) {
        mWorkflowSelectionPresenter.onWorkflowSelect(actionString);
        // Verifies that the start intent method of the activity is called at least once with any intent.
        verify(mWorkflowSelectionPresenterListener, atLeastOnce()).startIntent(Matchers.<Intent>anyObject());
        // Verifies that the start intent method of the activity is called at least once with the intent that the has
        // the desired class name and the desired action string.
        verify(mWorkflowSelectionPresenterListener, atLeastOnce()).startIntent(mIntentCaptor.capture());
        assertEquals("Verify that the name of the activity class matches the name of the class passed to the intent.",
                (mMapActionAndActivity.get(actionString)).getCanonicalName(),
                mIntentCaptor.getValue().getComponent().getClassName());
        assertEquals("Verify that the action string matches the action string passed to the bundle.", actionString,
                mIntentCaptor.getValue().getExtras().get(Constants.ACTION_NAME));
    }

    /**
     * This populates the map between action and their corresponding activities. Also populates the array that stores
     * the names of the actions.
     */
    private void populateCollections() {
        ACTION_STRINGS[0] = MANAGE_TEMPLATES;
        ACTION_STRINGS[1] = SEND_EMAIL;
        ACTION_STRINGS[2] = MANAGE_CONTACTS;
        mMapActionAndActivity.put(MANAGE_TEMPLATES, ManageTemplatesActivity.class);
        mMapActionAndActivity.put(SEND_EMAIL, MassEmailActivity.class);
        mMapActionAndActivity.put(MANAGE_CONTACTS, ManageContactsActivity.class);
    }
}