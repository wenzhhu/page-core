package org.devqa.web.page.action;

public class Menu extends MultipleTargetAction {
    public Menu(String topMenu, String... subMenus) {
        super(topMenu, subMenus);
    }

    public String[] getMenus() {
        return getTargets();
    }

    public String getTopMenu() {
        return getTargets()[0];
    }

}
