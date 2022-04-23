package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ProcessadorBoletos {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public final List<Boleto> processar(String nomeArquivo){

        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = processarLinhaArquivo(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }

            return boletos;
        }
        catch (IOException ex){
            throw new UncheckedIOException(ex);
        }
    }

    protected abstract Boleto processarLinhaArquivo(String[] vetorLinhaArq);
}