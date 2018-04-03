package enu;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EnumMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Color> list = new ArrayList<Color>();
        list.add(Color.BLUE);
        list.add(Color.YELLOW);
        list.add(Color.RED);
        list.add(Color.GREEN);
        list.add(Color.BLUE);
        list.add(Color.BLUE);
        list.add(Color.RED);
        list.add(Color.YELLOW);
        list.add(Color.YELLOW);
        list.add(Color.GREEN);
        
        Map<Color, Integer> enumMap = new EnumMap<Color, Integer>(Color.class);
        for (Color color : list) {
        	Integer count = enumMap.get(color);
        	if (count != null) {
        		count = count +1;
        	} else {
        		count = 1;
        	}
        	
        	enumMap.put(color, count);
        }
        
        System.out.println(enumMap.toString());
	}

}
