package alpar.szabados.demo.entities;

import alpar.szabados.demo.utils.TaskStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id", nullable = false, unique = true)
    private long activityId;

    @Column(name = "user_id", nullable = false, unique = true)
    private long userId; // TODO investigate nullability

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_date")
    private LocalDate activityDate;

    @Column(name = "task_status") // TODO rename
    private TaskStatus taskStatus;

    public Activity(Long userId, String activityName, LocalDate activityDate, TaskStatus taskStatus) {
        this.userId = userId;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.taskStatus = taskStatus;
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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return String.format("Activity{activityId=%d, userId=%d, activityName='%s', activityDate=%s, taskStatus=%s}", activityId, userId, activityName, activityDate, taskStatus);
    }
}
