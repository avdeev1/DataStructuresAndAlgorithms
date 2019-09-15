package DataStructure;

import java.util.*;

public class PriorityQueueStepik {
    public static void main(String[] args) {
        new PriorityQueueStepik().run();
    }


    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        PrQueue queue = new PrQueue(n);

        for (int i = 0; i < n; i++) {
            String command = scanner.next();
            if (command.equals("Insert")) {
                int number = scanner.nextInt();
                queue.insert(number);
            } else {
                list.add(queue.extractMax());
            }
        }

        for (int el: list) {
            System.out.println(el);
        }

    }

    class PrQueue {
        int[] queue;
        int size;
        int count;

        public PrQueue() {
            size = 100;
            queue = new int[this.size + 1];
            count = 0;
        }

        public PrQueue(int size) {
            this.size = size;
            queue = new int[this.size + 1];
            count = 0;
        }

        void insert(int elem) {
            count++;
            queue[count] = elem;
            siftUp(count);
        }

        int getMax() {
            int max = queue[1];
            return max;
        }

        int extractMax() {
            int result = queue[1];
            queue[1] = queue[count];
            count--;
            siftDown(1);
            return result;
        }

        void remove(int i) {
            queue[i] = Integer.MAX_VALUE;
            siftUp(i);
            extractMax();
        }

        void changePriority(int i, int p) {
            int oldp = queue[i];
            queue[i] = p;
            if (p > oldp) siftUp(i);
            else siftDown(i);
        }

        int parent(int i) {
            return i/2;
        }

        int leftChild(int i) {
            return 2*i;
        }

        int rightChild(int i) {
            return 2*i + 1;
        }

        void siftUp(int i) {
            while (i>1 && queue[parent(i)]<queue[i]) {
                int temp = queue[parent(i)];
                queue[parent(i)] = queue[i];
                queue[i] = temp;
                i = parent(i);

            }
        }

        void siftDown(int i) {
            int maxIndex = i;

            int l = leftChild(i);
            if (l < size && queue[l] > queue[maxIndex]) {
                maxIndex = l;
            }

            int r = rightChild(i);
            if (r < size && queue[r] > queue[maxIndex]) {
                maxIndex = r;
            }

            if (i != maxIndex) {
                int temp = queue[maxIndex];
                queue[maxIndex] = queue[i];
                queue[i] = temp;
                siftDown(maxIndex);
            }
        }
    }
}
