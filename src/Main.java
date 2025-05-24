import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcao = 0;

        ConverteMoeda converteMoeda = new ConverteMoeda();
        SetCurrencyCode setCode = new SetCurrencyCode();
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("00.00");

        System.out.println("""
                       *****************************************
                           Bem vindo ao conversor de moedas!\s
                
                               1- Dolar >> Real \s
                               2- Real >> Dolar\s
                               3- Real >> Won Sul Coreano\s
                               4- Won Sul Coreano >> Real\s
                               5- Real >> Iene\s
                               6- Iene >> Real\s
                               7- Sair\s
                                
                       *****************************************      
                
                """);


        while (opcao != 7) {
            System.out.println("Ecolha uma opção do menu:");
            try {
                opcao = entrada.nextInt();
                if(opcao == 7){
                    System.out.println("Encerrando a aplicação!");
                    break;
                }
                if (opcao < 1 || opcao > 7) {
                    System.out.println("Opção inválida! Escolha um número entre 1 e 7.");
                    continue;
                }
                setCode.EscolheCodigoDeCambio(opcao);
                entrada.nextLine();
                System.out.println("Digite o  valor para converter:");
                String valorInserido = entrada.nextLine();
                double valorNumerico;
                try {
                    valorNumerico = Double.parseDouble(valorInserido.replace(",", "."));
                } catch (NumberFormatException e) {
                    System.out.println("O valor digitado é inválido! Insira um valor novamente");
                    continue;
                }

                setCode.setValorMontante(String.valueOf(valorNumerico));

                try {
                    DadosDeCambio novoDadosDeCambio = converteMoeda.FazCambio(setCode.getMoedaBase(),
                            setCode.getMoedaAlvo(), setCode.getValorMontante());
                    if (novoDadosDeCambio != null) {
                        System.out.println("Convertendo de : " + novoDadosDeCambio.baseCode() + "  Para: "+ novoDadosDeCambio.targetCode() );
                        System.out.println("Valor a ser convertido: " + valorInserido);
                        double valorEmDouble = Double.parseDouble(novoDadosDeCambio.conversionResult());
                        System.out.println("Valor convertido: " + df.format(valorEmDouble));

                    } else {
                        System.out.println("Não foi possível realizar a converção," +
                                " verifique os logs para mais detalhes.");
                    }
                } catch (IOException | InterruptedException | URISyntaxException e) {
                    System.out.println("Erro de comunicação com a API: " + e.getMessage());
                    System.out.println("Verifique sua conexão com a internet e tente novamente.");
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inexperado durante a converção: " + e.getMessage());
                    e.printStackTrace();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para a opção do menu. Digite um número inteiro!");
                entrada.nextLine();
            }
        }
    }
}
