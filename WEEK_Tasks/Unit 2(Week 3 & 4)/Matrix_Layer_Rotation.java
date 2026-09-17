import java.util.*;

public class Solution {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        int[][] result = new int[rows][columns];

        for (int layer = 0; layer < Math.min(rows, columns) / 2; layer++) {
            List<Integer> values = new ArrayList<>();

            for (int i = layer; i < rows - layer; i++) {
                values.add(matrix.get(i).get(layer));
            }

            for (int j = layer + 1; j < columns - layer; j++) {
                values.add(matrix.get(rows - layer - 1).get(j));
            }

            for (int i = rows - layer - 2; i >= layer; i--) {
                values.add(matrix.get(i).get(columns - layer - 1));
            }

            for (int j = columns - layer - 2; j > layer; j--) {
                values.add(matrix.get(layer).get(j));
            }

            int shift = r % values.size();
            int index = 0;

            for (int i = layer; i < rows - layer; i++) {
                result[i][layer] = values.get((index++ + shift) % values.size());
            }

            for (int j = layer + 1; j < columns - layer; j++) {
                result[rows - layer - 1][j] =
                        values.get((index++ + shift) % values.size());
            }

            for (int i = rows - layer - 2; i >= layer; i--) {
                result[i][columns - layer - 1] =
                        values.get((index++ + shift) % values.size());
            }

            for (int j = columns - layer - 2; j > layer; j--) {
                result[layer][j] =
                        values.get((index++ + shift) % values.size());
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < columns; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }
}

/*
Input:
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Output:
3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
*/