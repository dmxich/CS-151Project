package Model;
import java.util.*;

public class ProjectModel {

    // Variables

    private String projectName;
    private ArrayList<Column> projectList;


    //

    /**
     * Constructor create an instance
     * of Class ProjectModel
     *
     */
    public ProjectModel() {




    }


    // Getters

    /**
     * Getter getProjectName
     *
     * @return the value of variable projectName
     */
    public String getProjectName() {

        return projectName;

    }

    /**
     * Getter getProjectList
     *
     * @return the vaue of variable
     * projectList
     */
    public ArrayList<Column> getProjectList() {
        return projectList;
    }


    // Setters

    /**
     * Setter setProjectName sets the valu of variable
     * projectName to the value of
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {

        this.projectName = projectName;

    }


    /**
     * Setter setProjectList sets the valu of variable
     * projectName to the value of
     *
     * @param projectList
     */
    public void setProjectList(ArrayList<Column> projectList) {

        this.projectList = projectList;

    }


    /**
     * Method add Project Add value of
     *
     * @param prName to projectList
     */
    public void addProject(Column prName) {
        projectList.add(prName);
    }


    /**
     * Method removeProject removes the value
     *
     * @param prName from projectList
     */
    public void removeProject(String prName) {
        projectList.remove(prName);
    }

}