package org.devqa.web.page.action;

public class Click extends Action {
    private final String target;

    private Click(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Click [target=" + target + "]";
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
        Click other = (Click) obj;
        if (target == null) {
            if (other.target != null)
                return false;
        } else if (!target.equals(other.target))
            return false;
        return true;
    }

}
