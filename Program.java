import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program {

	public static void main(String args[]) {
		Map<String, Location> locations = loadLocations();

		System.out.println("Locations Found=" + locations.size());

		String[] labels = new String[locations.size()];

		locations.keySet().toArray(labels);

		ExecutorService es = Executors.newCachedThreadPool();

		ArrayList<PathFinder> finders = new ArrayList<PathFinder>();

		for (int i = 1; i < labels.length; i++) {
			PathFinder finder = new PathFinder(labels[0], labels[1], locations);

			finders.add(finder);

			es.execute(finder);
		}

		es.shutdown();

		try {
			boolean finished = es.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//	find "BEST" from PathFinders
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
