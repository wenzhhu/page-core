package org.devqa.web.page.action;

import java.util.Arrays;

import org.devqa.web.page.action.Action;

public abstract class MultipleTargetAction implements Action {
    private final String[] targets;

    protected MultipleTargetAction(String firstTarget, String... remainTargets) {
        this.targets = new String[remainTargets.length + 1];

        targets[0] = firstTarget;
        System.arraycopy(remainTargets, 0, targets, 1, remainTargets.length);
    }

    @Override
    public String toString() {
        return getClass() + " [targets=" + Arrays.toString(targets) + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(targets);
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
        MultipleTargetAction other = (MultipleTargetAction) obj;
        if (!Arrays.equals(targets, other.targets))
            return false;
        return true;
    }

    protected String[] getTargets() {
        return targets.clone();
    }
}
