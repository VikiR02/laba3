package org.example;

import java.util.Arrays;

public class ArrayList_ {
    /**
     * Поле количество элементов
     */
    private int size = 0;
    /**
     * Поле массив строк
     */
    private int[] array = new int[10];

    /**
     * Функция получения значения поля
     * @return возвращает количество элементов в массиве
     */
    public int getSize() {
        return size;
    }

    /**
     * Функция получения значения элемента поля
     *  @param index - индекс массива
     * @return возвращает элемент массива по индексу
     */
    public int get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Функция добавления в массив
     * @param element -элемент массива
     */
    public void add(int element) {
            if (size == array.length) {
                int[] newArray = new int[(array.length * 3)/2+1];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
        array[size] = element;
        size++;
    }
    /**
     * Функция добавления элемента в массив  по индексу
     * @param element - элемент массива
     * @param index - индекс массива
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public void  add(int element,int index){
        increaseArray();
        if(index<0|| index>size){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array,index,array,index+1,size-index);
        array[index]=element;
        size++;
    }

    /**
     * Функция удаления элемента массива по индексу
     * @param index - индекс массива
     * @return true, если элемент был удален
     */
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    /**
     * Функция удаления элемента массива по индексу
     * @param element - индекс массива
     * @return true, если элемент был удален , иначе false
     */
    public boolean remove(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i]==element) {
               return removeAt(i);
            }
        }
        return false;

    }
    /**
     * Функция очистки массива
     */
    public void clear() {
        array = new int[10];
        size = 0;
    }
    /**
     * Функция копирования массива
     */
    private void increaseArray(){
        if (size>=array.length){
            array= Arrays.copyOf(array,(array.length*3)/2-1);}
    }

    /**
     * Функция проверки индекса
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
