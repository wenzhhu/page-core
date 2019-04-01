package org.devqa.web.page.action;

public final class ActionRequestFactory {
    private ActionRequestFactory() {};

    public static EnterTextAction enterText(String target) {
        return new EnterTextAction(target);
    }

    public static EnterTextAction enterText(String target, String value) {
        return new EnterTextAction(target, value);
    }

}
