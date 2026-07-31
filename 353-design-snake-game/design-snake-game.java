class SnakeGame {
    int width;
    int height;
    int[][] food;
    int foodIndex;
    int score;
    int[] position;
    Queue<int[]> body;
    Map<String, int[]> directionMap;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;

        this.position = new int[] { 0, 0 };
        this.body = new LinkedList<>();
        this.body.add(new int[] { 0, 0 });

        this.directionMap = new HashMap<>();
        this.directionMap.put("D", new int[] { 1, 0 });
        this.directionMap.put("U", new int[] { -1, 0 });
        this.directionMap.put("L", new int[] { 0, -1 });
        this.directionMap.put("R", new int[] { 0, 1 });
    }

    public int move(String direction) {
        /**
            calculate current position 
            1. check if game over
                - current position + direction out of bounds?
            2.  not food -> body.poll
                -> eatbody?
                
                eat food -> score++; foodIndex++;
            3. update body
                    return score
         */
        int[] direc = this.directionMap.get(direction);
        // System.out.println("----");
        // System.out.println("position: " + position[0] + "," + position[1]);
        position[0] += direc[0];
        position[1] += direc[1];
        // System.out.println("-----");

        if (outOfBound()) {
            return -1;
        }

        boolean ateFood = isFood();

        // Tail vacates this cell unless we're growing this turn.
        if (!ateFood) {
            body.poll();
        } else {
            score++;
            foodIndex++;
        }

        if (eatBody()) {
            return -1;
        }

        body.offer(new int[] { position[0], position[1] });

        return score;

    }

    public boolean isFood() {
        // System.out.println(food[foodIndex][0] + "," + food[foodIndex][1]);
        return foodIndex < food.length && position[0] == food[foodIndex][0] && position[1] == food[foodIndex][1];
    }

    public boolean outOfBound() {
        return (position[0] < 0 || position[0] >= this.height || position[1] < 0 || position[1] >= this.width);
    }

    public boolean eatBody() {
        for (int[] b : body) {
            if (position[0] == b[0] && position[1] == b[1])
                return true;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */