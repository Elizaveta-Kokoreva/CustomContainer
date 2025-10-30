package org.example;

/**
 * Контейнер для хранения произвольного количества объектов.
 * Использует динамический массив и увеличивает размер при необходимости.
 *
 * <p>Контейнер поддерживает операции добавления, извлечения, удаления и очистки элементов.</p>
 *
 * @author Елизавета Кокорева
 * @version 1.0
 */

public class Container {

    private Object[] data;
    private int size;

    /**
     * Создаёт новый контейнер с начальными n ячейками.
     */
    public Container() {
        int n = 10;
        data = new Object[n];
        size = 0;
    }

    /**
     * Увеличивает размер внутреннего массива в index раз.
     */
    public void grow() {
        int index = 2;
        Object[] newData = new Object[data.length * index];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;

    }

    /**
     * Добавляет элемент в контейнер.
     * @param element элемент, который нужно добавить
     */
    public void add(Object element) {
        if (size == data.length) {
            grow();
        }
        data[size++] = element;
    }


    /**
     * Возвращает элемент по указанному индексу.
     * @param index индекс элемента (начиная с 0)
     * @return элемент, находящийся по данному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы контейнера
     */
    public Object getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        return data[index];
    }

    /**
     * Устанавливает элемент по указанному индексу.
     * @param index индекс, в который вставляется элемент
     * @param element новый элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы контейнера
     */
    public void setElement(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        data[index] = element;
    }

    /**
     * Возвращает количество элементов в контейнере.
     * @return текущее количество элементов
     */
    public int getSize() {
        return size;
    }

    /**
     * Проверяет, пуст ли контейнер.
     * @return true, если контейнер не содержит элементов
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Удаляет элемент по индексу.
     * @param index индекс элемента, который нужно удалить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы контейнера
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;
    }

    /**
     * Удаляет элемент(ы) по значению.
     *
     * @param element элемент, который нужно удалить
     * @param removeAll если true — удаляются все совпадения, если false — только первое
     */
    public void remove(Object element, boolean removeAll) {
        if (size == 0) return;
        for (int i = 0; i < size; i++) {
            if (data[i] == null && element == null ||
                    (data[i] != null && data[i].equals(element))) {

                remove(i);

                if (!removeAll) {
                    return;
                }

                i--;
            }
        }
    }


    /**
     * Очищает контейнер, удаляя все элементы.
     */

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
}
