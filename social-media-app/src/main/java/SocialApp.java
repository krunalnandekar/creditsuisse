
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SocialApp {
	Set<Post> posts;
	Map<String, Set<String>> userFolloweeMap;
	int limit = 20;
	
	public SocialApp() {
		super();
		this.posts = new TreeSet<>();
		this.userFolloweeMap = new HashMap<>();
	}
	
	public void createPost(String userId, String postId, String content) {
		Post post = new Post(postId, userId, content);
		posts.add(post);

	}

	public List<Post> getNewsFeed(String userId) {
		Set<String> folowees = (userFolloweeMap.get(userId) != null) ? userFolloweeMap.get(userId) : new HashSet<>();
		folowees.add(userId);
		List<Post> feed = posts
				.stream()
				//.sorted(Comparator.reverseOrder())
				.limit(limit)
				.filter(post -> folowees.contains(post.getUserId()))
				.collect(Collectors.toList());
		return feed;
	}

	public void follow(String followerId, String followeeId) {
		Set<String> followers;
		if (userFolloweeMap.containsKey(followerId)) {
			followers = userFolloweeMap.get(followerId);
			followers.add(followeeId);
		} else {
			followers = new HashSet<String>();
			followers.add(followeeId);
			userFolloweeMap.put(followerId, followers);
		}
	}

	public void unfollow(String followerId, String followeeId) {
		Set<String> followers;
		if (userFolloweeMap.containsKey(followerId)) {
			followers = userFolloweeMap.get(followerId);
			followers.remove(followeeId);
		}
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public static void main(String[] args) {
//		SocialApp controller = new SocialApp();
//		controller.createPost("U1", "P1", "FirstPost");
//		controller.createPost("U2", "P1", "SecondPost");
//		controller.createPost("U3", "P1", "ThirdPost");
//		controller.createPost("U4", "P1", "FourthPost");
//		List<Post> feed = controller.getNewsFeed("U2");		
//		for (int i = 1; i <= 50; i++) {
//			controller.createPost("U5", String.valueOf(i), "Post_User5 "+i);
//		}
//		List<Post> feed = controller.getNewsFeed("U5");
//		for (Post post : feed) {
//			System.out.println(post);
//		}
	}

}
