function pathSum(root: TreeNode | null, targetSum: number): number {
    let count = 0;
    const prefixSums: Map<number, number> = new Map();
    prefixSums.set(0, 1);

    function dfs(node: TreeNode | null, curSum: number) {
        if(!node) return;

        curSum += node.val;
        if(prefixSums.has(curSum - targetSum)) {
            count += prefixSums.get(curSum - targetSum)
        }

        prefixSums.set(curSum, (prefixSums.get(curSum) ?? 0) + 1);

        dfs(node.left, curSum)
        dfs(node.right, curSum)

        prefixSums.set(curSum, (prefixSums.get(curSum) ?? 1) - 1);
    };

    dfs(root, 0)

    return count
};