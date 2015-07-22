package ru.kourilenko;

import org.junit.Assert;
import org.junit.Test;


public class MyLinkedListTest {
    @Test
    public void testSize(){
        MyLinkedList myLinkedList = new MyLinkedList();
        Assert.assertEquals("Криво считаем размер!", 0, myLinkedList.size());
    }

    @Test
    public void addObjTest(){
       MyLinkedList myLinkedList = new MyLinkedList();
        Object obj = new Object();
        myLinkedList.add(obj);
        Assert.assertEquals(1, myLinkedList.size());

    }

    @Test
    public void addManyObjTest(){
        MyLinkedList myLinkedList = new MyLinkedList();
         for (int i = 0; i <1000; i++){
             myLinkedList.add(new Object());
         }
        Assert.assertEquals(1000, myLinkedList.size());
    }

    @Test(expected = RuntimeException.class)
    public void addNullTest(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testAddBigPosition(){
        MyLinkedList myLinkedList = new MyLinkedList();
        Object obj= new Object();
        myLinkedList.add(2, obj);
    }

    @Test
    public void testSize2(){
        MyLinkedList myLinkedList = new MyLinkedList();
        Object obj = new Object();
        myLinkedList.add(obj);
        myLinkedList.remove();
        Assert.assertEquals("Криво считаем размер", 0, myLinkedList.size());
    }

    @Test
    public void removeWithPositionTest(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i <100; i++){
            myLinkedList.add(new Object());
        }
        myLinkedList.remove(4);
        Assert.assertEquals(99, myLinkedList.size());
    }

    @Test
    public void clearTest(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i <100; i++){
            myLinkedList.add(new Object());
        }
        Assert.assertFalse(myLinkedList.isEmpty());
        myLinkedList.clear();
        Assert.assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void equalsTest(){
        MyLinkedList arr1 = new MyLinkedList();
        MyLinkedList arr2 = new MyLinkedList();
        for (int i = 0; i <100; i++){
            arr1.add("Hi" + i);
        }
        for (int i = 0; i <100; i++){
            arr2.add("Hi" + i);
        }
        Assert.assertTrue(arr1.equals(arr2));
    }


    @Test
    public void notEqualsTest1(){
        MyLinkedList arr1 = new MyLinkedList();
        MyLinkedList arr2 = new MyLinkedList();
        for (int i = 0; i <100; i++){
            arr1.add("Hi" + i);
        }
        for (int i = 0; i <80; i++){
            arr2.add("Hi" + i);
        }
        Assert.assertFalse(arr1.equals(arr2));
    }


    @Test
    public void notEqualsTest2(){
        MyLinkedList arr1 = new MyLinkedList();
        MyLinkedList arr2 = new MyLinkedList();
        for (int i = 0; i <100; i++){
            arr1.add("Hi" + i);
        }
        for (int i = 0; i <100; i++){
            arr2.add("Hi");
        }
        Assert.assertFalse(arr1.equals(arr2));
    }

    @Test
    public void getTest(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(7);
        myLinkedList.add(1992);
        myLinkedList.add(1, "июля");

        Assert.assertEquals("Что-то пошло не так!", "июля", myLinkedList.get(1));
        Assert.assertEquals(1992, myLinkedList.get(2));
    }

}
