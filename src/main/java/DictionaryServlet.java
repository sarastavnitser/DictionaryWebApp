

import com.google.gson.Gson;


import javax.crypto.spec.PSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

/**
 * A Request is sent with a TriangleBoard and then a Response is created with the
 * best Move or the next best TriangleBoard
 */
public class DictionaryServlet extends HttpServlet {

    private final Dictionary dictionary;


//    private final Gson gson = new Gson();

    public DictionaryServlet() {
        dictionary = new Dictionary();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        // http://localhost:8080/DictionaryWebApp-1.0-SNAPSHOT/dictionary?word=cat

        String wordString = request.getParameter("word");

        String definition;

        if (dictionary.isWord(wordString)) {
            definition = dictionary.getDefinition(wordString);
        } else {
            definition = "Sorry, " + wordString + " is not a valid word in the dictionary";
        }

        response.setContentType("text/json");
        response.getWriter().println(definition);
    }
}