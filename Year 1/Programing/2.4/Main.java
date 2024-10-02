class Main 
{
    public static void main (String args[]) 
    {
        int rows = 3;
        int width = 1;
        int spaces = rows - 1;

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < spaces; j++) 
            {
                System.out.print(".");
            }
            for (int j = 0; j < (rows - spaces); j++) 
            {
                System.out.print("* ");
            }
            
            System.out.println();
            spaces--;
          
        }
        
        spaces = 1;

        for (int i = 1; i >= 0; i--) 
        {
            for (int j = 0; j < spaces; j++) 
            {
                System.out.print(".");
            }
            for (int j = 0; j < (rows - spaces); j++) 
            {
                System.out.print("* ");
            }
            System.out.println();
            spaces++;
       
        }
    }
}
