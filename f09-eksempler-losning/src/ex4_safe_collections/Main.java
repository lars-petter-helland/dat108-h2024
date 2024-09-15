package ex4_safe_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Sjekk ut:
 * https://www.baeldung.com/java-synchronized-collections
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> list = new ArrayList<>();
		Thread thread1 = new Thread(() -> list.addAll(List.of(1, 2, 3, 4, 5)));
		Thread thread2 = new Thread(() -> list.addAll(List.of(6, 7, 8, 9)));
		Thread thread5 = new Thread(() -> list.add(10));

		List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
		Thread thread3 = new Thread(() -> syncList.addAll(List.of(1, 2, 3, 4, 5)));
		Thread thread4 = new Thread(() -> syncList.addAll(List.of(6, 7, 8, 9)));
		Thread thread6 = new Thread(() -> syncList.add(10));

		thread1.start(); thread2.start(); thread3.start(); 
		thread4.start(); thread5.start(); thread6.start();
		
		thread1.join();	thread2.join();	thread3.join();
		thread4.join(); thread5.join(); thread6.join();
		
		Collections.sort(list);
		System.out.println("Vanlig ArrayList  : " + list);
		// Kan en ArrayList deles og brukes av flere tråder samtidig?
		
		Collections.sort(syncList);
		System.out.println("Wrapped ArrayList : " + syncList);
		// Kan en Collections.synchronizedCollection(new ArrayList<>()) 
		// deles og brukes av flere tråder samtidig?

	}

}
