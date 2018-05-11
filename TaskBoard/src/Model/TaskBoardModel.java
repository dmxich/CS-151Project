package Model;

import Model.ProjectModel;

import java.util.ArrayList;

public class TaskBoardModel
{
    private String taskBoardName;
    private ArrayList<ProjectModel> projectList;
    private String fileName;


    

    /**
     * Constracts a new instance of class
     * TaskBoardModel with following parameters
     * @param str
     * @param aList
     * @param fName
     */
    public TaskBoardModel(String str, ArrayList<ProjectModel> aList, String fName )
    {
        taskBoardName = str;
        fileName = fName;
        projectList = aList;
    }



    //setter methods

    /**
     * Setter setTaskBoardName
     * Sets the value of variable taskBoardName to value of
     * @param taskBoardName
     */
    public void setTaskBoardName(String taskBoardName)
    {
        this.taskBoardName = taskBoardName;
    }

    /**
     * Setter setFileName
     * Sets the value of variable fileName to value of
     * @param fileName
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }


    /**
     * Setter setProjectList
     * Sets the value of variable projectList ot value of
     * @param alist
     */
    public void setProjectList(ArrayList<ProjectModel> alist)
    {
        projectList = alist;
    }


    //getter methods

    /**
     * Getter getFileName
     * @return the value of variable
     * fileName
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * Getter getTaskBoardName
     * @return the value of variable
     * taskBoardName
     */
    public String getTaskBoardName()
    {
        return taskBoardName;
    }


    /**
     * Getter getProjectList
     * @return the value of variable
     * projectList
     */
    public ArrayList<ProjectModel> getProjectList()
    {
        return projectList;
    }

    /**
     * Method adds
     * @param project to projectList
     */
    public void addProject (ProjectModel project)
    {
        projectList.add(project);
    }

    /**
     * Method removes
     * @param project from projectList
     */
    public void removeProject(ProjectModel project)
    {
        projectList.remove(project);
    }


}
