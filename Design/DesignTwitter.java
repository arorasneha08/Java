import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class DesignTwitter {
    class Tweet implements Comparable<Tweet> {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        public int compareTo(Tweet other) {
            return this.time - other.time;
        }
    }

    class TweetNode {
        Tweet tweet;
        TweetNode next;

        TweetNode(Tweet tweet) {
            this.tweet = tweet;
            this.next = null;
        }
    }

    class TweetList {
        TweetNode head;

        TweetList() {
            head = null;
        }

        public void addFirst(Tweet tweet) {
            TweetNode node = new TweetNode(tweet);
            node.next = head;
            head = node;
        }

        public TweetNode getHead() {
            return head;
        }
    }

    class User {
        int userId;
        HashSet<Integer> followers;
        TweetList tweets;

        User(int userId) {
            this.userId = userId;
            followers = new HashSet<>();
            tweets = new TweetList();
        }

        public void addTweet(Tweet t) {
            tweets.addFirst(t);
        }

        public TweetNode getTweetHead() {
            return tweets.getHead();
        }

        public void follow(int userId) {
            followers.add(userId);
        }

        public void unfollow(int userId) {
            followers.remove(userId);
        }
    }

    class Twitter {
        int timeCounter;
        HashMap<Integer, User> userMap;

        public Twitter() {
            timeCounter = 0;
            userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            timeCounter++;
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            User user = userMap.get(userId);
            user.addTweet(new Tweet(tweetId, timeCounter));
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Tweet> pq = new PriorityQueue<>();
            if (!userMap.containsKey(userId)) {
                return list;
            }
            User user = userMap.get(userId);
            for (int followeeId : user.followers) {
                TweetNode curr = userMap.get(followeeId).getTweetHead();
                while (curr != null) {
                    pq.offer(curr.tweet);
                    if (pq.size() > 10) {
                        pq.poll();
                    }
                    curr = curr.next;
                }
            }
            TweetNode self = user.getTweetHead();
            while (self != null) {
                pq.offer(self.tweet);
                if (pq.size() > 10) {
                    pq.poll();
                }
                self = self.next;
            }
            while (!pq.isEmpty()) {
                list.add(0, pq.poll().tweetId);
            }
            return list;
        }

        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, new User(followerId));
            }
            if (!userMap.containsKey(followeeId)) {
                userMap.put(followeeId, new User(followeeId));
            }
            userMap.get(followerId).follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId) || (!userMap.containsKey(followeeId))) {
                return;
            }
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
