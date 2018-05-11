package Model;
import java.io.*;

public class Column implements Serializable
{

    private String name;


    public Column(String name)
    {

        this.name = name;

    }



    public String getName()
    {

        return name;

    }



    @Override

    public boolean equals(Object obj)
    {

        Column column = (Column) obj;

        return name.equals(column.name);

    }

}