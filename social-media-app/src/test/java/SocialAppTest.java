import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SocialAppTest {

	static SocialApp controller;
	@BeforeClass
	public  static void setup() {	
		controller = new SocialApp();
		controller.createPost("U4", "P4", "FourthPost_User4");
		
	}
	
	@Test
	public void feedTest() {
		controller.createPost("U1", "P4", "FourthPost_User4");
		List<Post> feed = controller.getNewsFeed("U1");
		assertEquals(1, feed.size());
	}
	
	@Test
	public void followTest() {	
		controller.createPost("U2", "P2", "SecondPost_User2");
		controller.follow("U3", "U2");
		controller.createPost("U2", "P2", "ThirdPost_User2");
		List<Post> feed = controller.getNewsFeed("U2");
		assertEquals(2, feed.size());
	}
	
	@Test
	public void unfollowTest() {	
		controller.unfollow("U3", "U2");
		List<Post> feed = controller.getNewsFeed("U2");
		assertEquals(0, feed.size());
	}
	
	@Test
	public void limitTest() {
		for (int i = 0; i <= 30; i++) {
			controller.createPost("U5", String.valueOf(i), "Post_User5");
		}
		List<Post> feed = controller.getNewsFeed("U5");
		assertEquals(controller.limit, feed.size());
	}
	
	@Test
	public void latestFeedTest() {
		controller.setLimit(1);
		controller.createPost("U4", "123", "Post1");
		controller.createPost("U4", "456", "Post2");
		controller.createPost("U4", "789", "LatestPost");
		List<Post> feed = controller.getNewsFeed("U4");
		assertEquals("LatestPost", feed.get(0).getContent());
	}
}
