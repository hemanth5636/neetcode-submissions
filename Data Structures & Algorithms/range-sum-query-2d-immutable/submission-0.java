class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefix = new int[rows + 1][cols + 1];

        for (int i = 0; i < matrix.length; i++) {
            int pre = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                pre += matrix[i][j];
                int above = prefix[i][j + 1];
                prefix[i + 1][j + 1] = pre + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int bottomRight = prefix[row2][col2];
        int above = prefix[row1 - 1][col2];
        int topLeft = prefix[row1 - 1][col1 - 1];
        int left = prefix[row2][col1 - 1];
        return bottomRight - left - above + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */