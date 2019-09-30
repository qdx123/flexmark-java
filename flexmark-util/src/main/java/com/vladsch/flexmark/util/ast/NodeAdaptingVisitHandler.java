package com.vladsch.flexmark.util.ast;

/**
 * intended to be extended with specific handler function. see {@link VisitHandler}
 *
 * @param <N> subclass of {@link Node}
 * @param <A> subclass of {@link NodeAdaptingVisitor}
 * @deprecated use {@link com.vladsch.flexmark.util.visitor.AstHandler} almost identical except
 * class must have the same type as adapter type parameter. ie. Class&lt;N&gt; instead of Class&lt;? extends N&gt;
 */
@Deprecated
public abstract class NodeAdaptingVisitHandler<N extends Node, A extends NodeAdaptingVisitor<N>> {
    protected final Class<? extends N> myClass;
    protected final A myAdapter;

    public NodeAdaptingVisitHandler(Class<? extends N> aClass, A adapter) {
        myClass = aClass;
        myAdapter = adapter;
    }

    public Class<? extends N> getNodeType() {
        return myClass;
    }

    public A getNodeAdapter() {
        return myAdapter;
    }

//    // implement whatever function interface is desired for the adapter
//    @Override
//    public void render(Node node, NodeRendererContext context, HtmlWriter html) {
//        //noinspection unchecked
//        myAdapter.render((N) node, context, html);
//    }
//
//    @Override
//    public void render(Node node, NodeFormatterContext context, MarkdownWriter markdown) {
//        //noinspection unchecked
//        myAdapter.render((N) node, context, markdown);
//    }
//    @Override
//    public void render(Node node, DocxRendererContext context) {
//        //noinspection unchecked
//        myAdapter.render((N) node, context);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeAdaptingVisitHandler<?, ?> other = (NodeAdaptingVisitHandler<?, ?>) o;

        if (myClass != other.myClass) return false;
        return myAdapter == other.myAdapter;
    }

    @Override
    public int hashCode() {
        int result = myClass.hashCode();
        result = 31 * result + myAdapter.hashCode();
        return result;
    }
}
