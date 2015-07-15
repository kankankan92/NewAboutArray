package ru.kourilenko;

import org.junit.Assert;
import org.junit.Test;


public class MyArrayTest {
    @Test
    public void testSize(){
        MyArray myArray = new MyArray();
        Assert.assertEquals("Криво считаем размер!", 0, myArray.size());
    }

    @Test
    public void addObjTest(){
        MyArray myArray = new MyArray();
        Object obj = new Object();
        myArray.add(obj);
        Assert.assertEquals(1, myArray.size());

    }

    @Test
    public void addManyObjTest(){
        MyArray myArray = new MyArray();
         for (int i = 0; i <1000; i++){
             myArray.add(new Object());
         }
        Assert.assertEquals(1000, myArray.size());
    }

    @Test(expected = RuntimeException.class)
    public void addNullTest(){
        MyArray myArray = new MyArray();
        myArray.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test1(){
        MyArray myArray = new MyArray();
        Object obj= new Object();
        myArray.add(2, obj);
    }

    @Test
    public void testSize2(){
        MyArray myArray = new MyArray();
        Object obj = new Object();
        myArray.add(obj);
        myArray.remove();
        Assert.assertEquals("Криво считаем размер", 0, myArray.size());
    }

    @Test
    public void removeWithPositionTest(){
        MyArray myArray = new MyArray();
        for (int i = 0; i <100; i++){
            myArray.add(new Object());
        }
        myArray.remove(4);
        Assert.assertEquals(99, myArray.size());
    }

    @Test
    public void clearTest(){
        MyArray myArray = new MyArray();
        for (int i = 0; i <100; i++){
            myArray.add(new Object());
        }
        Assert.assertFalse(myArray.isEmpty());
        myArray.clear();
        Assert.assertTrue(myArray.isEmpty());
    }

    @Test
    public void equalsTest(){
        MyArray arr1 = new MyArray();
        MyArray arr2 = new MyArray();
        for (int i = 0; i <100; i++){
            arr1.add("Hi" + i);
        }
        for (int i = 0; i <100; i++){
            arr2.add("Hi" + i);
        }
        Assert.assertTrue(arr1.equals(arr2));
    }

    @Test
    public void getTest(){
        MyArray myArray= new MyArray();
        myArray.add(7);
        myArray.add(1992);
        myArray.add(1,"июля");

        Assert.assertEquals("Что-то пошло не так!", "июля", myArray.get(1));
        Assert.assertEquals(1992, myArray.get(2));
    }

}
