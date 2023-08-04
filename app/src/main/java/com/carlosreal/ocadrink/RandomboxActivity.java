package com.carlosreal.ocadrink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomboxActivity extends AppCompatActivity {

    private List<String> ListaFrases = new ArrayList<>();
    TextView Response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randombox);
        ListaFrases.add("CONFESIÓN! Cuenta algo que te de vergüenza. \uD83D\uDE33");
        ListaFrases.add("Tira de nuevo y bebe. \uD83C\uDF7A");
        ListaFrases.add("\uD83D\uDD25 Quita 1 PRENDA al de tu derecha con la BOCA \uD83D\uDD25");
        ListaFrases.add("PACO SAYS. Juego de Paco dice de aquí en adelante en la partida. El que pierda bebe 1 TRAGO del MORTUS ☠️\uD83C\uDF78 y se acaba el Paco Says.");
        ListaFrases.add("\uD83E\uDE77 POSTURA SEXUAL FAV \uD83E\uDE77 Demuestra tus dotes de actor y REPRESÉNTALA con alguien elegido al azar. \uD83C\uDF7E");
        ListaFrases.add("Cuack cuack");
        ListaFrases.add("\uD83D\uDCDB STOP \uD83D\uDCDB Elige un tema y cada jugador va diciendo 1 palabra. El que se quede sin ideas bebe.");
        ListaFrases.add("\uD83D\uDCA6 ERES OTAKU \uD83D\uDCA6 Tienes 6 seg de ventaja antes de que te mojemos. La cuenta atrás empieza....YA!!!");
        ListaFrases.add("RRSS \uD83D\uDCF2 Publica por 15 MIN en tu historia un SELFIE con la persona de tu izquierda y un \"Te quiero amor ❤️\". Si es tu novi@, el grupo elige otro jugador.");
        ListaFrases.add("3/2/1...RETO⏳. Tú y otro jugador diréis un NÚMERO del 1 al 3. Si es el mimo, te imponen un reto.");
        ListaFrases.add("\uD83C\uDF38\uD83D\uDC1A MARICONCHIS \uD83D\uDC1A\uD83C\uDF38 Intercámbiate una prenda con un jugador del sexo contrario.");
        ListaFrases.add("\uD83D\uDE80 TP A LA 55 \uD83D\uDEF0️(y cúmplela).");
        ListaFrases.add("BESO NENUCO \uD83D\uDC69\uD83C\uDFFB\u200D\uD83E\uDDB2\uD83D\uDC8B Toma suerte de la calva de un calv@.");
        ListaFrases.add("\uD83D\uDC45 RECITAL DE TRABALENGUAS \uD83D\uDC45 Di uno 3 veces. Si te equivocas bebes 3 tragos.");
        ListaFrases.add("\uD83D\uDE80 TP A LA 17 \uD83D\uDEF0️(y cúmplela).");
        ListaFrases.add("CHUPITO PELUDITO. Bebe un chupito del ombligo del 4° jugador a tu derecha.\uD83E\uDED7");
        ListaFrases.add("Si te gustan las ACEITUNAS, bebes \uD83E\uDED2.");
        ListaFrases.add("TEAM COLACAO vs TEAM  NESQUIK. Minoría beben todos 1 trago. \uD83C\uDF76");
        ListaFrases.add("CONCURSO DE ALAGOS \uD83D\uDC90. Cada jugador dice un alago, y 1 juez indica el ganador, todos los demás beben 1 trago.");
        ListaFrases.add("Hola, soy Paco Drink, y creo que has hecho TRAMPAS, así que... empiezas de nuevo. TP a la casilla de salida. \uD83C\uDF40\uD83D\uDE80");
        ListaFrases.add("Si MENTISTE durante la partida, BEBES. \uD83E\uDD10");
        ListaFrases.add("\uD83D\uDE80 TP A LA 40 \uD83D\uDEF0️(eres pres@).");
        ListaFrases.add("\uD83D\uDE80 TP A LA 40 \uD83D\uDEF0️(eres visita).");
        ListaFrases.add("Beben TODOS los nacidos entre \uD83C\uDF7B Enero y Junio. \uD83C\uDF7B");
        ListaFrases.add("Beben TODOS los nacidos entre \uD83E\uDD42 Julio y Diciembre. \uD83E\uDD42");
        ListaFrases.add("MALDICIÓN \uD83C\uDF3F. Ahora solo podrás caer en casillas IMPARES. La única forma de eliminarla, es si te vas al cementerio (30).");
        ListaFrases.add("\uD83C\uDDFA\uD83C\uDDF8 BORRACHERA AMERICANA \uD83C\uDDFA\uD83C\uDDF8. Termínate la copa haciendo el pino. Si no lo consigues en 2min, retrocedes 5 casillas.");
        ListaFrases.add("Donale 1 trago al MORTUS. \uD83E\uDD43");
        ListaFrases.add("Hola, soy Paco Drink. Como me has caído tan bien, te dejo avanzar a la casilla 60. \uD83E\uDEBF\uD83E\uDDE1");
        ListaFrases.add("\uD83D\uDD11 QUEDAS LIBRE DE LA CÁRCEL \uD83D\uDD11 Paco Drink ha encontrado una llave maestra y te la ha dado. Puedes usarla cuando quieras o venderla.");
        ListaFrases.add("REBE HA ROBADO EN UNA TIENDA \uD83D\uDE94\uD83D\uDCB0, y tu eres cómplice, por ello, tu vuelves a la casilla de salida y Rebeca paga 1 trago al mortus. \n" +
                "(Si eres Rebeca, pagas 2 tragos al mortus)");

        int RandomIndex = GetRandomIndex(ListaFrases.size());
        String RandomString = ListaFrases.get(RandomIndex);
        Response = findViewById(R.id.FraseRandom);
        Response.setText(RandomString);

    }

    private int GetRandomIndex(int Max) {
        // Generar un índice aleatorio entre 0 y (max - 1)
        Random RandomNum = new Random();
        return RandomNum.nextInt(Max);
    }
}