package kr.it.academy.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployeeEntity is a Querydsl query type for EmployeeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployeeEntity extends EntityPathBase<EmployeeEntity> {

    private static final long serialVersionUID = -879874165L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployeeEntity employeeEntity = new QEmployeeEntity("employeeEntity");

    public final QDepartmentEntity department;

    public final StringPath emId = createString("emId");

    public final StringPath myName = createString("myName");

    public QEmployeeEntity(String variable) {
        this(EmployeeEntity.class, forVariable(variable), INITS);
    }

    public QEmployeeEntity(Path<? extends EmployeeEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployeeEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployeeEntity(PathMetadata metadata, PathInits inits) {
        this(EmployeeEntity.class, metadata, inits);
    }

    public QEmployeeEntity(Class<? extends EmployeeEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartmentEntity(forProperty("department")) : null;
    }

}

