import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Path {
	public Location start;
	public ArrayList<String> labels;
	public ArrayList<String[]> combinations;

	public Path(Location start, Map<String, Location> locations, ArrayList<String> labels) {
		this.start = start;
		this.labels = labels;
		this.combinations = new ArrayList<String[]>();
	}

	public void run() {
		this.createCombinations(this.labels.size(), this.labels);

		for (String[] combos : this.combinations) {
			System.out.print(start.label + " : ");
			System.out.println(String.join("->", combos));
		}
	}

	public void createCombinations(int n, ArrayList<String> elements) {

		if (n == 1) {
			String[] combos = this.getStringArray(elements);
			this.combinations.add(combos);
		} else {
			for (int i = 0; i < n - 1; i++) {
				createCombinations(n - 1, elements);
				if (n % 2 == 0) {
					this.swap(elements, i, n - 1);
				} else {
					this.swap(elements, 0, n - 1);
				}
			}
			createCombinations(n - 1, elements);
		}
	}

	public String[] getStringArray(ArrayList<String> arr) {

		// declaration and initialise String Array
		String str[] = new String[arr.size()];

		// ArrayList to Array Conversion
		for (int j = 0; j < arr.size(); j++) {

			// Assign each value to String array
			str[j] = arr.get(j);
		}

		return str;
	}

	private void swap(ArrayList<String> input, int a, int b) {
		String tmp = input.get(a);
		input.set(a, input.get(b));
		input.set(b, tmp);
	}
}
