package br.com.crescer.aula01;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chris
 */
public class TemaParcelator implements Parcelator {
    
    private final SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private final Calendar calendar = Calendar.getInstance();
    Map<String, BigDecimal> parcelatorHashMap = new HashMap<>();
    
    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        calendar.setTime(dataPrimeiroVencimento);
        //supondo que taxaJuros venha como padrão entre 0 e 1
        BigDecimal juros = new BigDecimal(taxaJuros);
        BigDecimal parcelas = new BigDecimal(numeroParcelas);
        BigDecimal valorTotalComJuros = ((juros.multiply(valorParcelar)));
        String valorMensal = (valorTotalComJuros.divide(parcelas,2, BigDecimal.ROUND_HALF_UP)).toString();
        
        for (int a = 1; a <= numeroParcelas; a++){
            System.out.println(a + ". " + calendar + " - R$" + valorMensal);
            calendar.add(Calendar.MONTH, 1);
        }
        
        return parcelatorHashMap;
    }
    
}
