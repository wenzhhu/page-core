package org.devqa.web.page.action;

import java.util.Arrays;

import javax.annotation.Nonnull;

public class ClickMenu extends Action {
    private final String[] targets;

    private ClickMenu(@Nonnull String... targets) {
        if (targets.length == 0) {
            throw new IllegalArgumentException("there must be at least one menu to click");
        }
        this.targets = targets;
    }

    @Override
    public String toString() {
        String menus = targets[0];
        for (int i=1; i<targets.length; i++) {
            menus += (" -> " + targets[i]);
        }

        return "ClickMenu [targets=" + menus + "]";
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
        ClickMenu other = (ClickMenu) obj;
        if (!Arrays.equals(targets, other.targets))
            return false;
        return true;
    }



}
