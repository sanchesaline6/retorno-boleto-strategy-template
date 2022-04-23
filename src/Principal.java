
import entities.LeituraRetornoBancoBrasil;
import entities.LeituraRetornoBradesco;
import entities.ProcessadorBoletos;

import java.net.URI;
import java.net.URISyntaxException;


public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Boletos Banco do Brasil");
        ProcessadorBoletos processadorBancoBrasil = new LeituraRetornoBancoBrasil();
        String arquivoBancoBrasil = "C:\\Users\\aline\\Desktop\\IFTO\\2022-1\\Padrões de Projetos\\Template Method\\RetornoBoletoStrategyTemplate\\src\\resources\\banco-brasil-1.csv";
        processadorBancoBrasil.processar(arquivoBancoBrasil);

        System.out.println();

        System.out.println("Boletos Bradesco");
        ProcessadorBoletos processadorBradesco = new LeituraRetornoBradesco();
        String arquivoBradesco = "C:\\Users\\aline\\Desktop\\IFTO\\2022-1\\Padrões de Projetos\\Template Method\\RetornoBoletoStrategyTemplate\\src\\resources\\bradesco-1.csv";
        processadorBradesco.processar(arquivoBradesco);
    }
}