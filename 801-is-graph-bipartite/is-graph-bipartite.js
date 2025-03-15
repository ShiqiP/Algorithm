/**
 * @param {number[][]} graph
 * @return {boolean}
 */
var isBipartite = function (graph) {
    let stack = [];
    let set = new Array(graph.length).fill(-1);
    for (let i = 0; i < graph.length; i++) {
        if (set[i] !== -1) continue;
        stack.push(i);
        set[i] = 0;
        while (stack.length !== 0) {
            const node = stack.pop();
            for (let adjacent of graph[node]) {
                if (set[adjacent] === -1) {
                    set[adjacent] = (set[node] + 1) % 2; // -1 -> 0  1->0  0->1
                    stack.push(adjacent);
                } else if (set[adjacent] === set[node]) {
                    return false;
                }
            }
        }
    }
    return true;
};