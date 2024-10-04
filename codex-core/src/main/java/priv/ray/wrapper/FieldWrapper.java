package priv.ray.wrapper;

import priv.ray.parse.parser.CodexParser;

public interface FieldWrapper {

    FieldWrapper setField(String field);

    FieldWrapper setFrameLength(Integer frameLength);

    FieldWrapper bindParser(CodexParser<?> parser);

    FieldWrapper isNecessary(Boolean must);

}
