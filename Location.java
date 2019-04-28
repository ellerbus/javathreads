import java.util.ArrayList;

public class Location {
	public int index;
	public String label;
	public ArrayList<Integer> routeTimes;

	public Location(int index, String data[]) {
		this.index = index;

		this.label = data[0];

		this.routeTimes = new ArrayList<Integer>();

		for (int i = 1; i < data.length; i++) {
			this.routeTimes.add(Integer.parseInt(data[i]));
		}
	}
}
