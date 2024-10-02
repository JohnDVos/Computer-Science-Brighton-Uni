import java.util.*;

class Module
{
    private ArrayList<Student> people = new ArrayList <>();

    private int passed;
    private int failed;
    private String top;
    private double average;

    private int topMark = 0;
    private int totalMark = 0;

    public void add (Student student)
    {
        people.add( student );

        if (student.getMark() >= 40)
        {
            passed++;
        }
        else if (student.getMark() < 40)
        {
            failed++;
        }

        if (student.getMark() >= topMark)
        {
            topMark = student.getMark();
            top = student.getName();
        }

        totalMark += student.getMark();
    }

    public int pass ()
    {
        return passed;
    }

    public int fail()
    {
        return failed;
    }

    public String top()
    {
        return top;
    }

    public double average()
    {
        average = (double)totalMark / people.size();
        return average;
    }
}
