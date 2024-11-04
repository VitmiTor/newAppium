package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class Gestures {
    private static final PointerInput finger =
            new PointerInput(PointerInput.Kind.TOUCH, "finger");


    private static AndroidDriver getDriver() {
        return new DriverProvider().get();
    }

    public static void tap(WebElement element) {
        final var centerPoint = getCenterPoint(element);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hacia el elemento");
        sequence.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(),
                        centerPoint
                )
        );

        Logs.debug("Presionando el elemento");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Esperando 1 segundo");
        sequence.addAction(new Pause(finger, Duration.ofMillis(1000)));

        Logs.debug("Dejando presionado el elemento");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(List.of(sequence));
    }

    public static void longTap(WebElement element) {
        final var centerPoint = getCenterPoint(element);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hacia el elemento");
        sequence.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(),
                        centerPoint
                )
        );

        Logs.debug("Presionando el elemento");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Esperando 3.5 segundo");
        sequence.addAction(new Pause(finger, Duration.ofMillis(3500)));

        Logs.debug("Dejando presionado el elemento");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(List.of(sequence));
    }

    public static void doubleTap(WebElement element) {
        final var centerPoint = getCenterPoint(element);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hacia el elemento");
        sequence.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(),
                        centerPoint
                )
        );

        for (var i = 0; i < 2; i++) {
            Logs.debug("Presionando el elemento");
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            Logs.debug("Esperando 3.5 segundo");
            sequence.addAction(new Pause(finger, Duration.ofMillis(3500)));

            Logs.debug("Dejando presionado el elemento");
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        }

        getDriver().perform(List.of(sequence));
    }

    public static void dragTo(WebElement elementOrigin, WebElement elementDestiny) {
        final var centroOrigen = getCenterPoint(elementOrigin);
        final var centroDestino = getCenterPoint(elementDestiny);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Moviendo el dedo hacia el centro de origen");
        sequence.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(500),
                        PointerInput.Origin.viewport(),
                        centroOrigen
                )
        );

        Logs.debug("Tocando la pantalla");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Agregamos pequeña pausa");
        sequence.addAction(new Pause(finger, Duration.ofMillis(2000)));

        Logs.debug("Moviendo hacia el destino");
        sequence.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(500),
                        PointerInput.Origin.viewport(),
                        centroDestino
                )
        );

        Logs.debug("Agregamos pequeña pausa");
        sequence.addAction(new Pause(finger, Duration.ofMillis(1500)));

        Logs.debug("Liberamos la pantalla");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Logs.info("ejecuttamos las acciones");
        getDriver().perform(List.of(sequence));
    }

    public static void swipeGeneralPoints(Point origen, Point destiny) {
        Logs.debug("Haciendo swipe desde el %s hasta %s", origen, destiny);
        final var sequence = new Sequence(finger, 1);

        Logs.debug("Movemos el dedo hacia la posición inicial");
        sequence.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        origen
                )
        );

        Logs.debug("Tocamos la pantalla");
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Movemos el dedo hacia la posición final ");
        sequence.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(),
                        destiny
                )
        );

        Logs.debug("Liberamos la pantalla");
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Logs.debug("Ejecutamos las acciones");
        getDriver().perform(List.of(sequence));
    }

    public static void swipeGeneral(
            double porcentajeXInicial,
            double porcentajeYInicial,
            double porcentajeXFinal,
            double porcentajeYFinal,
            WebElement element
    ) {
        final var puntoInicial =
                getElementPointUsingPercentages(porcentajeXInicial, porcentajeYInicial, element);

        final var puntoFinal =
                getElementPointUsingPercentages(porcentajeXFinal, porcentajeYFinal, element);

        swipeGeneralPoints(puntoInicial, puntoFinal);
    }

    public static void swipeHorizontal(
            double porcentajeY,
            double porcentajXInicial,
            double porcentajeXFinal,
            WebElement element
    ) {
        swipeGeneral(porcentajXInicial, porcentajeY, porcentajeXFinal, porcentajeY, element);
    }

    public static void swipeVertical(
            double porcentajeX,
            double porcentajeYInicial,
            double porcentajeYFinal,
            WebElement element
    ) {
        swipeGeneral(porcentajeX, porcentajeYInicial, porcentajeX, porcentajeYFinal, element);
    }

    private static Point getCenterPoint(WebElement element) {
        final var ubicacionElemento = element.getLocation();
        final var tamanioElement = element.getSize();

        final var centroX = ubicacionElemento.getX() + tamanioElement.getWidth() / 2;
        final var centroY = ubicacionElemento.getY() + tamanioElement.getHeight() / 2;

        return new Point(centroX, centroY);
    }

    public static Point getElementPointUsingPercentages(
            double percentageX,
            double percentageY,
            WebElement element
    ) {
        final var ubicacion = element.getLocation();
        final var tamanio = element.getSize();

        final var xDelta = (percentageX / 100) * tamanio.getWidth();
        final var yDelta = (percentageY / 100) * tamanio.getHeight();

        final var x = (int) (ubicacion.getX() + xDelta);
        final var y = (int) (ubicacion.getY() + yDelta);

        return new Point(x, y);
    }

}
