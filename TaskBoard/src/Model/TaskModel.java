package Model;

public class TaskModel
{
    private String name;
    private String description;
    private String status;


    /**
     * Getter getDescription
     * @return the value of description
     * variable
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Setter setDescription set
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
