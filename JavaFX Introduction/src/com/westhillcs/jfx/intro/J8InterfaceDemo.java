package com.westhillcs.jfx.intro;

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

	/** Constant Example.
	 * 
	 *  Some constant value, demonstrating public (static/final) methods are permitted.
	 */
	final static int CONSTANT = 10;
	
	/** Example of a SINGLE abstract method.
	 * 
	 *  Abstract method that could be manipulated by a Lambda expression.
	 */
	public abstract void handle();
	
	/** Default Method Example.
	 * 
	 *  Default method, this means that the code provided is the default code should the user
	 *  not override it.
	 */
	public default int calculate(int x){
		return x*CONSTANT;
	}
	
	/** Static Method Example
	 * 
	 * 	This is a static method that can be used without there being an implementation
	 *  of this interface. It will check to see if the specific object provided is an instance of
	 *  a J8InterfaceDemo. One would call it by using <code>J8InterfaceDemo.isJ8InterfaceDemo(otherObject);</code>
	 * 
	 *  @param obj Object to check
	 *  @return True if an instance of J8InterfaceDemo, else false.
	 */
	public static boolean isJ8InterfaceDemo(Object obj){ 
		return obj instanceof J8InterfaceDemo; 
	}
	
}
