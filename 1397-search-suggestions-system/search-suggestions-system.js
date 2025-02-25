/**
 * @param {string[]} products
 * @param {string} searchWord
 * @return {string[][]}
 */

class TrieNode {
    constructor() {
        this.match = [];
        this.children = new Map();
    }
}
var suggestedProducts = function (products, searchWord) {
    let arr = products.sort();
    // form a trie
    let root = new TrieNode();
    for (let i in products) {
        const product = products[i];
        let cur = root;
        for (const c of product) {
            if (!cur.children.has(c)) {
                cur.children.set(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.match.push(i);
        }

    }
    // 
    let ans = [];
    let node = root;
    for (let c of searchWord) {
        let list = [];
        if (node.children.has(c)) {
            node = node.children.get(c);
            for (let i = 0; i < Math.min(3, node.match.length); i++) {
                list.push(arr[node.match[i]]);
            }
        } else {
            // if current c doesn't find any match, clear the children
            // in case next c match the key in children
            node.children = new Map();
        }
        ans.push(list);
    }
    return ans;
};