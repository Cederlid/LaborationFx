package com.example.laborationfx;

import com.example.laborationfx.shape.Shape;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Deque;
import java.util.stream.Stream;

public class Svg {

    public void saveToFile(Deque<Shape> shapes, File file) {
        var header = Stream.of("<svg width=\"800.0\" height=\"600.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
        var lines = shapes.stream()
                .map(shape -> shape.toSvg());


        var lastLine = Stream.of("</svg>");
        var allLines = Stream.concat(Stream.concat(header, lines), lastLine);
        try {
            Files.write(file.toPath(), allLines.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
