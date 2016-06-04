package com.westhillcs.jfx.intro;

import java.util.Optional;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * This class contains several advanced topics and is optional to read through.
 * The primary demonstration is Generic Types, however Class<>, .class, Optional<>, and 
 * inner classes are used.
 * 
 * Just look at how the generic type is used to see that you can use it in any class you
 * make.
 * 
 * If you don't understand something, Google is your ally.
 * 
 * @author Daniel Scalzi
 *
 */
public class GenericTypeDemo {

	public static void main(String[] args){
		/*
		 * Temporary GenericTypeDemo object that will be required
		 * to create new ClassBoxes.
		 */
		GenericTypeDemo temp = new GenericTypeDemo();
		
		/*
		 * The ClassBoxes take a generic type and for the constructor can
		 * take a class that extends that generic type. If you do not give
		 * it a class parameter, then the ClassBox will be empty.
		 * 
		 * Since we are making a class inside of our current class, we need to
		 * say temp.new on the right side of the statement.
		 */
		//Two full ClassBoxes
		ClassBox<Node> mb1 = temp.new ClassBox<Node>(Node.class);
		ClassBox<Node> mb2 = temp.new ClassBox<Node>(Button.class);
		ClassBox<Object> mb3 = temp.new ClassBox<Object>(/* ArrayList.class could go here */);
		
		/*
		 * The following lines of code will open the ClassBoxes we have created.
		 * Since open() returns an Optional, we can use the ifPresent(Consumer) method
		 * to create a lambda and run some code. If there is no value present in the ClassBox
		 * the lambda will not run since the Optional will be empty.
		 */
		mb1.open().ifPresent(e -> {
			System.out.println("Mystery Box 1 has a " + e.getSimpleName() + " class in it!");
		});
		
		mb2.open().ifPresent(e -> {
			System.out.println("Mystery Box 2 has a " + e.getSimpleName() + " class in it!");
		});
		
		//mb3 is empty, therefore this lambda will not run!
		mb3.open().ifPresent(e -> {
			System.out.println("Mystery Box 3 has a " + e.getSimpleName() + " class in it!");
		});
		
	}
	
	/**
	 * The ClassBox class takes a generic type T which will be type of object that can be
	 * placed into this box. There is no real functional use for this class, however it is
	 * to demonstrate how you can create a class with a generic type. If desired, multiple
	 * generic types can be added by <T, K, J, etc>. You can put any name you want for this,
	 * but by convention capital letters are used.
	 * 
	 * @author Daniel Scalzi
	 *
	 * @param <T> An instance of the class that could be put into this ClassBox.
	 */
	public class ClassBox <T>{
		
		/**
		 * The Class object that will be stored in this box. With this setup, we can take
		 * any T or subclass of T.
		 * 
		 * <? extends T> in English means any class that is a T or extends a T.
		 */
		private Class<? extends T> clazz;
		
		/**
		 * Quick example to show that you can make variables of your generic type.
		 */
		@SuppressWarnings("unused")
		private T testObject;
		
		/**
		 * Empty constructor, this will set the value of
		 * clazz to null
		 */
		public ClassBox(){
			this.clazz = null;
		}
		
		/**
		 * This constructor allows the user to add a class that is
		 * either a T or a subclass of T.
		 * 
		 * <? extends T> in English means any class that is a T or extends a T.
		 * 
		 * @param clazz A class type that is T or subclass of T. The actual parameter would be T.class
		 */
		public ClassBox(Class<? extends T> clazz){
			this.clazz = clazz;
		}
		
		/**
		 * This method opens up our box. We return an optional because this box could either
		 * contain a class or be empty. If clazz is null, that means we have no class in this box
		 * and we will return an empty Optional. Otherwise, we will return clazz packed into an optional.
		 * 
		 * @return
		 */
		public Optional<Class<? extends T>> open(){
			if(clazz == null) return Optional.empty();
			return Optional.of(this.clazz);
		}
		
	}
	
}
