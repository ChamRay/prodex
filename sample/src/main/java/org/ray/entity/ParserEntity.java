package org.ray.entity;


import org.ray.annotation.Codex;
import org.ray.parser.StringParser;

public class ParserEntity {

    @Codex(codexParser = StringParser.class)
    private String hello;

}
