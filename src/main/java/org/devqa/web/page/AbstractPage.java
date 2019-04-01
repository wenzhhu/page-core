package org.devqa.web.page;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.devqa.web.page.action.Action;
import org.devqa.web.page.action.ActionRequest;
import org.devqa.web.page.assertion.Assertion;
import org.devqa.web.page.assertion.PagePresentedAssertion;

public abstract class AbstractPage implements Page {
    @FunctionalInterface
    public static interface ActionPerformer<T extends Action> {
        public void perform(ActionRequest<T> actionRequest);
    }

    @Override
    public final Page performAction(ActionRequest actionRequest) {
        Objects.requireNonNull(actionRequest, "action request must not be null");

        Action action = actionRequest.getAction();

        ActionPerformer actionPerformer = actionPerformers.get(actionRequest.getAction());

        if (actionPerformer == null) {
            throw new UnsupportedActionException(action + "is not supported by Page " + this);
        } else {
            actionPerformer.perform(actionRequest);
        }

        return this;
    }

    private final Map<Action, ActionPerformer> actionPerformers= new HashMap<>();

    protected final void addSupportedAction(Action action, ActionPerformer performer) {
        Objects.requireNonNull(action, "action must not be null");
        Objects.requireNonNull(performer, "action performer must not be null");

        actionPerformers.put(action, performer);
    }

    protected final Set<Action> getSupportedActions() {
        return actionPerformers.keySet();
    }

    @FunctionalInterface
    protected static interface AssertionMaker {
        public void make(Assertion assertion);
    }

    @Override
    public final Page makeAssertion(Assertion assertion) {
        Objects.requireNonNull(assertion, "assertion must not be null");

        AssertionMaker asserter = assertionMakers.get(assertion);

        if (asserter == null) {
            throw new UnsupportedOperationException(assertion + "is not supported by Page " + this);
        } else {
            asserter.make(assertion);
        }

        return this;
    }

    private final Map<Assertion, AssertionMaker> assertionMakers = new HashMap<>();

    protected final void addSupportedAssertions(Assertion assertion, AssertionMaker asserter) {
        Objects.requireNonNull(assertion, "assertion must not be null");
        Objects.requireNonNull(asserter, "assertion maker must not be null");

        assertionMakers.put(assertion, asserter);
    }

    @Override
    public Page assertPresented() {
        return makeAssertion(PagePresentedAssertion.INSTANCE);
    }

}
