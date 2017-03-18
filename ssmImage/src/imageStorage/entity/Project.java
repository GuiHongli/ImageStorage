package imageStorage.entity;

public class Project {
    private Integer projectId;

    private String projectName;

    private String projectPosition;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectPosition() {
        return projectPosition;
    }

    public void setProjectPosition(String projectPosition) {
        this.projectPosition = projectPosition == null ? null : projectPosition.trim();
    }
}