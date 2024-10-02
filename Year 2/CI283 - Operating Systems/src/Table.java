import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;


public class Table {
	
	public JFrame frame;
	public JTable table;
	public static Queue newQueue;
	
	public Table(Queue queue) {
		newQueue = queue;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,650,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(10,10,600,290);
		frame.getContentPane().add(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		TableData data = new TableData(newQueue);
		table.setModel(data);
	}
	
	public class TableData extends AbstractTableModel{
	
	    /**
		 * 
		 */
		private static final long serialVersionUID = 497253651433271888L;
		private Queue tableQueue ;  // job queue for the table
	    private String[] columnNames = {"#","Arrive","Burst","Priority","Start","Wait" , "Remain" ,"Finish" , "Turn" , "%"}; // table header	    
	    
	    /**
	     * create new table 
	     * @param queue the queue of jobs to be represented in the table
	     */
	    public TableData( Queue queue)
	    {
	        tableQueue = queue.getCopy();
	        this.fireTableRowsUpdated(1, 1);
	    } 
	    
	    /**
	     * @return number of rows in the table
	     */
	    @Override
	    public int getRowCount() {
	        return tableQueue.size(); // number of rows equals number of jobs in the queue
	    }
	
	    /**
	     * @return number of columns in the table
	     */
	    @Override
	    public int getColumnCount() {
	        return 10; 
	    }
	    
	    /**
	     * Calculate the average waiting time of all the jobs in the queue
	     * @return average waiting time
	     */
	    public double getAverageWaiting()
	    {  
	        double average = 0 ;
	        for(int i =0 ; i< tableQueue.size() ; i++)
	        {
	            average += (Integer) getValueAt(i, 5); // get 5th value of the table for every job
	        }
	        return (average/tableQueue.size());
	    }
	    
	    /**
	     * Calculate the average turnaround time for all the jobs in the queue
	     * @return 
	     */
	    public double getAverageTurn()
	    {  
	        double aveg = 0 ;
	        for(int i =0 ; i< tableQueue.size() ; i++)
	        {
	            aveg += (Integer) getValueAt(i, 8); // get the 8th value of the table for every job
	        }
	        return (aveg/tableQueue.size());
	    } 
	
	    /**
	     * return the value of a specific place in the table
	     * @param rowIndex row index of the wanted value
	     * @param columnIndex column index of the wanted value
	     * @return the wanted value at a specific row and column
	     */
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	if (rowIndex == 0) {
	    		return columnNames[columnIndex];
	    	} else {
		        Process job = tableQueue.getProcess(rowIndex-1);
		        switch(columnIndex)
		        {
		            case 0 : return job.ID;
		            case 1 : return job.ArrivalTime;
		            case 2 : return job.BurstTime;
		            case 3 : return job.Priority;
		            case 4 : return job.getStart();
		            case 5 : return job.getWaitTime(Main.Time);    
		            case 6 : return job.getRemainTime();
		            case 7 : return job.getFinish();
		            case 8 : return job.getTurnaround(Main.Time);
		            case 9 : return job.getPercent();
		            default: return 0;
		        }
	    	}
	    }
	    
	    /**
	     * return the column's header 
	     * @param column column index
	     * @return name of the header of the wanted column
	     */
	    @Override
	    public String getColumnName(int column)
	    {
	        return columnNames[column];
	    }
	    
	    /**
	     * replace a specific job in the queue with another job
	     * @param other the new job to replace with in the queue of the table
	     */
	    public void setValueAT(Process other)
	    {
	        int n = other.ID;
	        for(int i=0 ; i< tableQueue.size() ; i++)
	        {
	            if(tableQueue.getProcess(i).ID == n)
	            {
	                tableQueue.set(i, other);
	                return;
	            }
	        }
	    }
	    
	    
	}
}