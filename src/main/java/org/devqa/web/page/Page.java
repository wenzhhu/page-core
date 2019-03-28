package org.devqa.web.page;

import java.net.URL;

import org.devqa.web.page.action.Action;
import org.devqa.web.page.assertion.Assertion;

public interface Page {

    Page makeAssertion(Assertion assertion);

    Page performAction(Action action);

    void assertPresented();

    URL getUrl();

    Page open();

}
