package alpar.szabados.demo.entities;

import alpar.szabados.demo.utils.Complete;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activityId")
    private Long activityId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "activityName")
    private String activityName;

    @Column(name = "activityDate")
    private LocalDate activityDate;

    @Column(name = "complete")
    private Complete complete;

    public Activity(Long userId, String activityName, LocalDate activityDate, Complete complete) {
        this.userId = userId;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.complete = complete;
    }

    public Activity() {
    }

    public Long getId() {
        return activityId;
    }

    public void setId(Long activityId) {
        this.activityId = activityId;
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
