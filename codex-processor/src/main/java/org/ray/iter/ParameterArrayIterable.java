package org.ray.iter;

import com.squareup.javapoet.ParameterSpec;

import java.lang.reflect.Parameter;
import java.util.Iterator;

public class ParameterArrayIterable implements Iterable<ParameterSpec> {

    private Parameter[] parameters;


    public ParameterArrayIterable(Parameter[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public Iterator<ParameterSpec> iterator() {


        return new Iterator<ParameterSpec>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index< parameters.length;
            }

            @Override
            public ParameterSpec next() {
                return new ParameterSpec(parameters[index++]);
            }
        }
    }
}
