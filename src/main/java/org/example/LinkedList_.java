package org.example;

public class LinkedList_ {

    private Node first;
    private Node last;
    private int size = 0;
    /**
     * Возвращает элемент списка по заданному индексу.
     * @param index индекс элемента
     * @return значение элемента
     */
    public int get(int index) {
        return getNode(index).value;
    }
    /**
     *  Добавляет элемент по заданному индексу.
     * @param i значение элемента
     */
    public void add(int i) {
        if (size == 0) {
            first = new Node(null, i, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, i, null);
            secondLast.next = last;
        }
        size++;
    }
    /**
     * Добавляет элемент в конец списка..
     * @param i значение элемента
     * @param index индекс для добавления элемента
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public void add(int i, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(i);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, i, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }
    /**
     *  Удаляет элемент с заданным значением.
     * @param value значение элемента для удаления
     * @return @return true, если элемент был удален, иначе false
     */
    public boolean remove(int value) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value==value) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }
    /**
     *  Удаляет элемент по указанному индексу.
     * @param index индекс удаляемого элемента
     * @return true, если элемент был удален, иначе false
     */
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }
    /**
     *  Получение количества элементов в списке.
     * @return size количество элементов в списке.
     */
    public int size() {
        return size;
    }
    /**
     * Очистка списка.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
    /**
     *  Возвращает элемент по данному индексу.
     * @param index индекс возвращаемого элемента
     * @return узел списка по указанному индексу
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node {
        private Node previous;
        private int value;
        private Node next;

        public Node(Node previous, int value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
