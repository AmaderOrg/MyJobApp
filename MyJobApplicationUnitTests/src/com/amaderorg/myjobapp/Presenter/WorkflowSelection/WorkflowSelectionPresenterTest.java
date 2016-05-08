package com.amaderorg.myjobapp.Presenter.WorkflowSelection;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Unit Test for the Workflow Selection Presenter.
 */
public class WorkflowSelectionPresenterTest extends ApplicationTestCase<Application> {
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
        
    }
}
