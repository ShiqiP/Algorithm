class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // we can just greedily choose the asteroid with smallest mass at each step;
        // cause every time planet collides an asteroid, the mass is increasing. 
        // if the smallest remaining asteroid has a mass greater than our planet.
        // there is no other order of asteroid allow us to continue
        Arrays.sort(asteroids);
        long sum=mass;
        for(int asteroid : asteroids){
            if(sum < asteroid)
                return false;
            else
                sum += asteroid;
        }
        return true;
    }
}