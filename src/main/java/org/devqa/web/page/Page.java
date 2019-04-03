package org.devqa.web.page;

import javax.annotation.Nonnull;

import org.devqa.web.page.action.Action;
import org.devqa.web.page.assertion.Assertion;

/**
 * Represents an HTML page.
 * <p>
 * With the page, an {@link org.devqa.web.page.action.Action} could be
 * performed. The action could be regular operations such as clicking a button,
 * entering some value to an input text, or could be any high level business
 * operations such as logout.
 * <p>
 * With the page, an {@link org.devqa.web.page.assertion.Assertion} could be
 * made. The assertion could be regular operations such as certain label is
 * being displayed, a button is being disabled, or could be any high level
 * business operations such as a user is be logined.
 */
public interface Page {

    /**
     * Make an assertion on this page. If the assertion is supported by the page, it will be made. Otherwise,
     * an {@link org.devqa.web.page.UnsupportedAssertionException} will be thrown. It is for the implementor of Page
     * to decide which assertions are supported for a certain page.
     * <p>
     * The type and number of potential assertions is infinite. Typically, it could be
     * <pre>
     * 1. some text is displayed
     * 2. a check box is selected
     * 3. a button is disabled
     * 4. the name of loggined user is XXX
     * </pre>
     *
     * @param assertion the assertion to be made
     * @return this page itself to chain the call
     *
     * @throws UnsupportedAssertionException if the assertion is not supported by this page
     * @throws NullPointerException if assertion is null
     */
    Page makeAssertion(@Nonnull Assertion assertion);

    /**
     * Perform an action on this page. If the action is supported by the page, it will be performed. Otherwise,
     * an {@link org.devqa.web.page.UnsupportedActionException} will be thrown. It is for the implementor of Page
     * to decide which actions are supported for a certain page.
     * <p>
     * The type and number of potential action is infinite. Typically, it could be
     * <pre>
     * 1. Click a button
     * 2. Select a check box
     * 3. Logout the current user
     * </pre>
     *
     * @param action the action to be performed
     * @return this page itself to chain the call
     *
     * @throws UnsupportedActionException if the action is not supported by this page
     * @throws NullPointerException if action is null
     */
     Page performAction(@Nonnull Action action);

    /**
     * Assert the page is presented. In other words, it's the current page that is being displayed and manipulated.
     * an {@link } will be thrown if the page is not presented.
     * <p>
     * Usually, a page tries to find some unique web elements to the page. If found, then the page is
     * being presented. Not otherwise.
     *
     * @return this page itself to chain the call
     */
    void assertPresented();

}
