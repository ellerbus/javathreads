import java.util.ArrayList;
import java.util.Map;

public class PathFinder implements Runnable {
	private Map<String, Location> locations;
	private ArrayList<Path> paths;
	private Thread me;
	private String start;
	private String next;

	public PathFinder(String start, String next, Map<String, Location> locs) {
		this.start = start;
		this.next = next;
		this.locations = locs;
		this.paths = new ArrayList<Path>();
	}

	public void start() {
		System.out.println("Thread started");
		if (me == null) {
			me = new Thread(this, next);
			me.start();
		}
	}

	@Override
	public void run() {
		int count = this.locations.size();

		String[] labels = new String[count];

		this.locations.keySet().toArray(labels);

		ArrayList<String> x = new ArrayList<String>();

		for (int j = 1; j < labels.length; j++) {
			x.add(labels[j]);
		}

		Path path = new Path(this.locations.get(labels[0]), this.locations, x);

		this.paths.add(path);

		path.run();
	}
}
