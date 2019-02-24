package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import interfaces.WestminsterLibraryManager;
import io.ebean.Ebean;
import models.*;
import play.libs.Json;
import play.mvc.*;

import java.util.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    WestminsterLibraryManager manager = new WestminsterLibraryManager();

    public Result index() {
        return ok("working");
    }

    public Result addBook() {
        JsonNode body = request().body().asJson();

        JsonNode json = Json.parse(body.toString());
        Book book = Json.fromJson(json, Book.class);

        String message = manager.addBook(book);

        return ok(Json.toJson(message));
    }

    public Result addDvd() {
        JsonNode body = request().body().asJson();

        JsonNode json = Json.parse(body.toString());
        Dvd dvd = Json.fromJson(json, Dvd.class);

        String message = manager.addDvd(dvd);

        return ok(Json.toJson(message));
    }

    public Result getBooks() {
        return ok(Json.toJson(manager.getBooks()));
    }

    public Result getDvds() {
        return ok(Json.toJson(manager.getDvds()));
    }

    public Result getReaderId() {
        return ok(Json.toJson(manager.getReaderId()));
    }

    public Result addReader() {
        JsonNode body = request().body().asJson();
        System.out.println(body);
        JsonNode json = Json.parse(body.toString());
        Reader reader = Json.fromJson(json, Reader.class);

        manager.addReader(reader);
        return ok(Json.toJson("reader added!"));
    }

    public Result deleteItem() {
        String body = request().body().asText();
        System.out.println("some isbn "+body);
        manager.deleteItem(body);
        return ok(Json.toJson("item deleted"));
    }

    public Result borrowItem() {
        JsonNode body = request().body().asJson();
        System.out.println(body.get("isbn").asText());
        System.out.println(body.get("readerId").asText());
        String message = manager.borrowItem(body.get("isbn").asText(), body.get("readerId").asText());
        return ok(Json.toJson(message));
    }

    public Result returnItem() {
        String body = request().body().asText();
        System.out.println("some isbn "+body);

        double fee = manager.returnItem(body);
        return ok(Json.toJson(fee));
    }

    public Result generateReport() {
        List<ReportItem> filteredItems = manager.generateReport();
        filteredItems.sort(Comparator.comparing(ReportItem::getOverdue));
        Collections.reverse(filteredItems);
        return ok(Json.toJson(filteredItems));
    }

}
