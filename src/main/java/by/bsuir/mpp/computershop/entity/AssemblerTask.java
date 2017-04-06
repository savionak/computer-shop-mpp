package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;

@Entity
@Table(name = "assembler_task")

public class AssemblerTask extends BaseEntity<Long> {

    @Column(unique = true, nullable = false)
    private int order_id;

    @Column(unique = true, nullable = false)
    private int assembly_parcel_id;

    @Column(nullable = false)
    private int assembler_id;

    @Column(nullable = false)
    private int task_type_id;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int done_count;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private TaskType task_type;

    public int getOrder_id(){
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAssembly_parcel_id(){
        return this.assembly_parcel_id;
    }

    public void setAssembly_parcel_id(int assembly_parcel_id) {
        this.assembly_parcel_id = assembly_parcel_id;
    }

    public int getAssembler_id(){
        return this.assembler_id;
    }

    public void setAssembler_id(int assembler_id) {
        this.assembler_id = assembler_id;
    }

    public int getTask_type_id(){
        return this.task_type_id;
    }

    public void setTask_type_id(int task_type_id) {
        this.task_type_id = task_type_id;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDone_count(){
        return this.done_count;
    }

    public void setDone_count(int done_count) {
        this.done_count = done_count;
    }

    public TaskType getTask_type(){
        return this.task_type;
    }

    public void setTask_type(TaskType task_type) {
        this.task_type =task_type;
    }


}
