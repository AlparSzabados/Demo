package alpar.szabados.demo.entities;

import alpar.szabados.demo.utils.Complete;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activityId", nullable = false, unique = true)
    private long activityId;

    @Column(name = "userId")
    private long userId; // TODO investigate nullability

    @Column(name = "activityName")
    private String activityName;

    @Column(name = "activityDate")
    private LocalDate activityDate;

    @Column(name = "complete") // TODO rename
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

    @Override
    public String toString() {
        return String.format("Activity{activityId=%d, userId=%d, activityName='%s', activityDate=%s, complete=%s}", activityId, userId, activityName, activityDate, complete);
    }
}
