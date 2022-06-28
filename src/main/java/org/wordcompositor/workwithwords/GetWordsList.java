package org.wordcompositor.workwithwords;

import java.io.FileNotFoundException;
import java.util.List;

public interface GetWordsList {

    List<String> generateList() throws FileNotFoundException;
}
