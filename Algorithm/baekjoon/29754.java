import java.io.*;
import java.time.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<Broadcast>> youtubers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            LocalTime start = LocalTime.parse(st.nextToken());
            LocalTime end = LocalTime.parse(st.nextToken());

            if (!youtubers.containsKey(name)) {
                youtubers.put(name, new ArrayList<>());
            }
            youtubers.get(name).add(new Broadcast(day, start, end));
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<Broadcast>> youtuber : youtubers.entrySet()) {
            int[] count = new int[m / 7];
            int[] time = new int[m / 7];
            for (Broadcast broadcast : youtubers.get(youtuber.getKey())) {
                int week = (broadcast.day - 1) / 7;
                Duration duration = Duration.between(broadcast.start, broadcast.end);
                long minutes = duration.toMinutes();

                count[week]++;
                time[week] += minutes;
            }

            boolean flag = true;
            for (int i = 0; i < count.length && flag; i++) {
                if (count[i] < 5) {
                    flag = false;
                }
                if (time[i] < 60 * 60) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(youtuber.getKey());
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
            System.exit(0);
        }

        Collections.sort(result);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            answer.append(result.get(i)).append("\n");
        }
        System.out.println(answer);
    }

    static class Broadcast {

        int day;
        LocalTime start;
        LocalTime end;

        public Broadcast(int day, LocalTime start, LocalTime end) {
            this.day = day;
            this.start = start;
            this.end = end;
        }
    }
}
