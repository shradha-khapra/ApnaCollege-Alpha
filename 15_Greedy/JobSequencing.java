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
        int jobsInfo[][] = {{4, 60}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> jobs = new ArrayList<>();
        
        int maxtime=0;
        
        for(int i=0; i<jobsInfo.length; i++) { 
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
            maxtime=Math.max(maxtime, jobsInfo[i][0]);
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        
        boolean slot[]=new boolean[maxtime+1];
        for(int i=0;i<=maxtime;i++){
            slot[i]=false;
           
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int count=0;
       
        for(int i=0; i<jobs.size(); i++) {
            Job j = jobs.get(i);
            for(int k=j.deadline;k>0;k--) {
                if(slot[k]==false) {
                    slot[k]=true;
                    ans.add(j.id);
                    count++;
                    break;
                }
            }  
        }
        
        System.out.println("No. of jobs to be done="+count);

        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

        System.out.println();
    }
}
