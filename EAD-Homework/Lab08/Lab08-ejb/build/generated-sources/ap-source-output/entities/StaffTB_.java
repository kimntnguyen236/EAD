package entities;

import entities.DepartmentTB;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-04-25T09:23:33")
@StaticMetamodel(StaffTB.class)
public class StaffTB_ { 

    public static volatile SingularAttribute<StaffTB, String> staffemail;
    public static volatile SingularAttribute<StaffTB, Boolean> role;
    public static volatile SingularAttribute<StaffTB, DepartmentTB> departmentid;
    public static volatile SingularAttribute<StaffTB, String> staffpassword;
    public static volatile SingularAttribute<StaffTB, String> staffname;
    public static volatile SingularAttribute<StaffTB, Integer> salary;
    public static volatile SingularAttribute<StaffTB, String> staffid;

}