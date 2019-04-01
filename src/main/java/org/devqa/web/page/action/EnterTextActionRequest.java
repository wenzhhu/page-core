package org.devqa.web.page.action;

public final class EnterTextActionRequest implements ActionRequest<EnterTextAction> {
    private final EnterTextAction action;
    private final String value;

    public EnterTextActionRequest(EnterTextAction action, String value) {
        super();
        this.action = action;
        this.value = value;
    }

    @Override
    public EnterTextAction getAction() {
        return action;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "EnterTextActionRequest [action=" + action + ", value=" + value + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((action == null) ? 0 : action.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnterTextActionRequest other = (EnterTextActionRequest) obj;
        if (action == null) {
            if (other.action != null)
                return false;
        } else if (!action.equals(other.action))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
