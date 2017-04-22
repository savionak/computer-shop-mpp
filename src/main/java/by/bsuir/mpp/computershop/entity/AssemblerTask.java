package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "assembler_task")
public class AssemblerTask extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "parcel_id", referencedColumnName = "id", nullable = false),
            @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)}
    )
    private AssemblyParcel parcel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assembler_id", nullable = false)
    private EmployeeAuth assembler;

    @Column(name = "count", nullable = false)
    private long count;

    @Column(name = "done_count", nullable = false)
    private long doneCount;

    @Column(name = "done_date")
    private Date doneDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", nullable = false,
            columnDefinition = "ENUM ('ASSEMBLE', 'DISASSEMBLE')")
    private TaskType taskType;

    @Column(name = "canceled", columnDefinition = "BIT", nullable = false)
    private boolean canceled = false;

    public AssemblyParcel getParcel() {
        return this.parcel;
    }

    public void setParcel(AssemblyParcel parcel) {
        this.parcel = parcel;
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

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
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
