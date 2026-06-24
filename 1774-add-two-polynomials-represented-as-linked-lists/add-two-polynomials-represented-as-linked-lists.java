// /
//   Definition for polynomial singly-linked list.
//   class PolyNode {
//       int coefficient, power;
//       PolyNode next = null;

//       PolyNode() {}
//       PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
//       PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
//   }
//  /

class Solution {

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(0, 0);
        PolyNode node = dummy;

        while (poly1 != null && poly2 != null) {
            if (poly1.power == poly2.power) {
                int coefficient = poly1.coefficient + poly2.coefficient;
                if (coefficient != 0) {
                    node.next = new PolyNode(coefficient, poly1.power);
                    node = node.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            } else if (poly1.power > poly2.power) {
                node.next = new PolyNode(poly1.coefficient, poly1.power);
                node = node.next;
                poly1 = poly1.next;
            } else {
                node.next = new PolyNode(poly2.coefficient, poly2.power);
                node = node.next;
                poly2 = poly2.next;
            }
        }
        // poly1 = 2x(2) // poly2 = []
        if(poly1 != null) node.next = poly1;
        if(poly2 != null) node.next = poly2;

        // poly1 = 2X(2)  // 
        return dummy.next;
    }
}