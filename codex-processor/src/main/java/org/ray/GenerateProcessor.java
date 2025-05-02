package org.ray;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.ray.annotation.Codex;
import org.ray.iter.ParameterArrayIterable;
import org.ray.parser.CodexParser;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@AutoService(Processor.class)
@SupportedAnnotationTypes("org.ray.annotation.Codex")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GenerateProcessor extends AbstractProcessor {


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {


        for (Element element : roundEnv.getElementsAnnotatedWith(Codex.class)) {
            if (element instanceof VariableElement) {
                VariableElement field = (VariableElement) element;
                Codex codex = field.getAnnotation(Codex.class);
                boolean necessary = codex.necessary();
                TypeMirror parseType = null;
                try {
                    Class<? extends CodexParser<?>> parser = codex.codexParser();
                }catch (MirroredTypeException mte){
                    parseType = mte.getTypeMirror();
                }
                String parserClassName = parseType.toString();
                try {
                    Class<?> aClass = Class.forName(parserClassName);
                    if (CodexParser.class.isAssignableFrom(aClass)) {
                        generateCodecMethods(element,(Class<? extends CodexParser<?>>) aClass);
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return true;
    }

    private void generateCodecMethods(Element element, Class<? extends CodexParser<?>> parserClass) {
        String className = element.getSimpleName().toString();

        MethodSpec encodeMethod = generateEncodeMethod(parserClass);
        MethodSpec decodeMethod = generateDecodeMethod(parserClass);

        TypeSpec typeSpec = TypeSpec.classBuilder(className + "Codec")
                .addModifiers(Modifier.PUBLIC)
                .addMethod(encodeMethod)
                .addMethod(decodeMethod)
                .build();

        try {
            JavaFile.builder("com.example", typeSpec)
                    .build()
                    .writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MethodSpec generateEncodeMethod(Class<? extends CodexParser<?>> parserClass) {
        try {
            Method encodeMethod = parserClass.getMethod("encode", Object.class);
            Class<?> returnType = encodeMethod.getReturnType();
            Parameter[] parameters = encodeMethod.getParameters();
            ParameterArrayIterable parameterSpecs = new ParameterArrayIterable(parameters);
            int modifiers = encodeMethod.getModifiers();
            return MethodSpec.methodBuilder("encode")
                    .addModifiers(Modifier.PUBLIC)
                    .returns(returnType)
                    .addParameters(parameterSpecs)
                    .addStatement("$T parser = new $T()", parserClass, parserClass)
                    .addStatement("return parser.encode(obj)")
                    .build();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private MethodSpec generateDecodeMethod(Class<? extends CodexParser<?>> parserClass) {
        return MethodSpec.methodBuilder("decode")
                .addModifiers(Modifier.PUBLIC)
                .returns(Object.class)
                .addParameter(String.class, "str")
                .addStatement("$T parser = new $T()", parserClass, parserClass)
                .addStatement("return parser.decode(str)")
                .build();
    }
}
