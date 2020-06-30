package mainpro;

import java.util.ArrayList;
import java.util.Stack;

public class Combination {
	private ArrayList<Sub_dater> arr = new ArrayList<>(); // 기준 배열
	private Stack<Sub_dater> st; // 조합을 저장할 스택
	ArrayList<ArrayList<Sub_dater>> list = new ArrayList<>();
	ArrayList<Sub_dater> sublist;

	public Combination(ArrayList<Sub_dater> arr) {
		this.arr = arr; // 배열을 받아 객체에 저장한다.
		st = new Stack<Sub_dater>(); // 스택에 메모리를 할당한다.
	}

	public void showStack() {
		// 스택에 있는 값들을 출력한다.
		sublist = new ArrayList<>();
		for (int i = 0; i < st.size(); i++) {
			Sub_dater ir = new Sub_dater();
			ir = st.get(i);

			sublist.add(st.get(i));

		}
		list.add(sublist);

	}

	public void doCombination(int n, int r, int index) {
		// n : 전체 개수
		// r : 뽑을 개수

		if (r == 0) {
			showStack();
			return;
		} else if (n == r) {
			for (int i = 0; i < n; i++)
				st.add(arr.get(index + i));
			showStack(); // 스택을 보여준다.
			for (int i = 0; i < n; i++)
				st.pop();
		} else {

			// index를 포함하는 경우
			st.add(arr.get(index));
			doCombination(n - 1, r - 1, index + 1);

			// index를 포함하지 않는 경우
			st.pop();
			doCombination(n - 1, r, index + 1);

		}
	}
}
