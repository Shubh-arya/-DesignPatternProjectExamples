package practice;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Test Abstract enum class
 * 
 * @author sarya
 *
 */
public class EnumTest {
	public static void main(String[] args) {
		System.out.println("enum value for low is:" + Level.LOW);
		System.out.println("enum lower case value ise:" + Level.LOW.asLowerCase());

		// Create enum set.
		EnumSet<Level> enumSet = EnumSet.of(Level.HIGH, Level.HIGH, Level.LOW, Level.HIGH, Level.MEDIUM);
		enumSet.forEach(value -> {
			System.out.println("enum value is:" + value);
		});

		// Enum values
		EnumMap<Level, String> enumMap = new EnumMap<Level, String>(Level.class);
		enumMap.put(Level.HIGH, "High level");
		enumMap.put(Level.MEDIUM, "Medium level");
		enumMap.put(Level.LOW, "Low level");
		String levelValue = enumMap.get(Level.HIGH);
		System.out.println("enum map value:" + levelValue);
	}
}

enum Level {
	HIGH {

		@Override
		public String asLowerCase() {
			return HIGH.toString().toLowerCase();
		}
	},
	MEDIUM {

		@Override
		public String asLowerCase() {
			return MEDIUM.toString().toLowerCase();
		}
	},
	LOW {

		@Override
		public String asLowerCase() {
			return LOW.toString().toLowerCase();
		}
	};

	public abstract String asLowerCase();
}