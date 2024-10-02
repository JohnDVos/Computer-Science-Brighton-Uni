public class RoundRobin {

	protected Queue Processes; // List of processes that haven't been worked yet
	protected Queue ReadyQueue; // List of jobs in the ready queue
	protected Process CurrentProcess; //Current job being worked on
	protected boolean Busy; // Indicated whether the CPU is busy or not
	
	private int QuantumTime;
	private int ProcessTime;
	
	public RoundRobin (Queue workQueue, int quantum) {
		ReadyQueue = new Queue(workQueue.size()); // Initialise ready queue size
        Busy = false;  // set busy to default
        Processes = workQueue.getCopy(); // copy simulation queue to the algorithm main queue
        Processes.OrderedByArrive();  // order algorithm queue by arrive time 
        QuantumTime = quantum;
        
	}
	
	/**
     * shows what happens in a single step when using this algorithm
     * @param simulationTime current time of this simulation
     * @return job the CPU was working on
     */
	public Process nextStep (int simulationTime)    {
        updateReadyQueue(simulationTime); // add newly arrived jobs to the ready queue
        if(!Busy) { // if CPU is not processing a job ( RR is non-preemptive algorithm)
        
            if(simulationTime!=0 && CurrentProcess.getRemainTime() !=0) {
            	ReadyQueue.add(CurrentProcess);  // if job is not finished add it to the ready queue again
            }
            if(ReadyQueue.isEmpty()) {
            	return null;
            }
            ProcessTime = QuantumTime;  // restart quantum time for the new job
            Busy = true;
            setCurrentJob();  // move the first job in the ready queue to be the current working job
        }
        return workInCPU(simulationTime); 
    }
	
	/**
     * work the current job in the CPU for one simulation time step
     * @param simulationTime current time of the simulation
     * @return the current job the CPU is working on
     */
	 protected Process workInCPU(int simulationTime)
    {
        CurrentProcess.processWorked(simulationTime);
        ProcessTime--;  // the rest of quantum time for this time of working of the job
        if(ProcessTime == 0 || CurrentProcess.getRemainTime() ==0 ) {
        	Busy = false; // if job is finished or round time is finished, make CPU not busy
        }
        
        return CurrentProcess;
    }
	 
	 /**
     * @return a separated copy of the ready queue
     */
    public Queue getReadyQueue ()
    {
        return ReadyQueue.getCopy();
    }
    
    /**
     * check whether the algorithm finished the simulation or not.
     * it check whether the main list and ready queue are empty and 
     * the CPU is not working on any job
     * @return true if the simulation is finished
     */
    public boolean isFinished()
    {
        return (Processes.isEmpty() && ReadyQueue.isEmpty()  && !Busy &&  CurrentProcess.getRemainTime() == 0);
    }
    
    /**
     * add the newly arrived jobs to the ready queue
     * by comparing the arrive time with the simulation time.
     * @param simulationTime current time of the simulation
     */
    protected void updateReadyQueue(int simulationTime)
    {
        for (int i = 0 ; i<Processes.size() ; i++)
        {
            Process temp = Processes.getProcess(i);
            if(temp.ArrivalTime == simulationTime)  // if job arrived  
            {
                ReadyQueue.add(temp);  // if job arrived then move it to the ready queue
                Processes.removeJob(i);   // remove the job from main job list
                i--; // removing reduces the size of the list by one
            }
        }
    }
    
    /**
     * move the first job at the ready queue
     * to be the current job for the CPU to work on.
     */
    protected void setCurrentJob()
    {
        CurrentProcess = ReadyQueue.getProcess(0); 
        ReadyQueue.removeJob(0);
    }
	
}
