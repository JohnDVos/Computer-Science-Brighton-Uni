import java.util.ArrayList;


public class Queue {
    
    private ArrayList<Process> mainList;  							// Queue is a list of jobs
    private int number; 											// max number of jobs in the queue
    
    /**create an empty queue with size for a specific number of jobs
     * @param number number of jobs*/
    public Queue(int number)
    {
        mainList = new ArrayList<Process>(number);
        this.number = number; 
    }
    
    /**
     * create a queue and fill it with a given list of jobs
     * @param list list of jobs for the queue
     */
    public Queue(ArrayList<Process> list)
    {
        mainList = new ArrayList<Process>(list.size());
        mainList.addAll(list);
    }
    // </editor-fold>
    
    /**
     * fill the queue with jobs with random data
     * @param number number of jobs in the queue
     */
    public void fill()
    { 
        for(int i=0 ; i<number ; i++)
        {
            Process temp = new Process(i+1); // job number starts from 1 not 0
            mainList.add(i, temp);
        }
    }
    
    /**
     * @param num number of the job in the queue
     * @return selected job
     */
    public Process getProcess(int num)
    {
        return mainList.get(num);
    }
    
    /**
     * remove selected job from the queue
     * @param num number of the selected job to be removed
     */
    public void removeJob(int num)
    {
        mainList.remove(num);
    }
    
    /**
     * add job to the end of the queue
     * @param job job to be added
     */
    public void add(Process process)
    {
        mainList.add(process);
    }
    
    /**
     * replace the job at a specific place of the queue
     * @param i place of job to be replaced
     * @param job new job to replace with
     */
    public void set(int i , Process process)
    {
        mainList.set(i, process);
    }
    
    /**
     * check if the queue is empty
     * @return true if empty
     */
    public boolean isEmpty()
    {
        return (mainList.isEmpty());
    }
    
    /**
     * @return the size of the queue 
     */
    public int size()
    {
        return mainList.size();
    }
    
    /**
     * remove all the elements of the queue
     */
    public void clearQueue()
    {
        for(int i =0 ; i< mainList.size() ; i++)
        {
           mainList.remove(i);
        }
    }
    
    /**
     * order the jobs inside the queue by arrive time
     */
    public void OrderedByArrive()
    {
        for(int i=0 ; i<mainList.size()-1 ; i++)
        {
            for(int j=i+1 ; j<mainList.size() ;j++)
            {
                Process j1 = mainList.get(i);
                Process j2 = mainList.get(j);
                if(j2.isFirst(j1))
                {
                    mainList.set(i, j2);
                    mainList.set(j, j1);
                }
            }
        }
    }
    
    /**
     *  order the jobs inside the queue by shortest burst
     */
    public void OrderedByShortest()
    {
        for(int i=0 ; i<mainList.size()-1 ; i++)
        {
            for(int j=i+1 ; j<mainList.size() ;j++)
            {
                Process j1 = mainList.get(i);
                Process j2 = mainList.get(j);
                if(j2.isShort(j1))
                {
                    mainList.set(i, j2);
                    mainList.set(j, j1);
                }
            }
        }
    }
    
    /**
     * order the jobs inside the queue by priority
     */
    public void OrderedByPriority()
    {
        for(int i=0 ; i<mainList.size()-1 ; i++)
        {
            for(int j=i+1 ; j<mainList.size() ;j++)
            {
                Process j1 = mainList.get(i);
                Process j2 = mainList.get(j);
                if(j2.isPrior(j1))
                {
                    mainList.set(i, j2);
                    mainList.set(j, j1);
                }
            }
        }
    }
    
    /**
     * order the jobs inside the queue by the shortest remaining time
     */
    public void OrderedByShortRemain()
    {
        for(int i=0 ; i<mainList.size()-1 ; i++)
        {
            for(int j=i+1 ; j<mainList.size() ;j++)
            {
                Process j1 = mainList.get(i);
                Process j2 = mainList.get(j);
                if(j2.isShortRemain(j1))
                {
                    mainList.set(i, j2);
                    mainList.set(j, j1);
                }
            }
        }
    }
    
    // </editor-fold>
    
    /**
     * create a copy of a queue with all jobs data
     * @param list queue to be copied
     * @return complete separated copy of the queue
     */
    public Queue getCopy ()
    {
        return new Queue(mainList);
    }

    /**
     * create a copy of a queue with only the start data of every job.
     * note: this is used for restarting the same simulation by taking 
     * a copy of the start data of the queue to use it in another simulation.
     * @param list queue to be copied
     * @return clear copy of the queue
     */
    public Queue getClearCopy()
    {
        ArrayList<Process> list = new ArrayList<Process>(mainList.size());
        for(int i=0 ; i<mainList.size() ; i++)
        {
            Process temp = mainList.get(i).getClearCopyProcess();  // copy only start data of the job
            list.add(temp);
        }
        return new Queue(list);
    }
     
    /**
     * Show queue content (every job details)
     * improved version of toString method but used for testing.
     * @param list Queue to show it's content 
     */
    public void showQueue(int simulationTime)
    {
        if(mainList.isEmpty()){System.out.println("Empty Queue");  return;} // if queue is empty
        System.out.println("number of jobs " + mainList.size() );
        System.out.println("# "+" Arrive "+" Burst "+" Priority "+" Start "+" Wait "+" Remain "+" Finish "+" Turn "+" % ");
        for(int i=0 ; i<mainList.size() ; i++) // show every job data
        {
            Process temp = mainList.get(i);
            System.out.print(temp.ID + "    " + temp.ArrivalTime + "      " + temp.BurstTime +"       ");
            System.out.print(temp.Priority + "      " + temp.getStart() + "      " + temp.getWaitTime(simulationTime)+ "      ");
            System.out.print(temp.getRemainTime() + "       " + temp.getFinish() + "      " + temp.getTurnaround(simulationTime)+ "    ");
            System.out.println(temp.getPercent());
        }
    }
}