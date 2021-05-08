package entities;

import entities.StaffTB;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-04-25T09:23:33")
@StaticMetamodel(DepartmentTB.class)
public class DepartmentTB_ { 

    public static volatile SingularAttribute<DepartmentTB, String> departmentname;
    public static volatile SingularAttribute<DepartmentTB, Integer> departmentid;
    public static volatile ListAttribute<DepartmentTB, StaffTB> staffTBList;

}