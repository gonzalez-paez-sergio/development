package arrays.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;

public class Fibonacci {

	private HashMap<Integer, BigInteger> map;

	public Fibonacci() {
		this.setMap(new HashMap<Integer, BigInteger>());
	}

	public BigInteger calculate(int number) {
		for (int j = map.size(); j <= number; j++) {
			if (0 == j)
				map.put(0, BigInteger.valueOf(0));
			else if (1 == j)
				map.put(1, BigInteger.valueOf(1));
			else {
				BigInteger b = map.get(j - 2);
				// System.out.println(j + "-" + b);

				b = b.add(map.get(j - 1));
				// System.out.println(j + "-" + b);
				map.put(j, b);
				// System.out.println(map);
			}
		}
		return map.get(number);
	}

	public static Long calculateNoArray(int number) {
		if (number == 0) {
			return 0l;
		}

		if (number == 1) {
			return 1l;
		}

		int p = 1, pp = 0, sum = 0;
		for (int i = 0; i < number; i++) {
			pp = p;
			p = sum;
			sum += pp;
			;
		}

		System.out.println(number + "-" + sum);
		return (long) sum;
	}

	// 0 , 1 ,1,2,3,5,8
	public HashMap<Integer, BigInteger> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, BigInteger> map) {
		this.map = map;
	}
}
