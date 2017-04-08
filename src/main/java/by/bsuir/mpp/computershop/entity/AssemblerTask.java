package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "assembler_task")

public class AssemblerTask extends BaseEntity<Long> {

    @Column(name = "order_id",unique = true, nullable = false)
    private int orderId;

    @Column(name = "assembly_parcel_id",unique = true, nullable = false)
    private int assemblyParcelId;

    @Column(name = "assembler_id",nullable = false)
    private int assemblerId;

    @Column(name = "task_type_id",nullable = false)
    private int taskTypeId;

    @Column(name = "count",nullable = false)
    private int count;

    @Column(name = "done_count",nullable = false)
    private int doneCount;

    @Column(name = "done_date",nullable = false)
    private Date doneDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "task_type",nullable = false)
    private TaskType taskType;

    public int getOrderId(){
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAssemblyParcelId(){
        return this.assemblyParcelId;
    }

    public void setAssemblyParcelId(int assemblyParcelId) {
        this.assemblyParcelId = assemblyParcelId;
    }

    public int getAssemblerId(){
        return this.assemblerId;
    }

    public void setAssemblerId(int assemblerId) {
        this.assemblerId = assemblerId;
    }

    public int getTaskTypeId(){
        return this.taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
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
