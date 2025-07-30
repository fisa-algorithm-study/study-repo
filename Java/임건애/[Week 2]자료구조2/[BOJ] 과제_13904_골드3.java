import java.util.*;
import java.io.*;

class Task implements Comparable<Task>{
    int deadline;
    int score;
    
    public Task(int deadline, int score) {
        this.deadline = deadline;
        this.score = score;
    }
    
    // @Override
    // public int compareTo(Task other) {
    //     if (this.score == other.score) {
    //         return this.deadline - other.deadline;
    //     }
    //     return other.score - this.score; // 점수 높은 순
    // }
    
    @Override
    public String toString() {
        return "(" + deadline + ", " + score + ")";
    }
    
}

class CustomComparator implements Comparator<Task> {
    @Override
    public int compare(Task other) {
        if (this.score == other.score) {
            return this.deadline - other.deadline;
        }
        return other.score - this.score; // 점수 높은 순
    }
}

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Task[] taskArray = new Task[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            
            taskArray[i] = new Task(deadline, score);
        }
        
        Arrays.sort(taskArray, new CustomComparator());
        
        

        PriorityQueue<Task> tasks = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            
            tasks.offer(new Task(deadline, score));
        }
        
        while (!tasks.isEmpty()) {
            Task t = tasks.poll();
            System.out.println("deadline: " + t.deadline + ", score: " + t.score);
        }
	}
}
