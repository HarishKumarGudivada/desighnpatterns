package com.nisum.factorydesignpattern;

public class FactoryPatternTest {

	public static void main(String[] args) {
		try {
			for (int i = 0; i <7; i++) {
				try{
					Demo d=FactoryPatternClass.createInstance();
					d.message();
					System.out.println(FactoryPatternClass.poolsize);
					System.out.println(FactoryPatternClass.usedpool);
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
					try {
						FactoryPatternClass.freeMemory();
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
