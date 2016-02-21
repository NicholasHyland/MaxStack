package edu.nyu.cs.nsh263.Assignment3NicholasHyland;

public class LLHomeworkFunctions {


	public static void main(String[] args) {
		
		//CODE TO TEST FASTMAXSTACK AND SLOWMAXSTACK
		/*IntMax intMaximizer = new IntMax();
		
		FastMaxStack<Integer> fast = new FastMaxStack<Integer>(intMaximizer);
		
		fast.push(1);
		fast.push(34);
		fast.push(36);
		fast.push(65);
		fast.push(55);
		fast.push(71);
		
		System.out.println("Fast: Max so far is " + fast.getMaxSoFar());
		fast.pop();
		System.out.println("Fast: Max so far is " + fast.getMaxSoFar());
		fast.pop();

		IntMax intMaximizer2 = new IntMax();
		SlowMaxStack<Integer> slow = new SlowMaxStack<Integer>(intMaximizer2);
		
		slow.push(1);
		slow.push(34);
		slow.push(36);
		slow.push(65);
		slow.push(55);
		slow.push(71);
		
		System.out.println("Slow: Max so far is " + slow.getMaxSoFar());
		slow.pop();
		System.out.println("Slow: Max so far is " + slow.getMaxSoFar());
		*/
		
		//CODE TO TEST WHETHER OR NOT TWO LISTS EQUAL AND IF IT IS RECURSIVE
		LLNode<Integer> test5 = new LLNode<>(5, null);
		LLNode<Integer> test4 = new LLNode<>(4, test5);
		LLNode<Integer> test3 = new LLNode<>(3, test4);
		LLNode<Integer> test2 = new LLNode<>(2, test3);
		LLNode<Integer> test1 = new LLNode<>(1, test2);
		
		//make test 1 recursive:
		//test5.link = test1;
		//System.out.print("Max So Far: ");
		//test1.getMaxSoFar();
		
		//LLNode<Integer> test11 = new LLNode<>(6, null);
		LLNode<Integer> test10 = new LLNode<>(5, null);
		LLNode<Integer> test9 = new LLNode<>(4, test10);
		LLNode<Integer> test8 = new LLNode<>(3, test9);
		LLNode<Integer> test7 = new LLNode<>(2, test8);
		LLNode<Integer> test6 = new LLNode<>(1, test7);
		
		//make test6 recursive:
		//test10.link = test1;
		//test5.link = test6;
		
		if (equalLists(test1, test6)) 
			System.out.println("They equal!");
		else
			System.out.println("They don't equal!");
		
		System.out.println();
		if (terminates(test6))
			System.out.println("It terminates!");
		else
			System.out.println("It's recursive!");
	}
	
	static public <T> boolean equalLists(LLNode<T> list1, LLNode<T> list2) {
		
		boolean empty = false;
		
		while (!empty) {
			
			if (!list1.isEmpty() && !list2.isEmpty()) {
				if (list1.info.equals(list2.info)) {
					list1 = list1.link;
					list2 = list2.link;
					continue;
				}
				else
					return false;
			}
			else if (list1.isEmpty() && list2.isEmpty()) {
				empty = true;
			}
			else if (list1.isEmpty() && !list2.isEmpty()) {
				return false;
			}
			else
				return false;
		}
		if (list1.info.equals(list2.info)) 
			return true;
		else
			return false;
}

	static public <T> boolean terminates(LLNode<T> list) {
		
		LLNode<T> start1 = list;
		LLNode<T> start2 = list;
		
		while (start1 != null && start1.link != null && start2 != null && start2.link != null && start2.link.link != null) {
			
				if (start1.link == start2.link.link) {
					return false;
				}
				else {
					start1 = start1.link;
					start2 = start2.link.link;
					continue;
				}
			}
		return true;
	}
}
