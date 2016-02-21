package edu.nyu.cs.nsh263.Assignment3NicholasHyland;

public class FastMaxStack<T> implements MaxStack<T>{
	
	private final Maximizer<T> maximizer;
	private LLNode<T> top = null;
	private LLNode<T> helper;
	
	public FastMaxStack(Maximizer<T> maximizer) {
		this.maximizer = maximizer;
	}

	public boolean isEmpty() {
		return top == null;
	}
// add if empty
	public void push(T info) {
		if (top == null) {
			LLNode<T> newNode = new LLNode<T>(info, null);
			top = newNode;
		}
		else
			top = top.pushValue(info);
		
		if (helper == null) {
			LLNode<T> newNode2 = new LLNode<T>(info, null);
			helper = newNode2;
			helper = helper.pushValue(info);
		}
		else if ((Integer)top.info >= (Integer)helper.info) {
			helper = helper.pushValue(info);
		}
		else
			return;
	}

	public T pop() {
		if (!top.isEmpty()) {
			T info = top.info;
			top = top.link;
			
			if (info == helper.info) {
				helper = helper.link;
			}
			return info;
		}
		else
			return null;
	}

	public T getMaxSoFar() {
		return helper.info;
	}
	
}