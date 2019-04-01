package org.devqa.web.page.action;

import org.devqa.web.page.AbstractPage.ActionPerformer;

public class Test {
    public static <T extends Action> void addPerformer(T action, ActionPerformer<T> performer) {

    }

    public static void test() {
        addPerformer(new Click("OK"), (r) -> {r.getTarget();});

        addPerformer(new EnterTextAction("name"), (r) -> {r.getValue();});
    }
}
