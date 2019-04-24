import java.util.Arrays;
import java.util.Comparator;

class Job{
    int startTime;
    int finishTime;
    int profit;

    public Job(int startTime, int finishTime, int profit){
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.profit = profit;
    }
}

class JobComparator implements Comparator<Job>{

    @Override
    public int compare(Job o1, Job o2) {
        return o1.finishTime < o2.finishTime ? -1 : o1.finishTime == o2.finishTime ? 0 : 1;
    }
}

public class WeightedJobScheduling {

    public static void main(String[] args) {

        Job jobs[] = { new Job(1,4,20),
                new Job(5, 50, 50), new Job(4, 60, 100) };

        System.out.println("The maximum profit is " + calculateProfit(jobs));

    }

    public static int calculateProfit(Job jobs[]){

        Arrays.sort(jobs, new JobComparator());

        int[] dp = new int[jobs.length];
        dp[0] = jobs[0].profit;

        for(int current = 1; current<jobs.length; current++){

            int tempProfit = jobs[current].profit;
            int nextJobIdx = binarySearchLatestJob(jobs,current);
            if(nextJobIdx != -1){
                tempProfit += jobs[nextJobIdx].profit;
            }
            dp[current] = Math.max(tempProfit, dp[current-1]);

        }

        return dp[jobs.length-1];

    }

    public static int binarySearchLatestJob(Job jobs[], int currentJobIndex){
        int lo = 0, hi = currentJobIndex - 1;

        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (jobs[mid].finishTime <= jobs[currentJobIndex].startTime){
                if (jobs[mid + 1].finishTime <= jobs[currentJobIndex].startTime)
                    lo = mid + 1;
                else
                    return mid;
            }
            else
                hi = mid - 1;
        }

        return -1;
    }

}
