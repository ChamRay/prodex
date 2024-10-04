package priv.ray.wrapper;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractPropertyWrapper {

    private Class<?> clazz ;

    private List<FieldWrapper> fieldWrappers = new LinkedList<>();


    public void addFieldWrapper(FieldWrapper fieldWrapper){
        this.fieldWrappers.add(fieldWrapper);
    }


}
