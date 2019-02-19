package com.itheima;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> {

    private Entry<K,V>[] table;
    private static final Integer CAPACITY = 8;
    private int size = 0;

    public MyHashMap() {
        this.table = new Entry[CAPACITY];
    }

    /**
     * 返回整个链表的元素
     * @return
     */
    public int size() {
        return size;
    }

    public Object get(K key) {
        int hashcode = key.hashCode();
        int index = hashcode % 8;

        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next){
            if (entry.k.equals(key)){
                return entry.v;
            }
        }
                return null;
    }

    /**
     * key相等的处理逻辑
     * @param key
     * @param value
     * @return
     */
    public Object put(K key, V value) {
        int hashcode = key.hashCode();
        int index = hashcode % 8;

        for (Entry<K, V> entry = table[index]; entry != null; entry = entry.next){
            if (entry.k.equals(key)){
                V oldValue = entry.v;
                entry.v = value;
                return oldValue;
            }
        }

            addEntry(key, value, index);
        return null;
    }

    private void addEntry(K key, V value, int index) {
        table[index] = new Entry(key, value, table[index]);
        size++;
    }

    class Entry<K, V> {
        private K k;
        private V v;
        private Entry<K, V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    /**
     *  测试
     * @param args
     */
    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap = new MyHashMap<>();

        for (int i=0;i<10;i++){
        myHashMap.put("张一"+i,"1"+i);
        }

        System.out.println(myHashMap.get("张一"));
//        System.out.println(myHashMap.size);
    }

}
