package org.devqa.web.page;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.devqa.web.page.action.Action;
import org.devqa.web.page.assertion.Assertion;
import org.devqa.web.page.assertion.PagePresentedAssertion;

public abstract class AbstractPage implements Page {
    @FunctionalInterface
    public static interface ActionPerformer<T extends Action> {
        public void perform(T action);
    }

    @Override
    public final Page performAction(Action action) {
        Objects.requireNonNull(action, "action must not be null");

        ActionPerformer<Action> actionPerformer = actionPerformers.get(action);

        if (actionPerformer == null) {
            throw new UnsupportedActionException(action + "is not supported by Page " + this);
        } else {
            actionPerformer.perform(action);
        }

        return this;
    }

    private final Map<Action, ActionPerformer<Action>> actionPerformers= new HashMap<>();

    protected final <T extends Action> void addSupportedAction(T action, ActionPerformer<T> performer) {
        Objects.requireNonNull(action, "action must not be null");
        Objects.requireNonNull(performer, "action performer must not be null");

        actionPerformers.put((Action)action, (ActionPerformer<Action>)performer);
    }

    protected final Set<Action> getSupportedActions() {
        return actionPerformers.keySet();
    }

    @FunctionalInterface
    protected static interface AssertionMaker<T extends Assertion> {
        public void make(T assertion);
    }

    @Override
    public final Page makeAssertion(Assertion assertion) {
        Objects.requireNonNull(assertion, "assertion must not be null");

        AssertionMaker<Assertion> asserter = assertionMakers.get(assertion);

        if (asserter == null) {
            throw new UnsupportedOperationException(assertion + "is not supported by Page " + this);
        } else {
            asserter.make(assertion);
        }

        return this;
    }

    private final Map<Assertion, AssertionMaker<Assertion>> assertionMakers = new HashMap<>();

    protected final <T extends Assertion> void addSupportedAssertions(T assertion, AssertionMaker<T> asserter) {
        Objects.requireNonNull(assertion, "assertion must not be null");
        Objects.requireNonNull(asserter, "assertion maker must not be null");

        assertionMakers.put(assertion, (AssertionMaker<Assertion>) asserter);
    }

    @Override
    public void assertPresented() {
        makeAssertion(PagePresentedAssertion.INSTANCE);
    }

}
