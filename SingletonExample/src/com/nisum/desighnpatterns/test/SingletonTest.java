package com.nisum.desighnpatterns.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.nisum.desighnpatterns.SingleTonClass;

public class SingletonTest implements Runnable{

	public static void main(String[] args) {
		SingletonTest obj=new SingletonTest();
		//test multithreading
		//obj.multiThreading(obj);
		//test reflection
		//obj.reflectionTest();
		//serialization Test
		obj.serializationTest();
		//clonetest
		//obj.cloneTest();
	}

	public void multiThreading(SingletonTest obj){
		Thread thobj=new Thread(obj,"thread1");
		thobj.start();
		
		Thread thobj1=new Thread(obj,"thread2");
		thobj1.start();
	}


	public void reflectionTest(){
		try {
			SingleTonClass obj=SingleTonClass.getInstance();
			System.out.println(obj.hashCode());
			Class className=SingleTonClass.class;
			Constructor<SingleTonClass> con= className.getDeclaredConstructors()[0];	
			con.setAccessible(true);
			SingleTonClass obj2=con.newInstance();
			System.out.println(obj2.hashCode());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void serializationTest(){
		try {

			SingleTonClass instance1=SingleTonClass.getInstance();
            ObjectOutput out  = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();
         
            ObjectInput in  = new ObjectInputStream(new FileInputStream("file.text"));
            SingleTonClass instance2 = (SingleTonClass) in.readObject();
            in.close();
         
            System.out.println("instance1 hashCode:- "+ instance1.hashCode());
            System.out.println("instance2 hashCode:- "+ instance2.hashCode());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void cloneTest(){
		try {
			SingleTonClass obj=SingleTonClass.getInstance();
			obj.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			SingleTonClass obj=SingleTonClass.getInstance();
			System.out.println("Object---"+obj.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
