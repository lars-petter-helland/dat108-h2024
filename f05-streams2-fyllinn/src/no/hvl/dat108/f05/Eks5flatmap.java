package no.hvl.dat108.f05;

import java.util.List;

/* Idé https://www.geeksforgeeks.org/stream-flatmap-java-examples/
 * , lett modifisert.  
 */
public class Eks5flatmap {
	
	public static void main(String[] args) throws Exception {
		
        List<Integer> primtall = List.of(5, 7, 11,13);
        List<Integer> oddetall = List.of(1, 3, 5);
        List<Integer> partall  = List.of(2, 4, 6, 8);
  
        List<List<Integer>> listeAvLister = List.of(primtall, oddetall, partall);
  
        System.out.println("\nlisteAvLister : ");
        System.out.println(listeAvLister);
          
        List<Integer> flatetListe  = listeAvLister.stream()
        		.flatMap(sublist -> sublist.stream()) // Stream<List<Integer>> ---> Stream<Integer>
//        		.sorted()
        		.toList();
        
        System.out.println("\nlisteAvLister etter 'flattening' (og sortering) : ");
        System.out.println(flatetListe);
	}
}





