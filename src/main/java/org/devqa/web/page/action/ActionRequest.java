package org.devqa.web.page.action;

public interface ActionRequest<T extends Action> {
    public T getAction();
}
