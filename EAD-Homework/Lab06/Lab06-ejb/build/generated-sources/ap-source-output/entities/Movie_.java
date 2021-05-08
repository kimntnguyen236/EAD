package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-04-19T09:16:18")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Date> relasedate;
    public static volatile SingularAttribute<Movie, String> director;
    public static volatile SingularAttribute<Movie, Integer> movieid;
    public static volatile SingularAttribute<Movie, String> title;

}