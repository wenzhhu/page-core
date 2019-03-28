package org.devqa.web.page.action;

public class ChooseFrom extends Action {
    private final String target;
    private final String choosedItem;

    private ChooseFrom(String target, String choosedItem) {
        this.target = target;
        this.choosedItem = choosedItem;
    }

    private ChooseFrom(String target) {
        this(target, null);
    }

    @Override
    public String toString() {
        if (choosedItem == null) {
            return "Select [target=" + target + "]";
        } else {
            return "ChooseFrom [target=" + target + ", choosedItem=" + choosedItem + "]";
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
        ChooseFrom other = (ChooseFrom) obj;
        if (target == null) {
            if (other.target != null)
                return false;
        } else if (!target.equals(other.target))
            return false;
        return true;
    }

}
