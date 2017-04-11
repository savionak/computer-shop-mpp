package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "assembler_task")

public class AssemblerTask extends BaseEntity<Long> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private AssemblyParcel order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assembly_parcel_id", nullable = false)
    private AssemblyParcel assemblyParcel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assembler_id", nullable = false)
    private EmployeeAuth assembler;

    @Column(name = "count",nullable = false)
    private int count;

    @Column(name = "done_count",nullable = false, columnDefinition = "int default 0")
    private int doneCount;

    @Column(name = "done_date",nullable = false)
    private Date doneDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "task_type",nullable = false)
    private TaskType taskType;

    public AssemblyParcel getOrder(){
        return this.order;
    }
    public void setOrder(AssemblyParcel order) {
        this.order = order;
    }

    public AssemblyParcel getAssemblyParcel(){
        return this.assemblyParcel;
    }
    public void setAssemblyParcel(AssemblyParcel assemblyParcel) {
        this.assemblyParcel = assemblyParcel;
    }

    public EmployeeAuth getAssembler(){
        return this.assembler;
    }
    public void setAssembler(EmployeeAuth assembler) {
        this.assembler = assembler;
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getDoneCount(){
        return this.doneCount;
    }
    public void setDoneCount(int doneCount) {
        this.doneCount = doneCount;
    }

    public Date getDoneDate(){
        return this.doneDate;
    }
    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public TaskType getTaskType(){
        return this.taskType;
    }
    public void setTaskType(TaskType taskType) {
        this.taskType =taskType;
    }


}
