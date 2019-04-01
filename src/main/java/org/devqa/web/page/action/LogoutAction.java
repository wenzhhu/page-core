package org.devqa.web.page.action;

public enum LogoutAction implements Action, ActionRequest {
    Logout;

    @Override
    public final Action getAction() {
        return this;
    }

    @Override
    public final String toString() {
        return "LogoutAction";
    }
}
