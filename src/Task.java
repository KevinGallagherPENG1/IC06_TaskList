import java.io.Serializable;

public class Task implements Serializable
{
    //deefine the fields (data we wish to store)
    //each task object gets its own copy of the following fields
    private String mName;
    private String mDueDate;
    private String mDueTime;
    private String mPriority;


    //Static variables (aka class variables) are the aggregate data for all objects
    //Static belong to the CLASS (only one copy) that all objects share
    private static int sTotalTasks = 0;


    //Methods - actions or behaviors that can be done to each object

    //Constructor method: instantiates (creates) a brand new object (creates a brand new Task)
    //If name matches the same name as the class (eg Task) it is the constructor method

    //THE PARAMETERS DONT NEED THE M
    //THIS IS A PARAMETERIZED CONSTRUCTOR
    public Task(String name, String dueDate, String dueTime, String priority)
    {
        mName = name;
        mDueDate = dueDate;
        mDueTime = dueTime;
        mPriority = priority;
        //Every time constructor is called, we increment the static / global count (new object)
        sTotalTasks++;
    }


    //COPY CONSTRUCTOR - cretes a duplicate copy of an existing object
    public Task(Task other)
    {
        mName = other.mName;
        mDueDate = other.mDueDate;
        mDueTime = other.mDueTime;
        mPriority = other.mPriority;
        sTotalTasks++;
    }

    //makes objects print string instead of memory location
    public String toString()
    {
        String output = "Task [Name=" + mName + ", Due Date="+ mDueDate + ", Due Time=" + mDueTime + ", Priority=" +mPriority +"]";

        return output;
    }

    public static int getTotalTasks()
    {
        return sTotalTasks;
    }
    public String getDueDate()
    {
        return mDueDate;
    }
    public String getDueTime()
    {
        return mDueTime;
    }
    public String getName()
    {
        return mName;
    }
    public String getPriority()
    {
        return mPriority;
    }

    //make a setter modifier method for the due Date
    public void setDueDate(String newDate)
    {
        mDueDate = newDate;
    }
    public void setDueTime(String newTime)
    {
        mDueTime = newTime;
    }
    public void setName(String newName)
    {
        mName = newName;
    }
    public void setPriority(String newPriority)
    {
        mPriority = newPriority;
    }

    //Equals method compares two objects for equality by checking values of all fields
    public boolean equals(Task other)
    {
        //if all fields are same, return true
        //otherwise, return false
        if(mName.equals(other.mName) && mDueDate.equals(other.mDueDate) && mDueTime.equals(other.mDueTime) && mPriority.equals(other.mPriority))
            return true;
        else
            return false;
    }


}