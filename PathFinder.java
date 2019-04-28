import java.util.ArrayList;
import java.util.Map;

public class PathFinder {
	private Map<String, Location> locations;
	private ArrayList<Path> paths;

	public PathFinder(Map<String, Location> locs) {
		this.locations = locs;
		this.paths = new ArrayList<Path>();
	}

	public void outputPaths() {
		int count = this.locations.size();

		String[] labels = new String[count];

		this.locations.keySet().toArray(labels);

		for (int i = 0; i < labels.length; i++) {
			ArrayList<String> x = new ArrayList<String>();

			for (int j = 0; j < labels.length; j++) {
				if (i != j) {
					x.add(labels[j]);
				}
			}

			Path path = new Path(this.locations.get(labels[i]), this.locations, x);
			
			this.paths.add(path);
			
			path.run();
		}
	}
}
