package org.devqa.web.page.action.singletarget;

public class ChooseFromAction extends SingleTargetAction{
    private final String value;

    public ChooseFromAction(String target) {
        this(target, null);
    }

    public ChooseFromAction(String target, String value) {
        super(target);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
