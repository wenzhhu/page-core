package org.devqa.web.page.action;

public class Enter extends Action {
    private final String target;
    private final String value;

    private Enter(String target, String value) {
        this.target = target;
        this.value = value;
    }

    private Enter(String target) {
        this(target, null);
    }

    @Override
    public String toString() {
        if (value == null) {
            return "Select [target=" + target + "]";
        } else {
            return "ChooseFrom [target=" + target + ", value=" + value + "]";
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((target == null) ? 0 : target.hashCode());
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
        Enter other = (Enter) obj;
        if (target == null) {
            if (other.target != null)
                return false;
        } else if (!target.equals(other.target))
            return false;
        return true;
    }

}
