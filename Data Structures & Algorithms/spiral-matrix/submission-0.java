class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, imax = matrix.length, jmax = matrix[0].length;
        List<Integer> ls = new ArrayList<>();
        while(i < imax && j < jmax) {
            for(int k = j; k < jmax; k++) ls.add(matrix[i][k]);
            i++;
            for(int k = i; k < imax; k++) ls.add(matrix[k][jmax - 1]);
            jmax--;
            if (!(j < jmax && i < imax)) {
                break;
            }
            for(int k = jmax - 1; k >= j; k--) ls.add(matrix[imax - 1][k]);
            imax--;
            for(int k = imax - 1; k >= i; k--) ls.add(matrix[k][j]);
            j++;
        }
        return ls;
    }
}
