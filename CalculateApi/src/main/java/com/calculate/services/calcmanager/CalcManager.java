package com.calculate.services.calcmanager;

import java.util.LinkedList;
import java.util.Stack;

import com.calculate.services.model.CalcEntity;
import com.calculate.services.model.RezultClass;

public class CalcManager {


	private boolean isOperator(char c) {

		return c == '+' || c == '-' || c == '*' || c == '/';

	}

	private int priority(char oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		}

		else if (oper == '+' || oper == '-') {
			return 0;
		}

		else {
			return -1;
		}
	}

	private void letGo(LinkedList<Integer> st, char oper) {
		int someOne = st.removeLast();
		int someTwo = st.removeLast();

		switch (oper) {
		case '+':
			st.add(someTwo + someOne);
			break;
		case '-':
			st.add(someTwo - someOne);
			break;
		case '*':
			st.add(someTwo * someOne);
			break;
		case '/':
			st.add(someTwo / someOne);
			break;
		default:
			System.out.println("Oops");
		}
	}

	private String eval(String s) {
		LinkedList<Integer> someInts = new LinkedList<>();
		LinkedList<Character> someOpers = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				someOpers.add('(');
			}

			else if (c == ')') {

				while (someOpers.getLast() != '(') {
					letGo(someInts, someOpers.removeLast());
				}
				someOpers.removeLast();
			}

			else if (isOperator(c)) {
				while (!someOpers.isEmpty()
						&& priority(someOpers.getLast()) >= priority(c)) {
					letGo(someInts, someOpers.removeLast());
				}

				someOpers.add(c);
			}

			else {
				String operand = "";
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					operand += s.charAt(i++);
				}
				--i;
				someInts.add(Integer.parseInt(operand));
			}
		}

		while (!someOpers.isEmpty()) {
			letGo(someInts, someOpers.removeLast());
		}
		return Integer.toString(someInts.get(0));

	}
	
	public Object getCalc(CalcEntity entity) {
		RezultClass rez = new RezultClass();
		rez.setResult(eval(entity.getExpressionsForCalculate()));
		return rez;

	}

}
