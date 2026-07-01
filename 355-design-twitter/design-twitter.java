class Twitter {
    // * Map followerId -> List<Integer> followees
    // * follow list.add(new follower)
    // * unfollow list.remove(follower)
    // * tweet repository List<Tweet>
    // * count the tweets that meets the constrains. 
    class Tweet {
        int userId;
        int tweetId;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    private Map<Integer, List<Integer>> followMap;
    private List<Tweet> tweets;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.tweets.add(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        int count = 0;
        int index = this.tweets.size() - 1;
        List<Integer> feeds = new ArrayList<>();

        // tweets  1 2 3 4 5
        // feeds   3 4 5
        while (count < 10 && index >= 0) {
            Tweet tweet = this.tweets.get(index);
            List<Integer> followeeList = followMap.get(userId);

            if (tweet.userId == userId || (followeeList != null && followeeList.contains(tweet.userId))) {
                feeds.add(tweet.tweetId);
                count++;
            }

            index--;
        }

        return feeds;
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> followeeList = followMap.getOrDefault(followerId, new ArrayList<>());
        followeeList.add(followeeId);
        followMap.put(followerId, followeeList);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followeeList = followMap.getOrDefault(followerId, new ArrayList<>());
        followeeList.removeIf((followee) -> followee == followeeId);
        followMap.put(followerId, followeeList);
    }
}

/**
 * Yourreitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */