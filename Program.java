import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String args[]) {
		Map<String, Location> locations = loadLocations();

		System.out.println("Locations Found=" + locations.size());
		
		PathFinder finder = new PathFinder(locations);
		
		finder.outputPaths();
	}

	public static Map<String, Location> loadLocations() {

		Map<String, Location> locations = new HashMap<String, Location>();

		Scanner input = null;

		try {
			input = new Scanner(new File("input.txt"));

			while (input.hasNext()) {
				String line = input.nextLine().replaceAll(" : ", " ");

				Location location = new Location(locations.size(), line.split(" "));

				locations.put(location.label, location);
			}
		} catch (FileNotFoundException e) {
			System.out.println("UNABLE TO LOAD INPUT FILE");
			e.printStackTrace();
			System.exit(-1);
		} finally {
			if (input != null) {
				input.close();
			}
		}

		return locations;
	}
}
