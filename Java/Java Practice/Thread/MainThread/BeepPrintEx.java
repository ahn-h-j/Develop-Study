package ThreadEx;

import java.awt.Toolkit;

//단일 스레드 : 메인 스레드만 존재
public class BeepPrintEx {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.print("땡 ");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}