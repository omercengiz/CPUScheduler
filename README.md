# CPUScheduler

The purpose of this project is to write a java program that simulates the CPU Scheduler (also known as Short-Term Scheduler) of an operating system. 

The program implements the following CPU scheduling algorithms. 

1.	First-Come-First-Serve (FCFS)
2.	Shortest-Job-First (SJF)
3.	Round-Robin with time slice = 3 (RR-3)
4.	Round-Robin with time slice = 5 (RR-5) <br/>


# FCFS

Given n processes with their burst times, the task is to find average waiting time and average turn around time using FCFS scheduling algorithm.
First in, first out (FIFO), also known as first come, first served (FCFS), is the simplest scheduling algorithm. FIFO simply queues processes in the order that they arrive in the ready queue.
In this, the process that comes first will be executed first and next process starts only after the previous gets fully executed.
Here we are considering that arrival time for all processes is 0. <br/>



# SJF
Shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next. SJN is a non-preemptive algorithm.
•	Shortest Job first has the advantage of having a minimum average waiting time among all scheduling algorithms.
•	It is a Greedy Algorithm.
•	It may cause starvation if shorter processes keep coming. This problem can be solved using the concept of ageing.
•	It is practically infeasible as Operating System may not know burst time and therefore may not sort them. While it is not possible to predict execution time, several methods can be used to estimate the execution time for a job, such as a weighted average of previous execution times. 
  SJF can be used in specialized environments where accurate estimates of running time are available. <br/>



# ROUND ROBIN SCHEDULING

Round Robin is a CPU Scheduling algorithm where each process is assigned a fixed time slot in a cyclic way.

•	It is simple, easy to implement, and starvation-free as all processes get fair share of CPU.
•	One of the most commonly used technique in CPU scheduling as a core.
•	It is preemptive as processes are assigned CPU only for a fixed slice of time at most.
•	The disadvantage of it is more overhead of context switching. <br/>




1.	Completion Time: Time at which process completes its execution.  <br/>
2.	Turn Around Time: Time Difference between completion time and arrival time. Turn Around Time = Completion Time – Arrival Time <br/>
3.	Waiting Time(W.T): Time Difference between turn around time and burst time.<br/>
Waiting Time = Turn Around Time – Burst Time <br/>
          


1.	Sort all the process according to the arrival time.
2.	Then select that process which has minimum arrival time and minimum Burst time.
3.	After completion of process make a pool of process which after till the completion of previous process and select that process among the pool which is having minimum Burst time.


### Which technologies I used?

•	Operating System:Windows i5 9th gen <br/>
•	IDE:Intellij idea <br/>
•	Programming Language: Java <br/>

### Sources: 
https://www.geeksforgeeks.org/operating-systems/









