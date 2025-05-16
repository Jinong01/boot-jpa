package kr.it.academy.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartmentEntity is a Querydsl query type for DepartmentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartmentEntity extends EntityPathBase<DepartmentEntity> {

    private static final long serialVersionUID = -1843195217L;

    public static final QDepartmentEntity departmentEntity = new QDepartmentEntity("departmentEntity");

    public final StringPath deptId = createString("deptId");

    public final StringPath deptName = createString("deptName");

    public final SetPath<EmployeeEntity, QEmployeeEntity> employees = this.<EmployeeEntity, QEmployeeEntity>createSet("employees", EmployeeEntity.class, QEmployeeEntity.class, PathInits.DIRECT2);

    public final StringPath floor = createString("floor");

    public QDepartmentEntity(String variable) {
        super(DepartmentEntity.class, forVariable(variable));
    }

    public QDepartmentEntity(Path<? extends DepartmentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartmentEntity(PathMetadata metadata) {
        super(DepartmentEntity.class, metadata);
    }

}

