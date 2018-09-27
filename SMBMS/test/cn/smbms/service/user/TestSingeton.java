package cn.smbms.service.user;

import cn.smbms.tools.Singleton;

public class TestSingeton {
	public static void main(String[] args) {
		System.out.println("Singleton.test()----->" + Singleton.test());
		System.out.println("Singleton.getInstance()----->"
				+ Singleton.getInstance());
	}
}
