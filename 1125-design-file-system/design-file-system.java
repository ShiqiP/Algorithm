class FileSystem {
    Map<String, Integer> map;

    // Map<String, Pair<Integer, String[]>> map;
    public FileSystem() {
        this.map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        // map path value kv

        // false
        /**
        
        map.contains(path)
        !map.contains(parentpath)
        split the path with "/"
        /leetcode  /leetcode/problems
        
        "/leetcode/problems/set"  - [leetcode, problems,set]
        n - 1 level exist ??
        /leetcode
        /leetcode/problems
         */
        // already exists
        if (this.map.containsKey(path) || path.equals("/") || path.isBlank()) {
            return false;
        }

        String[] strarr = path.split("/");

        if (strarr.length < 3) {
            this.map.put(path, value);
            return true;
        } else {
            // check parent path
            int delimIndex = path.lastIndexOf("/");
            String parent = path.substring(0, delimIndex);
            if(!this.map.containsKey(parent)) return false;
            // StringBuilder builder = new StringBuilder();
            // for (int i = 1; i < strarr.length - 1; i++) {
            //     builder.append("/");
            //     builder.append(strarr[i]);

            //     String parent = builder.toString();
            //     System.out.println(parent);
            //     if (!this.map.containsKey(parent)) {
            //         return false;
            //     }
            // }
            this.map.put(path, value);
            return true;
        }
    }

    public int get(String path) {
        return this.map.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */