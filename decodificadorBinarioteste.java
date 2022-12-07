
/**
 * Decodificador de binário.
 * 
 * @author (Luís Gabriel e Sabrina Souza) 
 * @version (16/10/2022)
 */
import java.util.*;

public class decodificadorBinarioteste
{
    public static void main (String[]args){
         Scanner entrada=new Scanner(System.in);
         System.out.print("\f");
         
         boolean continuar = true;
         
         do {
             System.out.print("Digite um número em binário: ");
             String binario = entrada.next();
             
             System.out.print("Infome a quantidade de bits: ");
             int bits = entrada.nextInt();
                 
             helperMethod(binario, bits);
             
             System.out.print("\nGostaria de continuar? ");
             String continuarBinario = entrada.next().toLowerCase();
             
             if(continuarBinario.equals("não") || continuarBinario.equals("nao") || continuarBinario.equals("n") || continuarBinario.equals("no")){
                 continuar = false;
                 System.out.print("Programa finalizado.");
              }
             System.out.print("\n");          
          }while(continuar);
     }
    
    public static void helperMethod(String binario, int bits){
        System.out.println("\nInteiro sem sinal: " + conversorSemSinal(binario, bits));
        System.out.println("Inteiro em complemento de dois: " + conversorComplementoDeDois(binario, bits));
        if(bits>=6 && bits<=8){
            System.out.println("Caracter em ASCII: " + conversorASCii(binario, bits));
         }
     }
    
    public static boolean testaConsistencia(String binario, int bits) {
        boolean resultado = (binario.length() == bits);
        return resultado;
     }
    
    public static int conversorSemSinal (String binario, int bits) {
        int acumulador = 0;
        for(int i=binario.length()-1; i>=0; i--){
            int expoente = (binario.length()-1) - i;
            if(binario.charAt(i) == '1'){                
                acumulador = acumulador + (int)Math.pow(2, expoente);
             }
         }
        return acumulador;
     }
    
    public static int conversorComplementoDeDois (String binario, int bits) {
        int acumulador = 0;
        for(int i=binario.length()-1; i>=1; i--){
            int expoente = (binario.length()-1) - i;
            if(binario.charAt(i) == '1'){                
                acumulador = acumulador + (int)Math.pow(2, expoente);
             }
         }
        if(binario.charAt(0) == '1'){
            acumulador = acumulador - (int)Math.pow(2, bits-1);
         }
        return acumulador;        
     }
    
    public static char conversorASCii (String binario, int bits) {
        int decimal = conversorSemSinal(binario, bits);
        char c=(char)decimal;
        return c;        
     }
 }