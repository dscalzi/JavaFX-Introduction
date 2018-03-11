package com.westhillcs.jfx.intro.commentless;

/**
 * This is an example of a Java 8 Functional Interface. An interface must be functional to work
 * with a Java 8 Lambda expression. These types of interfaces have exactly ONE abstract method.
 * The interface is permitted to have an unlimited number of static and default methods.
 * 
 * See more information on the <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html">Oracle API</a>
 * 
 * @author Daniel Scalzi
 * @category JavaFX 8 Demo
 *
 */
@FunctionalInterface
public interface J8InterfaceDemo {

	final static int CONSTANT = 10;
	
	public abstract void handle();
	
	public default int calculate(int x){
		return x*CONSTANT;
	}
	
	public static boolean isJ8InterfaceDemo(Object obj){ 
		return obj instanceof J8InterfaceDemo; 
	}
	
}
