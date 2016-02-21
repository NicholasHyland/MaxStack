package edu.nyu.cs.nsh263.Assignment3NicholasHyland;

public class SlowMaxStack<T> implements MaxStack<T>{

	private final Maximizer<T> maximizer;
	private LLNode<T> top;
	
	public SlowMaxStack(Maximizer<T> maximizer) {
		this.maximizer = maximizer;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(T info) {
		if (top == null) {
			LLNode<T> newNode = new LLNode<T>(info, null);
			top = newNode;
		}
		else
			top = top.pushValue(info);
	}

	public T pop() {
		T info = top.info;
		top = top.link;
		return info;
	}

	public T getMaxSoFar() {
		T currentMax = maximizer.getGlobalMin();
		
		for (LLNode<T> node = top; node != null; node = node.link) {
			currentMax = maximizer.getMax(currentMax, node.info);
		}
		
		return currentMax;
	}
	
}
