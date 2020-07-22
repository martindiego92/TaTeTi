
import java.util.Scanner;

public class game {

    static String x;
    static String y;
    static int xNum;
    static int yNum;
    static int cont;
    static int total;

    public static void main(String[] args) {

        boolean finish = false;

        game(finish);
        //recorrerMatriz(matriz,m,n);

    }

    public static void game(boolean finishGame) {
        Scanner scan = new Scanner(System.in);
        final int m = 3;
        final int n = 3;
        char[][] matriz = new char[m][n];
        int [][] matrizInt = new int [m][n];
        recorrerMatriz(matriz, m, n);
        
        while (finishGame != true) {
          
            

            insertarCoordenada(x, y, scan);
            //  System.out.println(Integer.valueOf(x));
            Agregar(xNum, yNum, matriz);
            
            finishGame=chequeoColision(m, n, matriz, matrizInt);
            //agregarX();
            //ingresar una coordenada y comprobar que se pueda
            //comprobar que no hay ganador
            //pedir otro
        }

    }

    public static void Agregar(int x, int y, char[][] matriz) {
       boolean con=false;
 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == x && j == y) {
                    if (((Character.getNumericValue(matriz[i][j]) != 33 && Character.getNumericValue(matriz[i][j]) != 24)
                            || (matriz[i][j] == ' '))) {
                        if (cont % 2 == 0) {
                            matriz[i][j] = 'X';
                            cont++;
                            con=true;
                           
                            mostrarMatriz(matriz, 3, 3);
                        } else {
                            matriz[i][j] = 'O';
                            cont++;
                            con=true;
                           
                            mostrarMatriz(matriz, 3, 3);
                        }
                    }
                    else
                    {
                        con=false;
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            }
        }

       }
    
    public static void insertarCoordenada(String x, String y, Scanner scan) {
        System.out.println("Enter the coordinates: ");
        x = scan.nextLine();
        y = scan.nextLine();
        boolean isDigit = false;
        boolean isBetween = false;
        boolean canContinue;
        while (isDigit == false || isBetween == false) {
            isDigit = chequeoisDigit(x, y);
            isBetween = chequeoChoords(x, y);

            if (isDigit == true && isBetween == true) {
                //System.out.println("entro");
                xNum = Integer.parseInt(x);
                yNum = Integer.parseInt(y);
            } else {
                System.out.println("Enter the coordinates: ");
                x = scan.next();
                y = scan.next();
                isDigit = false;
                isBetween = false;
            }
        }
    }

    public static boolean chequeoisDigit(String x, String y) {
        try {

            int xTry = Integer.valueOf(x);
            int yTry = Integer.valueOf(y);
            //System.out.println("Son numeros");
            return true;
        } catch (NumberFormatException e) {
           // System.out.println("No son numeros");
            System.out.println("You should enter numbers!");
            return false;
        }
    }

    public static boolean chequeoChoords(String x, String y) {
        try {
            if (Integer.valueOf(x)<0 && Integer.valueOf(x) > 2
                    && Integer.valueOf(y)<0 && Integer.valueOf(y) > 2) {
               // System.out.println("Es etrne 1 y 3");
                return false;
            } else {
              //  System.out.println("te pasaste");
                return true;

            }
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static void recorrerMatriz(char[][] matriz, int m, int n) {
        System.out.println("---------");
        for (int i = 0; i < m; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {
                matriz[i][j] = ' ';
                System.out.print(" " + matriz[i][j]);
            }
            System.out.print(" |");
            System.out.println();

        }
        System.out.println("---------");

    }
    public static void mostrarMatriz(char[][] matriz, int m, int n)
    {
     System.out.println("---------");
        for (int i = 0; i < m; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {
                //matriz[i][j] = ' ';
                System.out.print(" " + matriz[i][j]);
            }
            System.out.print(" |");
            System.out.println();

        }
        System.out.println("---------");

    
    }
   
    public static boolean chequeoColision(int m, int n, char [][] matriz,int[][] matrizInt)
    {
            
            for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrizInt[i][j] = Character.getNumericValue(matriz[i][j]);
                total=matrizInt[i][j]+total;
                
            }

            }
     if ((matrizInt[0][0] + matrizInt[0][1] + matrizInt[0][2] == 99
                || matrizInt[1][0] + matrizInt[1][1] + matrizInt[1][2] == 99
                || matrizInt[1][0] + matrizInt[1][1] + matrizInt[1][2] == 99
                || matrizInt[2][0] + matrizInt[2][1] + matrizInt[2][2] == 99
                || matrizInt[0][0] + matrizInt[1][0] + matrizInt[2][0] == 99
                || matrizInt[0][1] + matrizInt[1][1] + matrizInt[2][1] == 99
                || matrizInt[0][0] + matrizInt[1][1] + matrizInt[2][2] == 99
                || matrizInt[0][2] + matrizInt[1][1] + matrizInt[2][0] == 99)) 
     {
             System.out.println("X wins");
             return true;

        }

        if ((matrizInt[0][0] + matrizInt[0][1] + matrizInt[0][2] == 72
                || matrizInt[1][0] + matrizInt[1][1] + matrizInt[1][2] == 72
                || matrizInt[2][0] + matrizInt[2][1] + matrizInt[2][2] == 72
                || matrizInt[0][0] + matrizInt[1][0] + matrizInt[2][0] == 72
                || matrizInt[0][1] + matrizInt[1][1] + matrizInt[2][1] == 72
                || matrizInt[0][2] + matrizInt[1][2] + matrizInt[2][2] == 72
                || matrizInt[0][0] + matrizInt[1][1] + matrizInt[2][2] == 72
                || matrizInt[0][2] + matrizInt[1][1] + matrizInt[2][0] == 72)) {
            
              System.out.println("O wins");
              return true;
        }
        if(total==261)
        {
            System.out.println("Draw");
            return true;
        }
            return false;
      
        //System.out.println(contX);
    
        
    }
}
