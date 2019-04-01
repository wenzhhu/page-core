package org.devqa.web.page.action;

public class EnterTextAction extends SingleTargetAction{
    private final String value;

    public EnterTextAction(String target) {
        this(target, null);
    }

    public EnterTextAction(String target, String value) {
        super(target);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
