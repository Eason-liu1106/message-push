package com;

import java.util.Scanner;

public class Main2 {
	// 解题关键：明确魔法机器1只能产生奇数，魔法机器2只能产生偶数即可。我们从后往前一步一步推回去即可。

	public static void main(String[] args) {
		System.out.println("请输入要获得的硬币数量：");
		Scanner scanner = new Scanner(System.in);
		int coincount = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		while (coincount >= 1) {
			// 偶数的情况
			if (coincount % 2 == 0) {
				coincount = (coincount - 2) / 2;
				sb.append("2");
				// 奇数的情况
			} else {
				coincount = (coincount - 1) / 2;
				sb.append("1");
			}
		}
		// 输出反转后的字符串
		System.out.println(sb.reverse());

	}
}