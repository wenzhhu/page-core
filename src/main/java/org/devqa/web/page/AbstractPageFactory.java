package org.devqa.web.page;

import java.util.HashMap;
import java.util.Map;

import org.devqa.web.page.Page;
import org.devqa.web.page.PageFactory;

public class AbstractPageFactory implements PageFactory {
    private final Map<String, Page> pages = new HashMap<>();

    @Override
    public Page getPage(String pageName) {

        Page page = pages.get(pageName);

        if (page != null) {
            return page;
        }

        // not found
        throw new IllegalArgumentException("unsupporetd page: " + pageName);
    }

    protected void addPage(String pageName, Page page) {
        pages.put(pageName, page);
    }

}
