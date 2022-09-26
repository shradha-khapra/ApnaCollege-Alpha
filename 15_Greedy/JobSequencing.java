import java.util.*;

public class JobSequencing {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String args[]) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(jobs.get(0).id);
        int time = 1;
        for(int i=1; i<jobs.size(); i++) {
            Job j = jobs.get(i);
            if(time < j.deadline) {
                ans.add(j.id);
                time++;
            }
        }

        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

        System.out.println();
    }
}
