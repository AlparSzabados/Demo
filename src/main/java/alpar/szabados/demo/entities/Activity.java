package alpar.szabados.demo.entities;

import alpar.szabados.demo.utils.Complete;

import java.time.LocalDate;

public class Activity {
    private Long id;
    private Long userId;
    private String activityName;
    private LocalDate activityDate;
    private Complete complete;

    public Activity(Long id, Long userId, String activityName, LocalDate activityDate, Complete complete) {
        this.id = id;
        this.userId = userId;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public Complete getComplete() {
        return complete;
    }

    public void setComplete(Complete complete) {
        this.complete = complete;
    }
}
