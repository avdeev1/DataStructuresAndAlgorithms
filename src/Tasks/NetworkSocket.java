package Tasks;

import java.util.*;

public class NetworkSocket {
    public static void main(String[] args) {
        new NetworkSocket().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int n = scanner.nextInt();
        Socket[] sockets = new Socket[n];

//        int[] arrival = new int[n];
//        int[] duration = new int[n];

        int[] time = new int[n];
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int arr = scanner.nextInt();
            int dur = scanner.nextInt();
            sockets[i] = new Socket(arr, dur);
        }

        Queue<Integer> queue = new LinkedList<>();

        if (n > 0) {
            queue.add(sockets[0].duration);
            time[0] = sockets[0].arrival;
            list.add(time[0]);
        }

        for (int i = 1; i < n; i++) {
            if (queue.size() < size){
                queue.add(sockets[i].duration);
                time[i] = Math.max((sockets[i-1].duration + list.get(list.size() - 1)), sockets[i].arrival);
                list.add(time[i]);
            } else {
                if (queue.peek() + list.get(list.size() - size) <= sockets[i].arrival) {
//                    int r = queue.peek();
//                    while (!queue.isEmpty() && queue.peek() == r) {
//                        queue.poll();
//                    }
                    queue.poll();
                    queue.add(sockets[i].duration);
                    time[i] = Math.max((sockets[i-1].duration + list.get(list.size() - 1)), sockets[i].arrival);
                    list.add(time[i]);
                } else time[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(time[i]);
        }

    }

    class Socket {
        int arrival;
        int duration;

        public Socket(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }
    }
}
