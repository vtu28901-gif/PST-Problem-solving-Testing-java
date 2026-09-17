import java.io.*;
import java.util.*;

public class Solution {
    static class MaxHeap {
        int[] heap;
        int[] position;
        int[] index;
        int size;

        MaxHeap(int n) {
            heap = new int[n + 5];
            position = new int[n + 5];
            index = new int[n + 5];
            Arrays.fill(position, -1);
            Arrays.fill(index, -1);
            size = 0;
        }

        void add(int id, int value) {
            if (position[id] != -1) {
                return;
            }

            size++;
            heap[size] = value;
            index[size] = id;
            position[id] = size;
            up(size);
        }

        void remove(int id) {
            int pos = position[id];

            if (pos == -1) {
                return;
            }

            position[id] = -1;

            heap[pos] = heap[size];
            index[pos] = index[size];
            size--;

            if (pos <= size) {
                position[index[pos]] = pos;
                up(pos);
                down(pos);
            }
        }

        int max() {
            if (size == 0) {
                return Integer.MIN_VALUE;
            }

            return heap[1];
        }

        void up(int pos) {
            while (pos > 1) {
                int parent = pos / 2;

                if (heap[parent] >= heap[pos]) {
                    break;
                }

                swap(parent, pos);
                pos = parent;
            }
        }

        void down(int pos) {
            while (true) {
                int left = pos * 2;
                int right = left + 1;
                int largest = pos;

                if (left <= size && heap[left] > heap[largest]) {
                    largest = left;
                }

                if (right <= size && heap[right] > heap[largest]) {
                    largest = right;
                }

                if (largest == pos) {
                    break;
                }

                swap(pos, largest);
                pos = largest;
            }
        }

        void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;

            int tempIndex = index[a];
            index[a] = index[b];
            index[b] = tempIndex;

            position[index[a]] = a;
            position[index[b]] = b;
        }
    }

    static int[] manacher(char[] s) {
        int n = s.length;
        int[] radius = new int[2 * n];

        for (int i = 0, j = 0; i < 2 * n; i += Math.max(1, radius[i]), j = Math.max(j - Math.max(1, radius[i]), 0)) {
            while (i - j >= 0 &&
                   i + j + 1 < 2 * n &&
                   s[(i - j) / 2] == s[(i + j + 1) / 2]) {
                j++;
            }

            radius[i] = j;

            int k = 1;

            while (k < j &&
                   i - k >= 0 &&
                   radius[i - k] != radius[i] - k) {
                radius[i + k] = Math.min(radius[i - k], radius[i] - k);
                k++;
            }
        }

        return radius;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String str = br.readLine().trim();

        char[] s = new char[2 * n];

        for (int i = 0; i < n; i++) {
            s[i] = str.charAt(i);
            s[i + n] = str.charAt(i);
        }

        int[] radius = manacher(s);

        long[] events = new long[16 * n];
        int eventCount = 0;

        for (int i = 0; i < 4 * n; i += 2) {
            radius[i] = Math.min(radius[i], n - ((n & 1) ^ 1));

            events[eventCount++] = ((long) (i / 2) << 32) | i;
            events[eventCount++] = ((long) (i / 2 + radius[i] / 2) << 32) | i;
            events[eventCount++] = ((long) (i / 2 + n - radius[i] / 2 - 1) << 32) | i;
            events[eventCount++] = ((long) (i / 2 + n) << 32) | i;
        }

        for (int i = 1; i < 4 * n; i += 2) {
            radius[i] = Math.min(radius[i], n - (n & 1));

            events[eventCount++] = ((long) (i / 2) << 32) | i;
            events[eventCount++] = ((long) (i / 2 + radius[i] / 2) << 32) | i;
            events[eventCount++] = ((long) (i / 2 + n - radius[i] / 2) << 32) | i;
            events[eventCount++] = ((long) (i / 2 + n) << 32) | i;
        }

        Arrays.sort(events, 0, eventCount);

        MaxHeap increasing = new MaxHeap(4 * n + 5);
        MaxHeap decreasing = new MaxHeap(4 * n + 5);
        MaxHeap flat = new MaxHeap(4 * n + 5);

        int[] state = new int[4 * n];
        int pointer = 0;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 2 * n - 1; i++) {
            while (pointer < eventCount &&
                   (events[pointer] >>> 32) <= i) {

                int id = (int) events[pointer];

                if (state[id] == 0) {
                    increasing.add(id, (radius[id] & 1) - 2 * i);
                } else if (state[id] == 1) {
                    increasing.remove(id);
                    flat.add(id, radius[id]);
                } else if (state[id] == 2) {
                    flat.remove(id);
                    decreasing.add(id, radius[id] + 2 * i);
                } else if (state[id] == 3) {
                    decreasing.remove(id);
                }

                state[id]++;
                pointer++;
            }

            if (i >= n - 1) {
                int answer = 0;

                if (increasing.size > 0) {
                    answer = Math.max(answer, increasing.max() + 2 * i);
                }

                if (decreasing.size > 0) {
                    answer = Math.max(answer, decreasing.max() - 2 * i);
                }

                if (flat.size > 0) {
                    answer = Math.max(answer, flat.max());
                }

                output.append(answer).append('\n');
            }
        }

        System.out.print(output);
    }
}

/*
Input:
13
aaaaabbbbaaaa

Output:
12
12
10
8
8
9
11
13
11
9
8
8
10
*/