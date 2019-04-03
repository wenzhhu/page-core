package org.devqa.web.page;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.devqa.web.page.action.Action;

public class CompositePage extends AbstractPage {
    private final String name;
    private final Runnable presentionAsserter;

    protected CompositePage(String name, Runnable presentionAsserter,
            Map<Action, ActionPerformer<Action>> actionPerformers) {
        super();
        this.name = name;
        this.presentionAsserter = presentionAsserter;
        actionPerformers.forEach((a, p) -> addSupportedAction(a, p));
    }

    @Override
    public void assertPresented() {
        presentionAsserter.run();
    }

    @Override
    public String toString() {
        return "CompositePage [name=" + name + ", supported actions="
                + getSupportedActions() + "]";
    }

    public static class Builder {
        private final String name;
        private Runnable presentionAsserter = undefined("presention asserter");


        public Builder(String name) {
            this.name = name;
        }

        public <T extends Action> Builder action(T action, ActionPerformer<T> actionPerformer) {
            Objects.requireNonNull(action, "action must not be null");
            Objects.requireNonNull(actionPerformer, "action performer must not be null");

            actionPerformers.put((Action)action, (ActionPerformer)actionPerformer);
            return this;
        }

        private final Map<Action, ActionPerformer<Action>> actionPerformers = new HashMap<>();

        public Page build() {
            return new CompositePage(name, presentionAsserter, actionPerformers);
        }

        public static Builder page(String name) {
            return new Builder(name);
        }

        private Runnable undefined(String operation) {
            return () -> {
                String msg = "Operation: " + operation + " for Page: " + name;
                throw new UnsupportedOperationException(msg);
            };

        }

        public Builder presentionAsserter(Runnable presentionAsserter) {
            this.presentionAsserter = presentionAsserter;
            return this;
        }
    }

}
