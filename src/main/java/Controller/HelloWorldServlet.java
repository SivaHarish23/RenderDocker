package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        JsonObject json = new JsonObject();
        json.addProperty("status", "success");
        json.addProperty("message", "HELLO WORLD!!!!!!!!!!!!!!!");
        response.setStatus(HttpServletResponse.SC_OK);
        writeResponse(response, json);
    }
    private void writeResponse(HttpServletResponse response, JsonObject json) throws IOException {
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            out.print(gson.toJson(json));
            out.flush();
        }
    }
}
