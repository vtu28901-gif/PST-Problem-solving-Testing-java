class Solution {
    static int[][] multiplyMatrix(int A[][], int B[][]) {
        int rowsA = A.length;
        int columnsA = A[0].length;
        int rowsB = B.length;
        int columnsB = B[0].length;

        if (columnsA != rowsB) {
            return new int[0][0];
        }

        int[][] result = new int[rowsA][columnsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }
}

/*
Input:
A = [[4,8],[0,2],[1,6]]
B = [[5,2],[9,4]]

Output:
[[92,40],[18,8],[59,26]]
*/