package dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class Project {
    String projectName;
    String projectCode;
    String description;


    public Project(String projectName, String projectCode, String description) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.description = description;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}