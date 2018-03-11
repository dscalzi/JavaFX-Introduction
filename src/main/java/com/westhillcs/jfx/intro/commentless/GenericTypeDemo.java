package com.westhillcs.jfx.intro.commentless;

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
 * I STRONGLY RECOMMEND GOING OVER THE COMMENTED VERSION UNLESS YOU ARE A JAVA PRO
 * 
 * @author Daniel Scalzi
 *
 */
public class GenericTypeDemo {

	public static void main(String[] args){
		
		GenericTypeDemo temp = new GenericTypeDemo();
		
		ClassBox<Node> mb1 = temp.new ClassBox<Node>(Node.class);
		ClassBox<Node> mb2 = temp.new ClassBox<Node>(Button.class);
		ClassBox<Object> mb3 = temp.new ClassBox<Object>(/* ArrayList.class could go here */);
		
		
		mb1.open().ifPresent(e -> {
			System.out.println("Mystery Box 1 has a " + e.getSimpleName() + " class in it!");
		});
		
		mb2.open().ifPresent(e -> {
			System.out.println("Mystery Box 2 has a " + e.getSimpleName() + " class in it!");
		});
		
		mb3.open().ifPresent(e -> {
			System.out.println("Mystery Box 3 has a " + e.getSimpleName() + " class in it!");
		});
		
	}
	
	public class ClassBox <T>{
		
		private Class<? extends T> clazz;
		@SuppressWarnings("unused")
		private T testObject;
		
		public ClassBox(){
			this.clazz = null;
		}
		
		public ClassBox(Class<? extends T> clazz){
			this.clazz = clazz;
		}
		
		public Optional<Class<? extends T>> open(){
			if(clazz == null) return Optional.empty();
			return Optional.of(this.clazz);
		}
		
	}
	
}
