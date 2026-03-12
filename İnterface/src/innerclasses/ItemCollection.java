package innerclasses;

import java.util.Iterator;

/**
 * Member (non-static) inner class: ItemIterator dış sınıfın verisine bağlı.
 */
public class ItemCollection {

    private final String[] items;

    public ItemCollection(String[] items) {
        this.items = items;
    }

    public Iterator<String> iterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public String next() {
            return items[index++];
        }
    }
}
