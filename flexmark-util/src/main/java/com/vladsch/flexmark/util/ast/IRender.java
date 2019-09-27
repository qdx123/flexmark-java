package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.data.DataHolder;

/**
 * Render interface for rendering implementation for RenderingTestCase
 */
public interface IRender {
    public void render(Node node, Appendable output);

    /**
     * Render the tree of nodes to HTML.
     *
     * @param node the root node
     *
     * @return the rendered HTML
     */
    default String render(Node node) {
        StringBuilder sb = new StringBuilder();
        render(node, sb);
        return sb.toString();
    }

    IRender withOptions(DataHolder options);

    /**
     * Get Options for parsing
     *
     * @return DataHolder for options
     */
    DataHolder getOptions();
}
