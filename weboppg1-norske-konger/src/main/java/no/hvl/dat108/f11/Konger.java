package no.hvl.dat108.f11;

import java.util.ArrayList;
import java.util.List;

public class Konger {
	
	private static final String IMG_ROOT =
			"https://upload.wikimedia.org/wikipedia/commons/thumb/";
	
	public static List<Konge> norske;
	
	static {
		norske = new ArrayList<>();
		
//		norske.add( ... mange konger før Christian I ...
		
		norske.add(new Konge("Christian I",		1426, 1448, 1482,
				IMG_ROOT + "c/c8/Medalj_%C3%B6ver_Kristian_I%2C_Nordisk_familjebok.png/100px-Medalj_%C3%B6ver_Kristian_I%2C_Nordisk_familjebok.png"));
		norske.add(new Konge("Hans",			1455, 1482, 1513,
				IMG_ROOT + "5/52/John_II_of_Sweden_sculpture_c_1530_%28photo_2009%29.jpg/100px-John_II_of_Sweden_sculpture_c_1530_%28photo_2009%29.jpg"));
		norske.add(new Konge("Christian II",	1481, 1513, 1523,
				IMG_ROOT + "0/09/ChristianIIb.jpg/100px-ChristianIIb.jpg"));
		norske.add(new Konge("Frederik I",		1471, 1523, 1535,
				IMG_ROOT + "2/2c/Frederik1dk.jpg/100px-Frederik1dk.jpg"));
		norske.add(new Konge("Christian III",	1503, 1535, 1559,
				IMG_ROOT + "b/b8/Christian_III_of_Denmark.jpg/100px-Christian_III_of_Denmark.jpg"));
		norske.add(new Konge("Frederik II",		1534, 1559,	1588,
				IMG_ROOT + "7/7a/Frederik_2.jpg/100px-Frederik_2.jpg"));
//		norske.add(new Konge("Christian IV" 	1577 	1588 	1648
//		norske.add(new Konge("Frederik III"		1609 	1648 	1670
//		norske.add(new Konge("Christian V"		1646 	1670 	1699
//		norske.add(new Konge("Frederik IV"		1671 	1699 	1730
//		norske.add(new Konge("Christian VI"		1699 	1730	1746
//		norske.add(new Konge("Frederik V"		1723 	1746 	1766
//		norske.add(new Konge("Christian VII"	1749 	1766 	1808
//		norske.add(new Konge("Frederik VI"		1768	1808	1814
//		norske.add(new Konge("Christian Frederik" 1786	1814	1814
//		norske.add(new Konge("Karl II"			1748 	1814	1818
//		norske.add(new Konge("Karl III Johan"	1763	1818	1844
//		norske.add(new Konge("Oscar I"			1799 	1844	1859
//		norske.add(new Konge("Karl IV"			1826 	1859	1872
//		norske.add(new Konge("Oscar II" 		1829	1872	1905
//		norske.add(new Konge("Haakon VII"		1872	1905	1957
//		norske.add(new Konge("Olav V"			1903	1957	1991
//		norske.add(new Konge("Harald V"			1937	1991	2021
	}

}
