package linklist;

public class LinkListIterator implements Iterator {
    private LinkList list;
    private Node current;
    public LinkListIterator(LinkList list) {
        this.list = list;
        this.current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        Integer e = current.elem;
        current = current.next;
        return e;
    }
}
