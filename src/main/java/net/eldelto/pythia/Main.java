package net.eldelto.pythia;

import io.vertx.core.Vertx;
import net.eldelto.pythia.web.WebVerticle;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        WebVerticle webVerticle = new WebVerticle();
        vertx.deployVerticle(webVerticle);
    }
}
