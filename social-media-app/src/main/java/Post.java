import java.sql.Timestamp;
import java.util.Date;

public class Post implements Comparable<Post>{
	String postId;
	String userId;
	String content;
	Timestamp timestamp;
	
	public Post(String postId, String userId, String content) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.content = content;
		timestamp = new Timestamp(System.nanoTime());
	}
	@Override
	public String toString() {
		return content;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String contents) {
		this.content = contents;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public int compareTo(Post o) {
		int i =  timestamp.compareTo(o.getTimestamp());
		if(i!=0)
			return -i;
		return timestamp.compareTo(o.getTimestamp());
	}
}
