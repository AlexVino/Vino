package by.vino.mygarage.dao.jpa;

import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class QueryExtensions {

    @QueryDelegate(Bodystyle.class)
    public static BooleanExpression eq(QBodystyle qBodystyle, String bodystyle){
        return qBodystyle.bodystyleName.eq(bodystyle);
    }
}
