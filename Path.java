import java.util.ArrayList;

public class Path {
	public Location start;
	public ArrayList<String> labels;

	public Path(Location location) {
		this.start = location;
		this.labels = new ArrayList<String>();
	}
}
