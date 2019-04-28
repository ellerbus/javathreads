import java.util.Map;

public class PathWay {
	public Map<String, Location> locations;
	public String[] path;
	public int timeOnPath;

	public PathWay(Map<String, Location> locations, String[] path) {
		this.locations = locations;
		this.path = path;
		this.timeOnPath = this.findTimeOnPath();
	}

	private int findTimeOnPath() {
		int time = 0;

		for (int i = 0; i < this.path.length - 1; i++) {
			String beg = this.path[i];
			String end = this.path[i + 1];

			Location b = this.locations.get(beg);
			Location e = this.locations.get(end);
			
			time +=  b.routeTimes.get(e.index).intValue();
		}

		return time;
	}
}
