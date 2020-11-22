package cpuscheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Scheduling {
    public static void main(String args[]) {

        int averageTime = 0;

        String line = null;
        int lineNum = 0;
        int arr[] = {};
        String jobList[] = {};
        File file = new File("test1.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);

            while (in.hasNextLine()) {
                line = in.nextLine();
                lineNum++;
                if ((lineNum % 2) == 0) {
                    arr = addProcessTime(arr, Integer.parseInt(line));
                }else {
                    jobList = addJobList(jobList, line.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(arr.length);
        System.out.println(jobList.length);



        int count = arr.length;


        int FCFS[] = new int[count];

        int SJF[] = new int[count];

        int turnAroundTime[] = new int[count];

        int time = 0;

        float total = 0;

        System.out.println("using FCFS ");

        for (int i = 0; i < count; i++) {

            time += arr[i];

            FCFS[i] = time;

            total += FCFS[i];

        }

        System.out.println("using FCFS average time : " + total / count);

        System.out.println("Proccess"+"\t"+"JobId\t" + "Burst Time");
        for (int i = 0; i < count; i++) {

            System.out.println("P"+i +"\t\t\t"+ jobList[i] + "\t\t" + FCFS[i]);

        }

        System.out.println("\n\nTurn Around Time : FCFS");
        for(int i = 0; i < count; i++){
            int temp = FCFS[i] - averageTime;
            turnAroundTime[i] = temp;
            System.out.println("P"+i+" : " + turnAroundTime[i]);
        }


        RoundRobin(arr, jobList, count, 3);

        RoundRobin(arr, jobList, count, 5);

        int temp;

        int indicator = 0;

        for (int i = count - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {

                    indicator = 1;

                    temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;

                }

            }

            if (indicator == 0) break;

        }

        time = 0;

        total = 0;

        System.out.println("using SJF ");

        for (int i = 0; i < count; i++) {

            time += arr[i];

            SJF[i] = time;

            total += SJF[i];

        }

        System.out.println("Proccess"+"\t"+"JobId\t" + "Burst Time");
        for (int i = 0; i < count; i++) {

            System.out.println("P"+i +"\t\t\t"+ jobList[i] + "\t\t" + SJF[i]);

        }
        System.out.println("using SJF average time : " + total / count);

    }

    static void RoundRobin(int arr[], String jobList[], int n, int quantum) {
        int RR[] = new int[n];

        int rem_bt[] = new int[n];

        float total = 0;

        for (int i = 0; i < n; i++)

            rem_bt[i] = arr[i];

        int t = 0;

        while (true) {

            boolean done = true;

            for (int i = 0; i < n; i++) {

                if (rem_bt[i] > 0) {

                    done = false;

                    if (rem_bt[i] > quantum) {

                        t += quantum;

                        rem_bt[i] -= quantum;

                    } else {

                        t = t + rem_bt[i];

                        RR[i] = t;

                        rem_bt[i] = 0;

                    }

                }

            }

            if (done == true) {
                break;
            }

        }

        System.out.println("using Roundrobin with quantum " + quantum);

        for (int i = 0; i < n; i++) {

            System.out.println("P"+i +"\t\t\t"+ jobList[i] + "\t\t" + RR[i]);

            total += RR[i];

        }

        System.out.printf("using Roundrobin average time : %s%n", total / n);

    }

    static int[] addProcessTime(int[] a, int e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    static String[] addJobList(String[] a, String e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    // Function to calculate turn around time
    static void findTurnAroundTime(int processes[], int n, int bt[],
                                   int wt[], int tat[])
    {
        // Calculating turnaround time by adding bt[i] + wt[i]
        for (int i = 0; i < n ; i++)
            tat[i] = bt[i] + wt[i];
    }
}
