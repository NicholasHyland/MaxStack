package edu.nyu.cs.nsh263.Assignment3NicholasHyland;

public interface MaxStack<T> {

	boolean isEmpty();
	
	void push(T info);
	
	T pop();
	
	T getMaxSoFar();
}
