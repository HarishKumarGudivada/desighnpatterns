package com.nisum.factorydesignpattern;

public class FactoryPatternClass {

	public static final int poolsize=5;
	public static int usedpool=0;
	
	
	public static Demo createInstance() throws Exception{
		if(poolsize>=usedpool){
			usedpool++;
			return new Demo();
		}else{
			throw new Exception("Pool is full");
		}
	}
	
	public static void freeMemory() throws Throwable{
		usedpool--;
		System.gc();
	}

}
