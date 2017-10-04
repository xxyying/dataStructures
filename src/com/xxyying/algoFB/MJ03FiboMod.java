package com.xxyying.algoFB;

public class MJ03FiboMod {
	public int getPisanoPeriod(int n, int m) {
        int a = 0, b = 1, c = a+b;
        int i = 0;
        for (; i < n; i++) {
                c = (a+b) % m;
                a = b;
                b = c;
                if (a == 0 && b == 1) return i+1;
        }
        return i;
	}

	public int getFibonacciModN(int n, int m) {
        int remainder = n % getPisanoPeriod(n, m);
        
        int first = 0, second = 1;
        int res = remainder;
        for (int i = 0; i < remainder-1; i++) {
                res = (first + second) % m;
                first = second;
                second = res;
        }
        return res % m;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
