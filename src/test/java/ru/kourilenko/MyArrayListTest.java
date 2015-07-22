package ru.kourilenko;

import org.junit.Assert;
import org.junit.Test;


public class MyArrayListTest {
    @Test
    public void testSize(){
        MyArrayList myArrayList = new MyArrayList();
        Assert.assertEquals("Криво считаем размер!", 0, myArrayList.size());
    }

    @Test
    public void addObjTest(){
        MyArrayList myArrayList = new MyArrayList();
        Object obj = new Object();
        myArrayList.add(obj);
        Assert.assertEquals(1, myArrayList.size());

    }

    @Test
    public void addManyObjTest(){
        MyArrayList myArrayList = new MyArrayList();
         for (int i = 0; i <1000; i++){
             myArrayList.add(new Object());
         }
        Assert.assertEquals(1000, myArrayList.size());
    }

    @Test(expected = RuntimeException.class)
    public void addNullTest(){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddBigPosition(){
        MyArrayList myArrayList = new MyArrayList();
        Object obj= new Object();
        myArrayList.add(2, obj);
    }

    @Test
    public void testSize2(){
        MyArrayList myArrayList = new MyArrayList();
        Object obj = new Object();
        myArrayList.add(obj);
        myArrayList.remove();
        Assert.assertEquals("Криво считаем размер", 0, myArrayList.size());
    }

    @Test
    public void removeWithPositionTest(){
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i <100; i++){
            myArrayList.add(new Object());
        }
        myArrayList.remove(4);
        Assert.assertEquals(99, myArrayList.size());
    }

    @Test
    public void clearTest(){
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i <100; i++){
            myArrayList.add(new Object());
        }
        Assert.assertFalse(myArrayList.isEmpty());
        myArrayList.clear();
        Assert.assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void equalsTest(){
        MyArrayList arr1 = new MyArrayList();
        MyArrayList arr2 = new MyArrayList();
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
        MyArrayList arr1 = new MyArrayList();
        MyArrayList arr2 = new MyArrayList();
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
        MyArrayList arr1 = new MyArrayList();
        MyArrayList arr2 = new MyArrayList();
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
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(7);
        myArrayList.add(1992);
        myArrayList.add(1,"июля");

        Assert.assertEquals("Что-то пошло не так!", "июля", myArrayList.get(1));
        Assert.assertEquals(1992, myArrayList.get(2));
    }

}
