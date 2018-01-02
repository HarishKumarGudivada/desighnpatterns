package com.nisum.desighnpatterns;

import java.io.Serializable;

public class SingleTonClass implements Cloneable,Serializable {


	private static final long serialVersionUID = 1L;
	public static SingleTonClass singletonObj=null;

	private SingleTonClass() throws Exception{
		//for reflection
		if(singletonObj!=null){
			throw new Exception("Object creation is not possible for singleton from outside");
		}
	}

	//for serialization
	protected Object readResolve() {
		return singletonObj;
	}
	
	public static SingleTonClass getInstance() throws Exception{
		//double check in multi threading schenario
		if(singletonObj==null){
			synchronized(SingleTonClass.class){
				if(singletonObj==null){
					singletonObj=new SingleTonClass();
				}
			}
		}
		return singletonObj;
	}
	
	
/*
	public static SingleTonClass getInstance() throws Exception{
		//double check in multi threading schenario
		if(singletonObj==null){
			synchronized(SingleTonClass.class){
					singletonObj=new SingleTonClass();
				}
		}
		return singletonObj;
	}
*/
	//for cloning scenario
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("cloning singleton object is not possible");
	}



}