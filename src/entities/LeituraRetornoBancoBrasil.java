package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do Banco do Brasil.
 * Esta classe usa o padrão Strategy, representando a implementação da estratégia {@link LeituraRetorno}.
 *
 * @author Manoel Campos da Silva Filho
 */
// tag::class-start[]
public class LeituraRetornoBancoBrasil extends ProcessadorBoletos {


    @Override
    protected Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.from(LocalDate.parse(vetorLinhaArq[3], FORMATO_DATA).atTime(0,0,0)));
        boleto.setCpfCliente(vetorLinhaArq[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[7]));
        return boleto;
    }
}
// end::class-end[]