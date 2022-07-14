package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.exceptions.SaleNotFoundException;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Registra a classe como component Service.
public class SmsService {

    @Value("${twilio.sid}") // Annotation que busca a variável de ambiente definida no application.properties.
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    SaleRepository saleRepository;

    // Modelo de teste da Documentação da Twilio:
    public void sendSms() {
        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, "Teste").create();

        System.out.println("Mensagem enviada com sucesso. Id:" + message.getSid());
    }

    // Busca uma venda por id e a envia por SMS:
    public void sendSaleBySms(Long saleId) {

        // O Optional nos ajuda a evitar NullPointerExceptions. Verificar o próximo if:
        Optional<Sale> sale = saleRepository.findById(saleId); // Busca a venda por ID.

        StringBuilder msg = new StringBuilder();

        // Aqui validamos se o sale está presente, ou seja, se foi encontrado alguma valor:
        if (!sale.isPresent()) {
            throw new SaleNotFoundException(saleId);
        }

        // Exemplo de concatenação com String:
        String date = sale.get().getDate().getDayOfMonth() + "/" + sale.get().getDate().getMonthValue()
                + "/" + sale.get().getDate().getYear();
        String amount = String.format("%.2f", sale.get().getAmount());

        // Utilizei StringBuilder pois quando concatenamos novas string para o mesmo objeto não são criadas cópias dos
        // objetos como é realizado no métoco concat da classe String (verificar exemplo de date). Isso contribui para
        // um melhor desempenho do sistema:
        msg.append("A venda ")
                .append(saleId)
                .append(" foi realizada pelo vendedor(a) ")
                .append(sale.get().getSellerName())
                .append(" na data de ")
                .append(date)
                .append(" no total de R$")
                .append(amount);

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg.toString()).create();

        System.out.println("Mensagem enviada com sucesso. Id:" + message.getSid());
    }
}
