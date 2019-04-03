package org.devqa.web.page.action;

import org.devqa.web.page.action.singletarget.Agree;
import org.devqa.web.page.action.singletarget.ChooseFromAction;
import org.devqa.web.page.action.singletarget.Click;
import org.devqa.web.page.action.singletarget.EnterTextAction;

public final class ActionFactory {
    private ActionFactory() {};

    public static EnterTextAction enterText(String target) {
        return new EnterTextAction(target);
    }

    public static EnterTextAction enterText(String target, String value) {
        return new EnterTextAction(target, value);
    }

    public static ChooseFromAction chooseFrom(String target) {
        return new ChooseFromAction(target);
    }

    public static ChooseFromAction chooseFrom(String target, String value) {
        return new ChooseFromAction(target, value);
    }

    public static Click click(String target) {
        return new Click(target);
    }

    public static Agree agree(String target) {
        return new Agree(target);
    }

    public static LogoutAction logout() {
        return LogoutAction.Logout;
    }

    public static Menu menu(String topMenu, String... subMenus) {
        return new Menu(topMenu, subMenus);
    }

}
