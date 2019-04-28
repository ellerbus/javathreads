import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Path {
	public Location start;
	public ArrayList<String> labels;
	public Map<String, Location> locations;
	public ArrayList<PathWay> combinations;

	public Path(Location start, Map<String, Location> locations, ArrayList<String> labels) {
		this.start = start;
		this.locations = locations;
		this.labels = labels;
		this.combinations = new ArrayList<PathWay>();
	}

	public void run() {
		this.createPathWays(this.labels.size(), this.labels);

		for (PathWay pathWay : this.combinations) {
			System.out.print(start.label + " : ");
			System.out.print(String.join("->", pathWay.path));
			System.out.println(" = " + pathWay.timeOnPath);
		}
	}

	public void createPathWays(int n, ArrayList<String> elements) {

		if (n == 1) {
			String[] path = this.getStringArray(elements);
			PathWay pw = new PathWay(this.locations, path);
			this.combinations.add(pw);
		} else {
			for (int i = 0; i < n - 1; i++) {
				createPathWays(n - 1, elements);
				if (n % 2 == 0) {
					this.swap(elements, i, n - 1);
				} else {
					this.swap(elements, 0, n - 1);
				}
			}
			createPathWays(n - 1, elements);
		}
	}

	public String[] getStringArray(ArrayList<String> arr) {

		String str[] = new String[arr.size() + 2];

		str[0] = this.start.label;
		str[str.length - 1] = this.start.label;

		// ArrayList to Array Conversion
		for (int j = 0; j < arr.size(); j++) {

			// Assign each value to String array
			str[j + 1] = arr.get(j);
		}

		return str;
	}

	private void swap(ArrayList<String> input, int a, int b) {
		String tmp = input.get(a);
		input.set(a, input.get(b));
		input.set(b, tmp);
	}
}
