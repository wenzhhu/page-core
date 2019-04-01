package org.devqa.web.page;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.devqa.web.page.action.Action;

public final class CompositePage extends AbstractPage {
    private final String pageName;

    private CompositePage(String pageName,
            Map<Action, ActionPerformer> actionPerformers) {
        super();
        this.pageName = pageName;
        actionPerformers.forEach((a, p) -> addSupportedAction(a, p));
    }

    @Override
    public String toString() {
        return "CompositePage [pageName=" + pageName + ", supported actions="
                + getSupportedActions() + "]";
    }

    public static class Builder {
        private final String pageName;

        public Builder(String pageName) {
            this.pageName = pageName;
        }

        public Builder action(Action action, ActionPerformer actionPerformer) {
            Objects.requireNonNull(action, "action must not be null");
            Objects.requireNonNull(actionPerformer, "action performer must not be null");

            actionPerformers.put(action, actionPerformer);
            return this;
        }

        private final Map<Action, ActionPerformer> actionPerformers = new HashMap<>();

        public Page build() {
            return new CompositePage(pageName, actionPerformers);
        }

        public static Builder page(String pageName) {
            return new Builder(pageName);
        }
    }

    @Override
    public String getName() {
        return pageName;
    }

}
