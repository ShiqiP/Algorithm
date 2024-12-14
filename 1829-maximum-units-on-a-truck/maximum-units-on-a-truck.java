class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // get maximum total number of units
        // the number of box should not exceed truckSize

        // calculate the total units in each type i
        // int[] totalArray = new int[boxTypes.length];
        // for(int[] a :boxTypes)
        // desc
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int sum = 0;
        int size = truckSize;
        for(int i=0; i<boxTypes.length;i++){
            if(boxTypes[i][0] <= size){
                size -= boxTypes[i][0];
                sum += boxTypes[i][1] * boxTypes[i][0];
            }else{
                sum += size * boxTypes[i][1];
                break;
            }
        }
        return sum;
    }

}