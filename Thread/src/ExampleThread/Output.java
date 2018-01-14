/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleThread;

/**
 *
 * @author ASUS
 */
class Output extends Thread {
	private String toSay;
        private Integer i=0;
	public Output(String st) {
		toSay = st;
	}
	public void run() {
		try {
			for(i=0;i<10;i++) {
				System.out.println(toSay + i);
                                //i++;
				sleep(10);
                                
			}
		} catch(InterruptedException e) {
			System.out.println(e);
		}
	}
}

