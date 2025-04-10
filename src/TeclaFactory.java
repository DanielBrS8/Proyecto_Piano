import bpc.daw.consola.Teclado;

public class TeclaFactory {

    private TeclaFactory(){}

    public static Tecla CrearTecla(int nota){

        int resto = nota/12;



        Tecla tecla = switch (resto){

            case 0,5-> new TeclaBlanca1(nota);
            case 1,3,6,8,10->new TeclaNegra(nota);
            case 2,7,9->new TeclaBlanca2(nota);
            case 4,11->new TeclaBlanca3(nota);


            default -> throw new IllegalStateException("Valor introducido incorrecto " + resto);
        };

        return tecla;

    }

}
