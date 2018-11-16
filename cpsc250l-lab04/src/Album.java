public class Album implements Comparable<Album> {
	private String author;
	private String name;
	private int length;
	/**
	 * Creates an Album object consisting of an albumname, a bandname, and a
	 * length.
	 *
	 * @param _name
	 *            The album name
	 * @param _author
	 *            The band name
	 * @param _length
	 *            The length of the album (in seconds)
	 */
	public Album(String _name, String _author, int _length) {
		name = _name;
		author = _author;
		length = _length;
		
	}

	/**
	 * @param other
	 *            The Album which we compare to this one.
	 */
	@Override
	public int compareTo(Album other) {
		if(name != other.getName()){
			return name.compareTo(other.getName());
		}
		else if(author != other.getAuthor()){
			return author.compareTo(other.getAuthor());
		}
		else{
			return length - other.getLength();
		}
		
	}
	
	
	public String getName(){
		return name;
	}
	public String getAuthor(){
		return author;
	}
	public int getLength(){
		return length;
	}
}
