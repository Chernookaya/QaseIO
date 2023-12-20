package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Suite {
    String suiteName;
    String description;
    String preconditions;


    public Suite(String suiteName, String description, String preconditions) {
        this.suiteName = suiteName;
        this.description = description;
        this.preconditions = preconditions;

    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }



}
