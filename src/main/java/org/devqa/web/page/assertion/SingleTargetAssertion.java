package org.devqa.web.page.assertion;


public abstract class SingleTargetAssertion implements Assertion {
    private final String target;

    protected SingleTargetAssertion(String target) {
        this.target = target;
    }


    @Override
    public final String toString() {
        return getClass() + " [target=" + target + "]";
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((target == null) ? 0 : target.hashCode());
        return result;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SingleTargetAssertion other = (SingleTargetAssertion) obj;
        if (target == null) {
            if (other.target != null)
                return false;
        } else if (!target.equals(other.target))
            return false;
        return true;
    }

    public String getTarget() {
        return target;
    }



}
