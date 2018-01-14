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
public class Program {
	public static void main(String [] args) {
		Output thr1 = new Output("hello");
		Output thr2 = new Output("there");
		thr1.start();
		thr2.start();
	}
}

