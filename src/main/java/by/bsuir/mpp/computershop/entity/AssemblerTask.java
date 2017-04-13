package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "assembler_task")
public class AssemblerTask extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "assembly_parcel_id", referencedColumnName = "id", nullable = false),
            @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)}
    )
    private AssemblyParcel tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assembler_id", nullable = false)
    private EmployeeAuth assembler;

    @Column(name = "count", nullable = false)
    private long count;

    @Column(name = "done_count", nullable = false)
    private long doneCount;

    @Column(name = "done_date", nullable = false)
    private Date doneDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", columnDefinition = "ENUM ('ASSEMBLE', 'DISASSEMBLE')", nullable = false)
    private TaskType taskType;

    public AssemblyParcel getTasks() {
        return this.tasks;
    }

    public void setTasks(AssemblyParcel task) {
        this.tasks = tasks;
    }

    public EmployeeAuth getAssembler() {
        return this.assembler;
    }

    public void setAssembler(EmployeeAuth assembler) {
        this.assembler = assembler;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getDoneCount() {
        return this.doneCount;
    }

    public void setDoneCount(long doneCount) {
        this.doneCount = doneCount;
    }

    public Date getDoneDate() {
        return this.doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public TaskType getTaskType() {
        return this.taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public enum TaskType {
        ASSEMBLE {
            public String toString() {
                return "Сборка";
            }
        },
        DISASSEMBLE {
            public String toString() {
                return "Разборка";
            }
        };

        public abstract String toString();
    }
}
