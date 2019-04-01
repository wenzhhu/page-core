package org.devqa.web.page;

import static org.junit.Assert.*;

import org.devqa.web.page.AbstractPage.ActionPerformer;
import org.devqa.web.page.action.Action;
import org.devqa.web.page.action.ActionRequest;
import org.devqa.web.page.action.LogoutAction;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.devqa.web.page.action.SingleTargetAction.*;

import static org.devqa.web.page.action.ActionRequestFactory.*;

public class CompositePageTest {
    private final CompositePage.Builder PAGE_BUILDER = new CompositePage.Builder("test");
    private final Page PAGE_SUPPORTING_NOTHING = new CompositePage.Builder("test").build();

    private final Action CLICK_OK = click("OK");
    private final ActionRequest CLICK_OK_REQUEST = click("OK");
    private final ActionPerformer CLICK_OK_ACTION_PERFORMER = mock(ActionPerformer.class);
    private final Page PAGE_SUPPORTING_CLICK_OK = new CompositePage.Builder("test")
            .action(CLICK_OK, CLICK_OK_ACTION_PERFORMER).build();

    private final ActionRequest RUNTIME_ACTION_CLICK_OK = click("OK");
    private final ActionRequest CLICK_CANCEL = click("CANCEL");

    private final ActionRequest AGREE_TERM = agree("TERM");

    private final ActionPerformer NO_OP_PERFORMER = mock(ActionPerformer.class);

    @Test(expected = NullPointerException.class)
    public void nullActionThrowsNPEWhenPerformed() {
        PAGE_SUPPORTING_NOTHING.performAction(null);
    }

    @Test(expected = UnsupportedActionException.class)
    public void unsupportedActionThrowsExceptionWhenPerformed() {
        PAGE_SUPPORTING_NOTHING.performAction(CLICK_OK_REQUEST);
    }

    @Test(expected = NullPointerException.class)
    public void nullActionPerformerThrowsNPEWhenAdded() {
        new CompositePage.Builder("test").action(CLICK_OK, null);
    }

    @Test(expected = NullPointerException.class)
    public void nullActionThrowsNPEWhenAdded() {
        new CompositePage.Builder("test").action(null, CLICK_OK_ACTION_PERFORMER);
    }

    @Test
    public void actionGetsPerformedIfSupported() {
        PAGE_SUPPORTING_CLICK_OK.performAction(RUNTIME_ACTION_CLICK_OK);

        verify(CLICK_OK_ACTION_PERFORMER).perform(RUNTIME_ACTION_CLICK_OK);
        ;
    }

    @Test(expected = UnsupportedActionException.class)
    public void unsupportedActionThrowsExceptionWhenPerformedDifferentActionTarget() {
        PAGE_SUPPORTING_CLICK_OK.performAction(CLICK_CANCEL);
    }

    @Test(expected = UnsupportedActionException.class)
    public void unsupportedActionThrowsExceptionWhenPerformedDifferentAction() {
        PAGE_SUPPORTING_CLICK_OK.performAction(AGREE_TERM);
    }

    // No Target Action test
    @Test
    public void testNoTargetAction() {
        Page page = PAGE_BUILDER.action(LogoutAction.Logout, NO_OP_PERFORMER).build();
        page.performAction(LogoutAction.Logout);

        verify(NO_OP_PERFORMER).perform(LogoutAction.Logout);
        ;
    }

    // Enter text action
    @Test
    public void sameEnterTextActionRequestShouldBePerformed() {
        Page page = PAGE_BUILDER.action(enterText("name"), NO_OP_PERFORMER).build();
        page.performAction(enterText("name", "wenzhhu"));

        verify(NO_OP_PERFORMER).perform(enterText("name", "wenzhhu"));
    }

    @Test(expected = UnsupportedActionException.class)
    public void differentEnterTextActionTargetShouldNotBeSupported() {
        Page page = PAGE_BUILDER.action(enterText("name"), NO_OP_PERFORMER).build();
        page.performAction(enterText("password", "wenzhhu"));
    }

}
