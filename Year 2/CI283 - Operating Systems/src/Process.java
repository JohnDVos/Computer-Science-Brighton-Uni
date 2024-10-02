import java.util.Random;


public class Process implements Comparable<Process> {

	public int ID;
	public int ArrivalTime;
	public int BurstTime;
	public int Priority;
	public boolean Finished;

	private int StartTime;
	private int FinishTime;
	private int Remaining;
	
	/**
     * create a job with random data
     * @param ID job number
     */
    public Process(int ID)
    {
        this.ID = ID;
        Finished = false;
        Random rand = new Random();
        if(ID == 1) {
        	ArrivalTime = 0; // first job always arrive at time = 0
        }    
        else {
        	ArrivalTime = rand.nextInt(30)+1;
        }
        BurstTime = rand.nextInt(12)+1;
        Priority = rand.nextInt(125)+1;
        FinishTime = 0 ;
        Remaining = BurstTime;
    }
	
	/**
	 * Creates a process object with the data from the csv file
	 * @param ProcessID - The ID of the process
	 * @param Arrival - The arrival time of the process into the queue
	 * @param Burst - The burst time of the process
	 * @param priority - The priority of the process
	 */
	public Process(String ProcessID, String Arrival, String Burst, String priority) {
		ID = Integer.parseInt(ProcessID);
		ArrivalTime = Integer.parseInt(Arrival);
		BurstTime = Integer.parseInt(Burst);
		Priority = Integer.parseInt(priority);
		FinishTime = 0;
		Finished = false;
		Remaining = BurstTime;
	}

	public void processWorked (int SimulationTime) {
		if (this.BurstTime == this.Remaining) {
			this.StartTime = SimulationTime;
		}
		this.Remaining--;
		if (this.Remaining == 0) {
			this.FinishTime = SimulationTime + 1;
			this.Finished = true;
		}
	}
	
	/**
     * create a copy of job with all of its data
     * @return different job but with same data
     */
    public Process copyProcess()
    {
        Process temp = new Process(this.ID);
        temp.ArrivalTime = this.ArrivalTime;
        temp.BurstTime = this.BurstTime;
        temp.Finished = this.Finished;
        temp.ID = this.ID;
        temp.Priority = this.Priority;
        temp.setStart(this.StartTime);
        temp.setFinish(this.FinishTime);
        return temp;
    }
    
    /**
     * create a copy with only the start data of the job
     * note: this is used for restarting the simulation
     * @return a copy of start state of the job
     */
    public Process getClearCopyProcess()
    {
        Process temp = new Process(this.ID);
        temp.ArrivalTime = this.ArrivalTime;
        temp.BurstTime = this.BurstTime;
        temp.Priority = this.Priority;
        temp.Remaining = this.Remaining;
        return temp;
    }
	
	public int getPercent() {
		this.ShowData();
		return (int)((BurstTime - getRemainTime())*100)/BurstTime;
	}
	
	public int getWaitTime (int SimulationTime) {
		return (getTurnaround(SimulationTime) - (BurstTime - getRemainTime()));
	}
	
	public int getRemainTime(){
        return this.Remaining;
    }
	
	/**
     * calculate the turnaround time of the process
     * requires the simulation time if the process hasn't finished yet
     * @param SimulationTime simulation time since the whole simulation has started 
     * @return turnaround time of the process
     */
	public int getTurnaround(int SimulationTime){
        if(Finished){  // if process is finished
            return (FinishTime - ArrivalTime );
        }
        if(SimulationTime > ArrivalTime){ // if process arrived but hasn't finished yet
           return (SimulationTime - ArrivalTime);
        }
        return 0; // if process hasn't arrived yet
    }
	
	/**
     * @return finish time if the process is finished
     * if not, it will return zero
     */
    public int getFinish(){
        if(Finished) 
        {
            return this.FinishTime;
        }
        return 0;
    }
    
    /**
     * @return start time of the process
     */
    public int getStart(){
        return this.StartTime;
    }
    
    /**
     * set remaining time of the process
     * @param remaining remaining time of the process
     */
    public void setRemainTime(int remaining){
        this.Remaining = remaining;
    }
    
    /**
     * set finish time of the process
     * @param finish finish time of the process
     */
    public void setFinish(int finish){
        this.FinishTime = finish;
    }
    
    /**
     * set start time of the process
     * @param start start time of the process
     */
    public void setStart(int start){
        this.StartTime = start;
    }
    
    /**
     * compare the arrive time 
     * @param other other process
     * @return true if this process is the first 
     */
    public boolean isFirst(Process other) {
        if(this.ArrivalTime == other.ArrivalTime) // if both have the same arrive time
        {
            return (this.ID < other.ID);
        }
        return (this.ArrivalTime < other.ArrivalTime);
    }
    
    /**
     * compare the shortest burst time
     * @param other other process
     * @return true if this process has shorter burst
     */
    public boolean isShort(Process other){
        if(this.BurstTime == other.BurstTime) // if both have the same burst time
        {
            return isFirst(other);
        }
        return (this.BurstTime < other.BurstTime);
    }
    
    /**
     * compare the priority
     * @param other other process
     * @return true if this process has higher priority (smaller prior number)
     */
    public boolean isPrior(Process other){
        if(this.Priority == other.Priority) //  if both have the same priority
        {
            return isFirst(other);
        }
        return (this.Priority < other.Priority);
    }
    
    /**
     * compare the remaining time 
     * @param other other process
     * @return true if this process has shorter remaining time 
     */
    public boolean isShortRemain(Process other){
        if(this.Remaining == other.Remaining) // if both have the same remaining time
        {
            return isFirst(other);
        }
        return (this.Remaining < other.Remaining);
    }
    
    public void ShowData()
    {
        System.out.println("Showing process data");
        if(this == null) {System.out.println("Empty process"); return;}
        System.out.println("# = " + this.ID + " , arrive = " + this.ArrivalTime + " , burst = " + this.BurstTime + " , Start = " + this.ArrivalTime  + " , Finish = " + this.FinishTime);
    }
	
	public int getID() {
		return this.ID;
	}
	
	public int getArrivalTime() {
		return this.ArrivalTime;
	}
	
	public int getBurstTime() {
		return this.BurstTime;
	}
	
	public int getPriority() {
		return this.Priority;
	}
	
	public int compareTo(Process x) {
		if(this.getPriority() > x.getPriority()) {
			return 1;
		}else if(this.getPriority() < x.getPriority()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
